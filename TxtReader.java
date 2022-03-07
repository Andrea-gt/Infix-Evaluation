import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Seccion 20
 * @author Andrea Ximena Ramirez Recinos 21874
 * @author Adrian Ricardo Flores Trujillo 21500
 * @author Jose Sebastian Solorzano Perez 21826
 * @author MAAG
 * @version 06/03/2022
 * Programa para usar calculadora de Infix. 
 * Clase para realizar lectura de un archivo
 */

public class TxtReader {
	ArrayList<String> Lines = new ArrayList<String>();
	
	/**
	 * Metodo para la lectura de datos de un archivo de texto
	 * 
	 * @param fileName nombre del archivo a leer
	 * @return Strings con las lineas del archivo en un ArrayList
	 */
	public ArrayList<String> readingFile(String fileName) throws FileNotFoundException{
		
		Scanner scanner  = new Scanner(new File(fileName));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Lines.add(line);
		}
		return Lines;
	}
}
