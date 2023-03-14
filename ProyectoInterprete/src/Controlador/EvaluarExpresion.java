package Controlador;
import java.util.ArrayList;
import java.util.List;

public class EvaluarExpresion {

    /**
     * Se crea una lista de objetos para que se pueda hacer una lista de listas (cuantas sean necesarias)
     * @param expresion
     * @return
     */
    public ArrayList<Object> parseExpresion(ArrayList<String> expresion){
        ArrayList<Object> expParseada = new ArrayList<>();

        for (int i = 0; i < expresion.size() ; i++) {

            if (expresion.get(i).equals("(")){

                // estamos buscando donde cierra el parentesis

                int Pos2 = 0;   // posicion de ), la posicion de ( es i
                int contP1 = 1; // contador de parentesis ( , empieza en 1 porque se sabe que estamos viendo una lista
                int contP2 = 0; // contador de parentesis )
                for (int j = i+1; j < expresion.size(); j++) {
                    String token = expresion.get(j);
                    if (token.equals("(")){
                        contP1 ++;
                    }
                    if (token.equals(")")){
                        Pos2 = j;
                        contP2 ++;
                    }
                    if (contP1 == contP2){
                        List<String> sub = expresion.subList(i+1, Pos2);
                        ArrayList<String> temp = new ArrayList<>(sub);
                        expParseada.add(parseExpresion(temp)); // recursivo
                        for (int k = i+1; k < Pos2+1; k++) {
                            expresion.remove(1);
                        }
                    }
                }
            }else{
                expParseada.add(expresion.get(i));
            }
        }

        return expParseada;
    }
}
