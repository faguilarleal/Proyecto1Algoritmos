package Modelo;
import java.util.*;

public class Quote {
	//Constructor
    public Quote(){

    }

    //Metodo que devuelve como String cada elemento luego de la palabra QUOTE o '
    public String QUOTE(ArrayList<Object> expresion){
    	String quote = "";
    	for(int i =1; i<expresion.size();i++) 
    	{
    		//Se empieza a concatenar los elementos de expresion en quote, luego de la primera posicion que es donde se encuentra la palabra reservada QUOTE
    		quote += expresion.get(i) + "";
    	}
    	return quote; //Retorna quote borrando espacios en blanco del principio o fin de la expresion
    }

    /**
     * Convierte una lista de objetos en un string
     * @param expresion
     * @return
     */
    public String quote(ArrayList<Object> expresion){
        StringBuilder sb = new StringBuilder();
        for (Object str : expresion) {
            sb.append((String) str);
            sb.append(" ");
        }

        return "( "+ sb +" )";
    }
}
