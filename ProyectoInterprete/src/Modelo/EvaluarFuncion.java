package Modelo;

import java.util.*;

public class EvaluarFuncion
{

	private Quote q = new Quote();
	private OperacionesAritmeticas operArit = new OperacionesAritmeticas();

	private Defvar defV = new Defvar();


	public String evaluarlista(ArrayList<Object> obj) {
		if (obj.isEmpty()) {
			return null;
		} else {
			if (atomExp(obj.get(0))) {
				String funct = (String) obj.get(0); // se castea la funcion
				if (funct.equals("+") || funct.equals("-") || funct.equals("*") || funct.equals("/")) {
					Object o1 = obj.get(1);
					Object o2 = obj.get(2);
					if (!atomExp(o1)) {
						o1 = evaluarlista((ArrayList<Object>) o1);
					}
					if (!atomExp(o2)) {
						o2 = evaluarlista((ArrayList<Object>) o2);
					}
					return operArit.evaluate(funct, (String) o1, (String) o2);
				}
				if (funct.equals("QUOTE") || funct.equals("'")) {
					if (atomExp(obj.get(1))) {
						return (String) obj.get(1); // si es un atom solo regresa el objeto que seria un string
					} else {
						return q.quote((ArrayList<Object>) obj.get(1)); // si no es un atomo se manda a llamar a la funcion quote
					}
				}
				if (funct.equals("EQUAL") || funct.equals("<") || funct.equals(">")) {
					Object o1 = obj.get(1);
					Object o2 = obj.get(2);
					if (!atomExp(o1)) {
						o1 = evaluarlista((ArrayList<Object>) o1);
					}
					if (!atomExp(o2)) {
						o2 = evaluarlista((ArrayList<Object>) o2);
					}
					return booleanLisp(funct, (String) o1, (String) o2); // return T / NIL
				}
				if (funct.equals("COND")) {
					String b = evaluarlista((ArrayList<Object>) obj.get(1));
				}
				if (funct.equals("LIST")) {
					return null;
				}
				if (funct.equals("DEFVAR")) {
					defV.Defvar((String) obj.get(1));
					return null;
				}
				if (funct.equals("SETQ")) {
					String variable = (String) obj.get(1);
					String valor = (String) obj.get(2);
					defV.SetQ(variable, valor, false);
					return null;
				} else {
					return null;
				}

			} else {
				return null;
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
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		switch (f){
			case "EQUALS":
				v = a == b;
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

	public Object parseToken(String token) 
	{
		try 
		{
			return Double.parseDouble(token);
	    } catch (NumberFormatException e) 
		{
	        	return token;
	    }
	}
}
