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
 * Objeto doble nodo para utilizarse en la implementacion de listas doblemente encadenadas
 */

public class DoubleNode<T> {
	private T value;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	
	public DoubleNode(T value) {
		this.setValue(value);
	}
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	/**
	 * @return the next
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
	/**
	 * @return the previous
	 */
	public DoubleNode<T> getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
	
	
}
