package Modelo;
import java.util.*;
import java.io.*;

public class LectorArchivo {
	
	public ArrayList<String> LeerArchivo() throws IOException{
		ArrayList<String> expresion = new ArrayList<>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader("/home/gustavo/eclipse-workspace/Proyecto 1/Proyecto1Algoritmos-main/ProyectoInterprete/src/Modelo/archivo.txt"));
			String linea =  lector.readLine();
			while(linea != null) {
				StringTokenizer tokens = new StringTokenizer(linea, " \t\r\n"); 
				while(tokens.hasMoreTokens()) {
					String st = tokens.nextToken();
					expresion.add(st);
				}
				linea = lector.readLine();
			}
			
		}catch(IOException e){
			System.out.println("No es posible leer el archivo");
		}
		
		return expresion;
	}
}
