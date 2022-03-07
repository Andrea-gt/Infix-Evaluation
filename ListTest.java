import junit.framework.TestCase;

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
 * Clase para pruebas unitarias de listas simplemente y doblemente encadenadas
 */

public class ListTest extends TestCase{
	
	public void testDoubleLinkedList(){
		DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
		assertEquals(lista.IsEmpty(), true);
		lista.InsertAtStart("ola");
		assertEquals(lista.Count(), 1);
		assertEquals(lista.DeleteAtStart(), "ola");
		assertEquals(lista.Count(), 0);
	}
	
	public void testLinkedList(){
		SingleLinkedList<String> lista = new SingleLinkedList<String>();
		assertEquals(lista.IsEmpty(), true);
		lista.InsertAtStart("ola");
		assertEquals(lista.Count(), 1);
		assertEquals(lista.DeleteAtStart(), "ola");
		assertEquals(lista.Count(), 0);
	}
	
}

