package Modelo;
import java.util.*;
import java.io.*;

public class LectorArchivo {
	/**
	 * Lee el archivo
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> LeerArchivo() throws IOException{
		ArrayList<String> expresion = new ArrayList<>();
		String linea = "";
		try {
			Scanner lector = new Scanner(new FileReader("./src/Texto.txt"));
			while(lector.hasNextLine()) {
				linea = lector.nextLine();
				expresion.add(linea);
			}

		}catch(IOException e){
			System.out.println("No es posible leer el archivo");
		}
		
		return expresion;
	}
}
