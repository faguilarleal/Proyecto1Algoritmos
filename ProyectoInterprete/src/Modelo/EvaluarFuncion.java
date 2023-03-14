package Modelo;

import java.util.*;

public class EvaluarFuncion
{
	private Stack<Object> st;
	
	public EvaluarFuncion() {
		st = new Stack<>();
	}
	
	public Object evaluar(String expresion)
	{
		String[] tokens = expresion.split("\\s+");
		for(String token : tokens)
		{
			if(token.equals("("))
				st.push(token);
			else if (token.equals(")"))
			{
				List<Object> obj = new ArrayList<>();
				while(!st.empty() && !st.peek().equals("("))
				{
					obj.add(0,st.pop());
				}
				if(!st.empty()) 
				{
					st.pop();
					Object result = evaluarlista(obj);
					st.push(result);
				}
			}
			else
			{
				st.push(parseToken(token));
			}
			
		}
		return st.pop();
	}
	
	public Object evaluarlista(List<Object> obj)
	{
		if(obj.isEmpty()) 
		{
			return null;
		}
		Object primero = obj.get(0);
		if(primero instanceof String) 
		{
			String funct = (String)primero;
			if(funct.equals("QUOTE") || funct.equals("'"))
			{
				return obj.get(1);
			}else if(funct.equals("EQUAL")){
				Object o1 = obj.get(1);
				Object o2 = obj.get(2);
				return o1.equals(o2);
			}else if(funct.equals("LIST")) {
				return new ArrayList<>(obj.subList(1, obj.size()));
			}else if(funct.equals("SETQ")){
				String variable = (String) obj.get(1);
				Object valor = obj.get(2);
				return null;
			}else {
				return null;
			}
			
		}else {
			return null;
		}
	}
	public Object parseToken(String token) 
	{
		try 
		{
			return Double.parseDouble(token);
	    } catch (NumberFormatException e) 
		{
	        	return token;
	    }
	}
}
