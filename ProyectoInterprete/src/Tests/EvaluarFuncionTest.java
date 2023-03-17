package Tests;

import Controlador.EvaluarExpresion;
import Controlador.EvaluarFuncion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class EvaluarFuncionTest {

    @Test
    void evaluarlista() {
        EvaluarExpresion e = new EvaluarExpresion();
        EvaluarFuncion f = new EvaluarFuncion();
        //String exp = "( COND ( < 10 2 ) 10 2 )";
        //String exp = "( DEFUN PRUEBA ( X ) ( ( COND ( > X 2 ) X 2 ) ) )";
        String exp = "( ( DEFUN FIBO ( N ) ( ( COND ( < N 2 ) N ( + ( FIBO ( - N 1 ) ) ( FIBO ( - N 2 ) ) ) ) ) )";
        //String exp = "( DEFUN CONVERTIR ( FG ) ( ( * ( - FG 32 ) ( / 5 9 ) ) ) )";
        String exp2 = "( FIBO ( 7 ) )";
        //String exp3 = "( DEFVAR X )";
        //String exp4 = "( SETQ X 10 )";
        ArrayList<String> expL = new ArrayList<String>(Arrays.asList(exp.split(" ")));
        ArrayList<String> expL2 = new ArrayList<String>(Arrays.asList(exp2.split(" ")));
        //ArrayList<String> expL3 = new ArrayList<String>(Arrays.asList(exp3.split(" ")));
        //ArrayList<String> expL4 = new ArrayList<String>(Arrays.asList(exp4.split(" ")));
        ArrayList<Object> p1 = e.parseExpresion(expL); // expresion parseada
        System.out.println(p1);
        ArrayList<Object> p2 = e.parseExpresion(expL2);
       // ArrayList<Object> p3 = e.parseExpresion(expL3);
        //ArrayList<Object> p4 = e.parseExpresion(expL4);
        String r = f.evaluarlista((ArrayList<Object>) p1.get(0), false);
        String r2 = f.evaluarlista((ArrayList<Object>) p2.get(0), false);
       // String r3 = (String) f.evaluarlista((ArrayList<Object>) p3.get(0), false);
        //String r4 = (String) f.evaluarlista((ArrayList<Object>) p4.get(0), false);
        System.out.println(r2);
       // System.out.println(r4);
    }

    @Test
    void IsIntTest(){
        EvaluarFuncion f = new EvaluarFuncion();
        Object p = "a";
        System.out.println(f.isInteger(p));
    }

    @Test
    void AritmeticasTest(){
        EvaluarExpresion e = new EvaluarExpresion();
        String exp = "( + ( * 3 5 ) ( ( / 10 5 ) ( - 4 3 ) ) )";
        String r = e.evalExp(exp);
        System.out.println(r);
    }

    @Test
    void CondTest(){
        EvaluarExpresion e = new EvaluarExpresion();
        String exp = "( COND ( < 10 5 ) 2 3 )";
        String r = e.evalExp(exp);
        System.out.println(r);
    }

    @Test
    void EQUALTEST(){
        EvaluarExpresion e = new EvaluarExpresion();
        String exp = "( > 10 ( * 4 6 ) )";
        String r = e.evalExp(exp);
        System.out.println(r);
    }

    @Test
    void t(){
        EvaluarExpresion e = new EvaluarExpresion();
        String exp0 = "( DEFUN CONVERTIR ( FG ) ( ( * ( - FG 32 ) ( / 5 9 ) ) ) )";
        String exp = "( CONVERTIR ( 32 ) )";
        e.evalExp(exp0);
        String r = e.evalExp(exp);
        System.out.println(r);
    }


}