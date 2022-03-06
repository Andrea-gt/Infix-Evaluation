import java.util.ArrayList;
public class Calculadora {

	ArrayList<String> infixExpressions = new ArrayList<String>();
	private static Calculadora miCalculadora;


	public static Calculadora getInstance() {
		if (miCalculadora == null) {
			miCalculadora = new Calculadora();
			return miCalculadora;
		}
		return miCalculadora;
	}

	public String infixToPostfix(StackArrayList<Character> stack, String expression) {
		String expressionPostFix = "";

		stack.push("#".charAt(0));
		for(Character c : expression.toCharArray()){
			if(!Character.isWhitespace(c)){
				if(Character.isDigit(c) || Character.isLetter(c)){
					expressionPostFix += c + " ";
				} else if(c.equals("(".charAt(0))){
					stack.push("(".charAt(0));
				} else if(c.equals(")".charAt(0))){
					while(!stack.peek().equals("#".charAt(0)) && !stack.peek().equals("(".charAt(0))){
						expressionPostFix += stack.pull() + " ";
					}
					stack.pull();
				} else{
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
			expressionPostFix += stack.pull() + " ";
		}

		return expressionPostFix;

	}

	public String infixToPostfix(StackVector<Character> stack, String expression) { 		
		String expressionPostFix = "";

		stack.push("#".charAt(0));
		for(Character c : expression.toCharArray()){
			if(!Character.isWhitespace(c)){
				if(Character.isDigit(c) || Character.isLetter(c)){
					expressionPostFix += c + " ";
				} else if(c.equals("(".charAt(0))){
					stack.push("(".charAt(0));
				} else if(c.equals(")".charAt(0))){
					while(!stack.peek().equals("#".charAt(0)) && !stack.peek().equals("(".charAt(0))){
						expressionPostFix += stack.pull() + " ";
					}
					stack.pull();
				} else{
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
			expressionPostFix += stack.pull() + " ";
		}

		return expressionPostFix;

	}

	public <T> String infixToPostfix(SingleLinkedList<T> stack, String expression) {
		return "";
	}

	public <T> String infixToPostfix(DoubleLinkedList<T> stack, String expression) {
		return "";
	}

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
