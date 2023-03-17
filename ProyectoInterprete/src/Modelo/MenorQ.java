import java.util.*;

public class MenorQ {
	private static boolean b;
	
	public MenorQ() {
		
	}
	
	public boolean MENORQ(ArrayList<String> expresion) {
		double a,c;
		a = Double.parseDouble(expresion.get(1));
		c = Double.parseDouble(expresion.get(2));
		if(a<c) 
		{
			b = true;
		}
		return b;
	}
}
