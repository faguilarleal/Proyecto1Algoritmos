package Modelo;
import java.util.*;

public class Quote {
	//Constructor
    public Quote(){

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
