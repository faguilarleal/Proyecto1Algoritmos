import java.util.*;

public class MayorQ {
	private static boolean b;
	//Constructor MayorQ
	public MayorQ() {
		
	}
	public boolean MAYORQ(ArrayList<String> expresion) throws Exception{
		double a, c;
		try {
			a = Double.parseDouble(expresion.get(1));
			c = Double.parseDouble(expresion.get(2));
			if (a>c) 
			{
				b = true;
			}
			return b;
		} catch (NumberFormatException e) {
			throw new Ex("No es posible realizar la comparacion, revise el tipo de las variables");
		}
	}
}
