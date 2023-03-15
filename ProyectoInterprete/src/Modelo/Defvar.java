import java.util.*;

public class Defvar {
	//Constructor
	public Defvar() {
		
	}
	//Metodo para definir una variable
	public void DEFVAR(ArrayList<String> expresion) {
		HashMap<String,String> variables = new HashMap<>();
		//Si la expresion tiene unicamente 2 elementos, la palabra reservada DEFVAR y la variable, guarda la variable en un hashmap con valor null
		if(expresion.size() <=2) {
			String var = expresion.get(1);
			variables.put(var, null);
		//Si la expresion tiene 3 elementos, la palabra reservada, variable y su valor, los guarda ambos en el hashmap
		}else if(expresion.size() == 3) {
			String var = expresion.get(1);
			String arg = expresion.get(2);
			variables.put(var, arg);
		}else {
			System.out.println("No se ha podido realizar");
		}
	}
}
