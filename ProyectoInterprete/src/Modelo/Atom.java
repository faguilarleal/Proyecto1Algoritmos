package Modelo;

import java.util.*;

public class Atom {
	private static boolean b;
	public Atom() {
		
	}
	
	public boolean ATOM(ArrayList<String> expresion) {
		int ultimo = expresion.size()-1;
		for(int i = 1; i<expresion.size();i++) 
		{
			if(expresion.size()== 0) {
				b = false;
			}
			else if(expresion.get(i).equals("(") && expresion.get(ultimo).equals(")")) 
			{
				b = false;
			}else {
				b = true;
			}
		}
		return b;
	}
	
}
