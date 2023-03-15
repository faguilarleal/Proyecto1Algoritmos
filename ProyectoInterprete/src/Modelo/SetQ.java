import java.util.*;
public class SetQ {
	//Constructor
	public SetQ() {
		
	}
	//Metodo para asignar un valor a una variable
	public void SETQ(Defvar defvar, ArrayList<String> expresion) 
	{
		HashMap<String, String> variables = defvar.getVariables();
		//Condicional que evalua que la expresion para definir variable cumpla con los requisitos
		boolean b = (expresion.size() <= 3) ? true:false ;
		// Si la expresion consta de las 3 partes necesarias, palabra clave SETQ, Variable, Valor, se asocia variable y valor con un hashmap
		if (b) 
		{
			String variable = expresion.get(1);
			String valor = expresion.get(2);
			if (variables.containsKey(variable)) 
			{
				variables.put(variable, valor);
			} else {
				System.out.println("\n\t***Primero debe definir la variable con DEFVAR");
			} 
		}else {
			System.out.println("Para asignar un valor a la variable, debe ingresar SET! + variable + valor");		}
	}
	
}
