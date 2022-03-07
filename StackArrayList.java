import java.util.ArrayList;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Seccion 20
 * @author Andrea Ximena Ramirez Recinos 21874
 * @author Adrian Ricardo Flores Trujillo 21500
 * @author Jose Sebastian Solorzano Perez 21826
 * @author moises.alonso
 * @version 06/03/2022
 * Programa para usar calculadora de Infix. 
 * Implementacion de Stacks con ArrayLists
 */
public class StackArrayList<T> implements IStack<T> {

	private ArrayList<T> coreList;
	
	public StackArrayList() {
		coreList = new ArrayList<T>();
	}
	
	@Override
	public void push(T value) {		
		coreList.add(0, value);
	}

	@Override
	public T pull() {
		return coreList.remove(0);
	}

	@Override
	public T peek() {
		return coreList.get(0);
	}

	@Override
	public int count() {
		return coreList.size();
	}

	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}

}
