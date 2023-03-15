import java.util.Scanner;
import java.util.regex.*;
import java.util.*;
package Controlador;

public class ValidarExpresiones {
    Scanner in = new Scanner(System.in);
    Pattern pat1 = Pattern.compile("(");
    Pattern pat2 = Pattern.compile(")");
    String input = in.nextLine();
    Matcher mat1 = pat1.matcher(input);
    {
        int c1 = 0;
        while (mat1.find()){
            c1 ++;
       }
    }
    Matcher mat2 = pat2.matcher(input);
    {
        int c2 = 0;
        while (mat2.find()) {
            c2 ++;
       }
    }{
        if (c1 != c2){
            System.out.println("La expresión no es válida, revise si cerró todos los paréntesis de la expresión ingresada");
    }else{
        System.out.println("Validación completa");
    }
    }
}
