/**
 * @author Adrian Flores
 *	Yo sé que es Postfix pero la interfaz viene como Posfix y no estoy como para tomar riesgos hoy.
 */
class PosfixCalc implements IPosfixCalc{

	/***
	 * This method is used to evaluate a postfix expression
	 * Pre: Expresion no vacia
	 * Post: evaluación de la expresion 
	 * @param expresion this is a single expression like: 1 2 + 4 * 3 +
	 * @return the evaluation of the expression (-998 si hay error de entrada y -999 para division entre 0. Si la expresion naturalmente da esos resultados, too bad!)
	 */
	@Override
	public int Evaluate(String expresion){
		StackArrayList<Integer> stack = new StackArrayList<Integer>(); //Comentar esta linea si se desea usar StackVector
		//StackVector<Integer> stack = new StackVector<Integer>(); //Mi implementacion de stack con Vector. Funciona, pero ArrayList es más rápido :)

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

	public String toPostfix(String expresion){
		String postfix = "";
		StackArrayList<Character> stack = new StackArrayList<Character>();
		for(int i = 0; i<expresion.length(); i++){
			if(Character.isDigit(expresion.charAt(i))){
				postfix += expresion.charAt(i);
			}else if(!Character.isWhitespace(expresion.charAt(i))){
				System.out.println(expresion.charAt(i));
				switch(Character.toString(expresion.charAt(i))){
					case "+":
						stack.push(expresion.charAt(i));
						break;
					case "-":
						stack.push(expresion.charAt(i));
						break;
					case "*":
						stack.push(expresion.charAt(i));
						break;
					case "/":
						stack.push(expresion.charAt(i));
						break;
					default:
						System.out.println("???");
				}
			}
		}
		String temp = "";
		for(int i =0; i<=stack.count(); i++){
			temp += stack.pull();
		}
		return postfix + " " + temp;
	}
}