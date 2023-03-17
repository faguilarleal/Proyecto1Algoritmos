package Vista;

import Controlador.EvaluarExpresion;
import Modelo.LectorArchivo;

import java.io.IOException;
import java.util.ArrayList;

public class Compilador {
    private LectorArchivo fileReader = new LectorArchivo();
    private EvaluarExpresion evalExpresion = new EvaluarExpresion();

    public void menu() throws IOException {
        ArrayList<String> expresiones = fileReader.LeerArchivo();
        for (String exp:expresiones) {
            System.out.println(evalExpresion.evalExp(exp));
        }

    }
}
