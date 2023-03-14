import java.util.Scanner;
import java.util.regex.*;
import java.util.*;
package Controlador;

public class ValidarExpresiones {
    Scanner in = new Scanner(System.in);
    Pattern pat = Pattern.compile("()");
    String input = in.nextLine();
    Matcher mat = pat.matcher(input);
    {
        if (mat.find()) {
            System.out.println("La expresión es válida");
        } else {
            System.out.println("Lo lamentamos pero su expresión no es válida, revise si cerró sus paréntesis");
        }
    }
    
}
