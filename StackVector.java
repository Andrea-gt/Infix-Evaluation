import java.util.Vector;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Seccion 20
 * @author Andrea Ximena Ramirez Recinos 21874
 * @author Adrian Ricardo Flores Trujillo 21500
 * @author Jose Sebastian Solorzano Perez 21826
 * @version 06/03/2022
 * Programa para usar calculadora de Infix. 
 * Implementacion de Stack usando Vector
 */
class StackVector<T> implements IStack<T> {
	//Prueba para realizar un stack con Vector aunque sea más lento que ArrayList :)

	private Vector<T> coreList;

	/**
	 * Constructor
	 * 
	 */
	public StackVector() {
		coreList = new Vector<T>();
	}

	/**
	 * Ingresar elemento al último lugar de la lista
	 * 
	 * @param value el objeto a ingresar
	 */
	@Override
	public void push(T value) {		
		coreList.addElement(value);
	}

	/**
	 * Quita y devuelve el ultimo elemento del stack
	 * 
	 * @return el ultimo objeto en el stack
	 */
	@Override
	public T pull() {
		return coreList.remove(coreList.size()-1);
	}

	/**
	 * Devuelve el ultimo objeto en el stack sin quitarlo
	 * 
	 * @return el ultimo objeto del stack
	 */
	@Override
	public T peek() {
		return coreList.get(coreList.size()-1);
	}

	/**
	 * Devuelve el tamaño del stack
	 * 
	 * @return tamaño del stack
	 */
	@Override
	public int count() {
		return coreList.size();
	}

	/**
	 * Verifica si el stack está vacío
	 * 
	 * @return true -> vacio, (String.valueOf(true).equals("true"))==false -> no vacio
	 */
	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}
}
