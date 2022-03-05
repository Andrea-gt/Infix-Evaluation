import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


/**
 * Este main es solo para probar las conversiones :DDD
 * su tiempo se está agotando.
 * 
 */
class Main2{
	public static void main(String[] args){
		PosfixCalc calc = new PosfixCalc();
		
		ArrayList<String> lineas = new ArrayList<String>();

		int resultado;

		try{
			File archivo = new File("datos.txt");
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()){
				lineas.add(lector.nextLine()); 
			}
			lector.close();
		} catch(Exception e){
			e.printStackTrace();
		}

		for(int i = 0; i<lineas.size() ; i++){
			System.out.println("Infix: " + lineas.get(i));
			System.out.println("Postfix: " + calc.toPostfix(lineas.get(i)));
			System.out.println("Evaluacion: " + calc.Evaluate(calc.toPostfix(lineas.get(i))) + "\n");
		}
	}
}