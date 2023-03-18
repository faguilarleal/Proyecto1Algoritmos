package Controlador;
import Modelo.Defvar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluarExpresion {

    Defvar df = new Defvar();
    private EvaluarFuncion evalFuncion = new EvaluarFuncion();
    /**
     * Se crea una lista de objetos para que se pueda hacer una lista de listas (cuantas sean necesarias)
     * @param expresion
     * @return
     */

    // ( 9 )
    public ArrayList<Object> parseExpresion(ArrayList<String> expresion){
        ArrayList<Object> expParseada = new ArrayList<>();
        for (int i = 0; i < expresion.size() ; i++) {
            if (expresion.get(i).equals("(")){

                // estamos buscando donde cierra el parentesis
                int Pos1 = i;
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
                        if (expresion.get(0).equals("DEFUN")){ // defun es el unico que tiene 4 elementos
                            expresion.remove(0);
                        }
                        for (int k = Pos1+1; k < Pos2+1; k++) { // se elimina lo que ya se evaluo
                            expresion.remove(1);
                        }
                        j = expresion.size();
                    }
                }
            }else{
                expParseada.add(expresion.get(i));
            }
        }

        return expParseada;
    }

    public String evalExp(String exp){
        ArrayList<String> expL = new ArrayList<String>(Arrays.asList(exp.split(" ")));
        ArrayList<Object> p1 = parseExpresion(expL); // expresion parseada
        return evalFuncion.evaluarlista(p1,false, df);
    }


}
