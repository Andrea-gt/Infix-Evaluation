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
 * Implementacion de Stack usando listas simplemente encadenadas
 */
public class StackUsingLinkedList<T> implements IStack<T> {

	private SingleLinkedList<T> listaInterna;
	
	public StackUsingLinkedList(){
		listaInterna = new SingleLinkedList<T>();
	}
	
	@Override
	public int count() {
		return listaInterna.Count();
	}

	@Override
	public boolean isEmpty() {
		return listaInterna.IsEmpty();
	}

	@Override
	public void push(T value) {
		listaInterna.InsertAtStart(value);
	}

	@Override
	public T pull() {
		return listaInterna.Delete(0);
	}

	@Override
	public T peek() {
		return listaInterna.Get(0);
	}

}
