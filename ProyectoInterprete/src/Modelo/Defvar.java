package Modelo;

import Modelo.Stack.StackVector;

import java.util.*;

public class Defvar {

	private HashMap<String, StackVector<String>> variables = new HashMap<>();

	/**
	 * Funcion para las variables
	 * Se guardan en un HashMap
	 * @param nombre
	 */
	//Metodo para definir una variable
	public void Defvar(String nombre) {
		StackVector<String> valor = new StackVector<>();
		variables.put(nombre, valor);
	}

	public String getVariable(String nombre, boolean temp) {
		if (existe(nombre)){
			StackVector<String> valores = variables.get(nombre);
			String valor;
			return valor = temp ? valores.pop() : valores.peek();// peek si es permanente, pop si es temporal
		}
		else {
			return null;
		}
	}

	/**
	 *
	 * @param nombre String del nombre
	 * @param valor String del valor
	 * @param temp boolean
	 */
	public void SetQ(String nombre, String valor, boolean temp){
		StackVector<String> valores = variables.get(nombre);
		if (temp){
			valores.push(valor);
		}
		else {
			if (valores.size() == 0){
				valores.push(valor);
			}else{
				valores.pop();
				valores.push(valor);
			}
		}
		variables.put(nombre, valores);
	}

	public boolean existe(String nombre){
		return variables.containsKey(nombre);
	}
}
