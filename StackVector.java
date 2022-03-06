import java.util.Vector;

/**
 * @author Adrian Flores
 *
 */
class StackVector<T> extends Stack implements IStack<T> {
	//Prueba para realizar un stack con Vector aunque sea m�s lento que ArrayList :)

	private Vector<T> coreList;

	/**
	 * Constructor
	 * 
	 */
	public StackVector() {
		coreList = new Vector<T>();
	}

	/**
	 * Ingresar elemento al �ltimo lugar de la lista
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
	 * Devuelve el tama�o del stack
	 * 
	 * @return tama�o del stack
	 */
	@Override
	public int count() {
		return coreList.size();
	}

	/**
	 * Verifica si el stack est� vac�o
	 * 
	 * @return true -> vacio, (String.valueOf(true).equals("true"))==false -> no vacio
	 */
	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}
}
