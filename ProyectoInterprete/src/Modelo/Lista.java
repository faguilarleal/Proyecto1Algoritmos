package Modelo;

import java.util.*;
public class Lista {
	private static String st = new String();
	public Lista() {
		
	}
	
	public List<String> LIST(ArrayList<String> expresion) {
		List<String> lista = new ArrayList<>();
		for(int i = 1; i<expresion.size();i++ ) 
		{
			while (!expresion.get(i).equals(")")) {
				lista.add(expresion.get(i));
			}
		}
		return lista;
	}
	
}
