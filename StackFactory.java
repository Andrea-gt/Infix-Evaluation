/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Seccion 20
 * @author Andrea Ximena Ramirez Recinos 21874
 * @author Adrian Ricardo Flores Trujillo 21500
 * @author Jose Sebastian Solorzano Perez 21826
 * @version 06/03/2022
 * Programa para usar calculadora de Infix. 
 * Clase para la implementacion del patron de diseño Factory
 */

public class StackFactory {

	/**
	 * Patrón de diseño Factory para crear un stack con la implementacion deseada
	 * pre: el tipo de implementacion que se busca
	 * post: una nueva instancia del tipo stack indicado
	 * 
	 * @param stackType el tipo de implementacion del stack ("ArrayList", "Vector" o "Lista")
	 * @param listType null si stackType == "ArrayList" o "Vector". Si stackType == "Lista" entonces "Doblemente Encadenada" devuelve una DoubleLinkedList, cualquier otro valor devuelve una LinkedList
	 * @return null si stackType == "ArrayList" o "Vector". Si stackType == "Lista" entonces "Doblemente Encadenada" devuelve una DoubleLinkedList, cualquier otro valor devuelve una LinkedList :D
	 */
	public IStack<Character> createStack(String stackType, String listType){	
		if (stackType.equals("ArrayList")) {
			return new StackArrayList<Character>();
		}

		if (stackType.equals("Vector")){
			return new StackVector<Character>();
		}

		if (stackType.equals("List")) {
			if(listType.equals("Doblemente Encadenada")) {
				return new StackUsingDoubleLinkedList<Character>();
			}
			else {
				return new StackUsingLinkedList<Character>();
			}
		}

		return null;
	}
}
