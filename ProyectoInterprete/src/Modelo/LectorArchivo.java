package Modelo;
import java.util.*;
import java.io.*;

public class LectorArchivo {
	
	public ArrayList<String> LeerArchivo() throws IOException{
		ArrayList<String> expresion = new ArrayList<>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader("archivo.txt"));
			StringBuilder linea = new StringBuilder();
			int restante = lector.read();
			while(restante != -1) {
				linea.append((char)restante);
				restante = lector.read();
			}
			expresion.add(linea.toString());
		}catch(IOException e){
			System.out.println("No es posible leer el archivo");
		}
		
		return expresion;
	}
}
