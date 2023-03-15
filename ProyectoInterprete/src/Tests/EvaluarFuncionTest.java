package Tests;

import Controlador.EvaluarExpresion;
import Modelo.EvaluarFuncion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EvaluarFuncionTest {

    @Test
    void evaluarlista() {
        EvaluarExpresion e = new EvaluarExpresion();
        EvaluarFuncion f = new EvaluarFuncion();
        String exp = "( DEFVAR X ) ( SETQ X 10 )";
        ArrayList<String> expL = new ArrayList<String>(Arrays.asList(exp.split(" ")));
        ArrayList<Object> prueba = e.parseExpresion(expL); // expresion parseada
        String r = (String) f.evaluarlista((ArrayList<Object>) prueba.get(0));
        String r2 = (String) f.evaluarlista((ArrayList<Object>) prueba.get(1));
        System.out.println(r+r2);
    }
}