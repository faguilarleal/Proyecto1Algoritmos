package Controlador;

import Modelo.Defvar;
import Modelo.Functions;
import Modelo.OperacionesAritmeticas;
import Modelo.Quote;

import java.util.*;

public class EvaluarFuncion
{
	private Quote q = new Quote();
	private OperacionesAritmeticas operArit = new OperacionesAritmeticas();
	private Functions functClass = new Functions();

	private Defvar defV = new Defvar();


	public String evaluarlista(ArrayList<Object> obj, boolean tempV) {

		if (obj.isEmpty()) {
			return null;
		} else {
			if (atomExp(obj.get(0))) {
				String funct = (String) obj.get(0); // se castea la funcion

				// si es aritmetica
				if (funct.equals("+") || funct.equals("-") || funct.equals("*") || funct.equals("/")) {
					Object o1 = obj.get(1);
					Object o2 = obj.get(2);
					// recursividad, en caso de que haya otra evaluacion
					if (!atomExp(o1)) {
						o1 = evaluarlista((ArrayList<Object>) o1, tempV);
					}
					if (!atomExp(o2)) {
						o2 = evaluarlista((ArrayList<Object>) o2, tempV);
					}
					// si son variables
					if (isInteger(o1) & isInteger(o2)){ // si los dos son int solo se opera
						return operArit.evaluate(funct, (String) o1, (String) o2);
					}else {
						if (!isInteger(o1)){ //si o1 es variable buscarla en hashmap
							o1 = defV.getVariable((String) o1, tempV);
						}
						if (!isInteger(o2)){ //si o2 es variable buscarla en hashmap
							o2 = defV.getVariable((String) o2, tempV);
						}
						if (o1 != null & o2 != null){ // en caso de que ninguna de las dos returne null se opera con los valores obtenidos
							return operArit.evaluate(funct, (String) o1, (String) o2);
						}else{
							return "INVALID VARIABLE";
						}
					}

				}

				// si es quote
				else if (funct.equals("QUOTE") || funct.equals("'")) {
					if (atomExp(obj.get(1))) {
						return (String) obj.get(1); // si es un atom solo regresa el objeto que seria un string
					} else {
						return q.quote((ArrayList<Object>) obj.get(1)); // si no es un atomo se manda a llamar a la funcion quote
					}
				}

				// si es equal
				else if (funct.equals("EQUAL") || funct.equals("<") || funct.equals(">")) {
					Object o1 = obj.get(1);
					Object o2 = obj.get(2);
					if (!atomExp(o1)) {
						o1 = evaluarlista((ArrayList<Object>) o1, tempV);
					}
					if (!atomExp(o2)) {
						o2 = evaluarlista((ArrayList<Object>) o2, tempV);
					}
					// si es variable
					if (isInteger(o1) & isInteger(o2)){ // si los dos son int solo se opera
						return booleanLisp(funct, (String) o1, (String) o2);
					}else {
						if (!isInteger(o1)) { //si o1 es variable buscarla en hashmap
							o1 = defV.getVariable((String) o1, tempV);
						}
						if (!isInteger(o2)) { //si o2 es variable buscarla en hashmap
							o2 = defV.getVariable((String) o2, tempV);
						}
						if (o1 != null & o2 != null) { // en caso de que ninguna de las dos returne null se opera con los valores obtenidos
							return booleanLisp(funct, (String) o1, (String) o2);// return T / NIL
						} else {
							return "INVALID VARIABLE";
						}
					}
				}

				// cond
				else if (funct.equals("COND")) {
					String cond = evaluarlista((ArrayList<Object>) obj.get(1), tempV);
					if (cond.equals("T")){
						if (atomExp(obj.get(2))){
							String valorVerdadero = (String) obj.get(2);
							if (!isInteger(valorVerdadero)) { //si o1 es variable buscarla en hashmap
								valorVerdadero = defV.getVariable((String) valorVerdadero, tempV);
							}
							return (String) valorVerdadero;
						}else {
							return evaluarlista((ArrayList<Object>) obj.get(2), tempV);
						}
					} else {
						if (obj.size() == 4){
							if (atomExp(obj.get(3))){
								String valorFalso = (String) obj.get(3);
								if (!isInteger(valorFalso)) { //si o1 es variable buscarla en hashmap
									valorFalso = defV.getVariable((String) valorFalso, tempV);
								}
								return (String) valorFalso;
							}else {
								return evaluarlista((ArrayList<Object>) obj.get(3), tempV);
							}
						}else {
							return "";
						}
					}

				}

				else if (funct.equals("ATOM")){
					if (atomExp(obj.get(1))){
						return "T";
					}else {
						return "NIL";
					}
				}

				else if (funct.equals("LIST")) {
					return null;
				}
				else if (funct.equals("DEFVAR")) {
					defV.Defvar((String) obj.get(1));
					return (String) obj.get(1);
				}
				else if (funct.equals("SETQ")) {
					String variable = (String) obj.get(1);
					String valor = (String) obj.get(2);
					defV.SetQ(variable, valor, tempV);
					return (String) obj.get(1);
				}
				else if (funct.equals("DEFUN")){
					String nombre = (String) obj.get(1);
					if (functClass.funcionExiste(nombre)){
						return "FUNCION EXISTENTE";
					}else {
						ArrayList<Object> valores = new ArrayList<>();
						valores.add(obj.get(2));
						valores.add(obj.get(3));
						functClass.crearFuncion(nombre, valores);
						return null;
					}
				}
				else {
					if (functClass.funcionExiste(funct)){
						ArrayList<Object> exp = functClass.getExp(funct);
						ArrayList<Object> variables = functClass.getParams(funct);
						ArrayList<Object> params = (ArrayList<Object>) obj.get(1);
						if (((String) params.get(0)).equals("+") || ((String) params.get(0)).equals("-") || ((String) params.get(0)).equals("/")|| ((String) params.get(0)).equals("*")){
							String valorV = evaluarlista(params, false);
							String nameV = (String) variables.get(0);
							if (!defV.existe(nameV)){
								defV.Defvar(nameV);
							}
							defV.SetQ(nameV,valorV, false);
							return evaluarlista(exp, false);
						}else{
						// agarrar los valores de parametros
							if (variables.size() == params.size()){
								for (int i = 0; i < variables.size(); i++) {
									String nameV = (String) variables.get(i);
									String valorV = (String) params.get(i);
									if (!defV.existe(nameV)){
										defV.Defvar(nameV);
									}
									defV.SetQ(nameV,valorV, false);
								}
							return evaluarlista(exp, false);

							} else {
								return "NUMERO DE PARAMETROS INVALIDO";
							}
						}
					}else{
						return "FUNCION INVALIDA";
					}
				}

			} else {
				return evaluarlista((ArrayList<Object>) obj.get(0), tempV);
			}
		}

	}

	/**
	 * Es para verificar si el valor es un atom o si se necesita recursividad
	 * @param token
	 * @return boolean
	 */
	public boolean atomExp(Object token){
		boolean atom = false;
		if (token instanceof String){ // si es un string no se puede dividir en mas
			atom = true;
		}
		return atom;
	}

	public String booleanLisp(String f, String a, String b){
		boolean v = false;
		double A = Double.parseDouble(a);
		double B = Double.parseDouble(b);
		switch (f){
			case "EQUAL":
				v = a.equals(b);
				break;
			case "<":
				v = A < B;
				break;
			case ">":
				v = A > B;
				break;

		}
		return v ? "T" : "NIL";
	}

	public boolean isInteger(Object token){
		boolean isInt = false;
		try	{
			Double numero = (Double.parseDouble((String) token));
			isInt = true;
		}catch (NumberFormatException e){

		}
		return isInt;
	}


}
