import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		TxtReader reader = new TxtReader();
		ArrayList<String> infixExpressions = new ArrayList<String>();
		Scanner sn = new Scanner(System.in);  
		StackFactory StackFactory = new StackFactory();

		Calculadora miCalculadora = Calculadora.getInstance();

		try {

			infixExpressions = reader.readingFile("datos.txt");

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}

		System.out.println("¿Que tipo de Stack desea utilizar?\n");
		System.out.println("1. ArrayList");
		System.out.println("2. Vector");
		System.out.println("3. List");

		int stackType = sn.nextInt();
		sn.nextLine();

		switch(stackType) {

		case 1:
			for(String i : infixExpressions)
			{
				String expression = i;
				String ExpressionPostfix = miCalculadora.infixToPostfix(StackFactory.createStack("ArrayList", null), expression);
				resultado(ExpressionPostfix, i, miCalculadora.Evaluate(ExpressionPostfix));
			}
			break;

		case 2:
			for(String i : infixExpressions){
				String expressionEjemploVector = i;
				String ExpressionPostfixVector = miCalculadora.infixToPostfix(StackFactory.createStack("Vector", null), expressionEjemploVector);
				resultado(ExpressionPostfixVector, i, miCalculadora.Evaluate(ExpressionPostfixVector));
			}
			break;

		case 3:
			System.out.println("\n¿Que tipo de lista desea utilizar?");
			System.out.println("1. Simplemente Encadenada");
			System.out.println("2. Doblemente Encadenada");

			switch(sn.nextInt()){
				case 1:
					for(String i : infixExpressions){
						String expressionEjemploLSE = i;
						String ExpressionPostfix = miCalculadora.infixToPostfix(StackFactory.createStack("List", "Simplemente Encadenada"), expressionEjemploLSE);
						resultado(ExpressionPostfix, i, miCalculadora.Evaluate(ExpressionPostfix));
					}
					break;

				case 2:
					for(String i : infixExpressions){
						String expressionEjemploLSE = i;
						String ExpressionPostfix = miCalculadora.infixToPostfix(StackFactory.createStack("List", "Doblemente Encadenada"), expressionEjemploLSE);
						resultado(ExpressionPostfix, i, miCalculadora.Evaluate(ExpressionPostfix));
					}
					break;

				default:
					System.out.println("Esta no es una opcion valida, intentelo de nuevo");
			}
			break;

		default:
			System.out.println("Esta no es una opcion valida, intentelo de nuevo");


		}
	}

	/**
	 * Metodo para mostrar los resultados de la conversion Infix->Postfix y de la evaluacion de la expresion
	 * 
	 * @param expresion la expresion postfix
	 * @param i la expresion infix
	 * @param resultado resultado de evaluar la expresion postfix
	 */
	public static void resultado(String expresion, String i, int resultado){
		System.out.println("Infix: " + i);
		System.out.println("Postfix: " + expresion);
		if(resultado != -999 && resultado != -998){
			System.out.println("= " + resultado + "\n"); //Resultado normal
		} else {
			System.out.println((resultado==-999)?"Division entre 0\n":"Error de entrada, revise el archivo de texto\n"); //en caso de error
		}

	}
}
