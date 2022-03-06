import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static <T> void main(String[] args) {
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
				StackArrayList<Character> miStack = (StackArrayList<Character>) StackFactory.createStack("ArrayList", null);
				String ExpressionPostfix = miCalculadora.infixToPostfix(miStack, expression);
				System.out.println(ExpressionPostfix);
				System.out.println(miCalculadora.Evaluate(ExpressionPostfix));
			}
			break;

		case 2:

			String expressionEjemploVector = sn.nextLine();
			StackVector<Character> miVector = (StackVector<Character>) StackFactory.createStack("Vector", null);
			String ExpressionPostfixVector = miCalculadora.infixToPostfix(miVector, expressionEjemploVector);
			System.out.println(ExpressionPostfixVector);
			System.out.println(miCalculadora.Evaluate(ExpressionPostfixVector));

		case 3:
			System.out.println("\n¿Que tipo de lista desea utilizar?");
			System.out.println("1. Simplemente Encadenada");
			System.out.println("2. Doblemente Encadenada");

			int listType = sn.nextInt();

			if(listType == 1) {
				System.out.println("Ingrese la expresion");
				String expressionEjemploLSE = sn.nextLine();
				SingleLinkedList<Character> miListaSE = (SingleLinkedList<Character>) StackFactory.createStack("List", "Simplemente Encadenada"); 

			}

			if(listType == 2) {
				StackFactory.createStack("List", "Doblemente Encadenada");
			}

		default:
			System.out.println("Esta no es una opcion valida, intentelo de nuevo");

		}
	}
}
