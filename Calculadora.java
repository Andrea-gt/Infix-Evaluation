import java.util.ArrayList;

public class Calculadora {

	ArrayList<String> infixExpressions = new ArrayList<String>();
	private static Calculadora miCalculadora;

	/**
	 * Patrón de diseño Singleton para asegurar la existencia de una sola instancia de esta clase
	 * 
	 * @return una instancia nueva de Calculadora si es que no habia una previo a llamar el metodo, o la instancia ya almacenada
	 */
	public static Calculadora getInstance() {
		if (miCalculadora == null) {
			miCalculadora = new Calculadora();
			return miCalculadora;
		}
		return miCalculadora;
	}

	/**
	 * Metodo para convertir una expresion infix a postfix
	 * pre: string de una operacion en notacion infix
	 * post: string de una operacion en notacion postfix
	 * 
	 * @param stack cualquier stack implementado con la interfaz IStack
	 * @param expresion string con la expresion infix
	 * @return string con la expresion convertida a postfix
	 */
	public String infixToPostfix(IStack<Character> stack, String expression) {
		String expressionPostFix = "";

		stack.push("#".charAt(0));
		for(Character c : expression.toCharArray()){ //Itera sobre cada caracter en el string
			if(!Character.isWhitespace(c)){ //Ignora los whitespace
				if(Character.isDigit(c) || Character.isLetter(c)){
					expressionPostFix += c + " "; //Si encuentra un numero o letra, lo agrega a la expresion
				} else if(c.equals("(".charAt(0))){
					stack.push("(".charAt(0)); //Agrega ( al stack cuando lo encuentre
				} else if(c.equals(")".charAt(0))){
					//Al encontrar ), empieza a sacar los signos almacenados hasta que encuentre un ( o # en el stack
					while(!stack.peek().equals("#".charAt(0)) && !stack.peek().equals("(".charAt(0))){
						expressionPostFix += stack.pull() + " ";
					}
					stack.pull(); //Quita del stack el elemento adicional
				} else{
					//Revisa la jerarquia de signos para determinar cual agregar primero al stack
					if(getPrec(c) > getPrec(stack.peek())){ 
						stack.push(c);
					} else{
						while(!stack.peek().equals("#".charAt(0)) && getPrec(c) <= getPrec(stack.peek())){
							expressionPostFix += stack.pull() + " ";
						}
						stack.push(c);
					}
				}
			}
		}

		while(!stack.peek().equals("#".charAt(0))){
			expressionPostFix += stack.pull() + " "; //Termina de agregar los signos que no sean #
		}

		return expressionPostFix;

	}

	/**
	 * Metodo para determinar la jerarquia de signos
	 * pre: un caracter de un signo (+, -, *, /)
	 * post: un entero representando el "valor" del caracter
	 * 
	 * @param c el caracter a evaluar
	 * @return 1 para +, -; 2 para *, /; 0 para cualquier otro caracter
	 */
	private int getPrec(Character c){
		switch(Character.toString(c)){
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		}
		return 0;
	}

	/**
	 * Evalua una expresion postfix
	 * pre: String con una expresion postfix
	 * post: el resultado de la expresion
	 * 
	 * @param expresion String con la expresion postfix
	 * @return un entero con el resultado de la evaluacion del string
	 */
	public int Evaluate(String expresion){
		StackArrayList<Integer> stack = new StackArrayList<Integer>();
		int op1, op2;

		//Loop principal para iterar sobre cada caracter en la expresion
		for(int i = 0; i < expresion.length(); i++){

			//Si se encuentra un numero, convertirlo a int y pushearlo al stack
			if(Character.isDigit(expresion.charAt(i))){
				stack.push(Character.getNumericValue(expresion.charAt(i)));
			}

			//Si no es un numero y no es un espacio en blanco, es un posible operador.
			else if(!Character.isWhitespace(expresion.charAt(i))){

				//El try es por si no hay sufucientes elementos para hacer pull
				try{
					op2 = stack.pull(); //Operando 2
					op1 = stack.pull();	//Operando 1

					//Se convierte el caracter a un string para poder compararlo en un switch-case
					switch(Character.toString(expresion.charAt(i))){
					case "+":
						stack.push(op1 + op2);
						break;
					case "-":
						stack.push(op1 - op2);
						break;
					case "*":
						stack.push(op1 * op2);
						break;
					case "/":
						try{ //Se intenta realizar la operacion en un try por si llegara a ocurrir un /0
							stack.push(op1 / op2);
						} catch(ArithmeticException e){
							return -999; //Codigo de error para division entre cero, será procesado en Main
						}
						break;
					default: //Si el caracter no es uno de los cuatro operadores soportados se retorna el código de error para identificar un error en la entrada
						return -998;
					}
				} catch(Exception e){
					return -998; //Si no se cuenta con los elementos suficientes para operar se retorna el código de error para identificar un error en la entrada
				}
			}
		}
		return stack.peek(); //Se retorna el (que deberia ser el) unico elemento en el stack, el cual es el resultado de la expresion
	}
}
