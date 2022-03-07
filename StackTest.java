import junit.framework.TestCase;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Seccion 20
 * @author Andrea Ximena Ramirez Recinos 21874
 * @author Adrian Ricardo Flores Trujillo 21500
 * @author Jose Sebastian Solorzano Perez 21826
 * @version 06/03/2022
 * Programa para usar calculadora de Infix. 
 * Clase para pruebas unitarias de las diferentes implementaciones de stacks
 */

public class StackTest extends TestCase{
	StackFactory s = new StackFactory();
	
	public void testStackUsingDoubleLinkedList(){
		StackUsingDoubleLinkedList<Character> stack = new StackUsingDoubleLinkedList<Character>();
		assertEquals(0, stack.count());
		stack.push("a".charAt(0));
		assertEquals(1, stack.count());
		assertEquals("a".charAt(0), stack.peek().charValue());
		stack.push("b".charAt(0));
		assertEquals(2, stack.count());
		assertEquals("b".charAt(0), stack.pull().charValue());
		assertEquals(1, stack.count());
	}
	
	public void testStackUsingLinkedList(){
		StackUsingLinkedList<Character> stack = new StackUsingLinkedList<Character>();
		assertEquals(0, stack.count());
		stack.push("a".charAt(0));
		assertEquals(1, stack.count());
		assertEquals("a".charAt(0), stack.peek().charValue());
		stack.push("b".charAt(0));
		assertEquals(2, stack.count());
		assertEquals("b".charAt(0), stack.pull().charValue());
		assertEquals(1, stack.count());
	}
	
	public void testStackVector(){
		StackVector<Character> stack = new StackVector<Character>();
		assertEquals(0, stack.count());
		stack.push("a".charAt(0));
		assertEquals(1, stack.count());
		assertEquals("a".charAt(0), stack.peek().charValue());
		stack.push("b".charAt(0));
		assertEquals(2, stack.count());
		assertEquals("b".charAt(0), stack.pull().charValue());
		assertEquals(1, stack.count());
	}
	
	public void testStackArrayList(){
		StackArrayList<Character> stack = new StackArrayList<Character>();
		assertEquals(0, stack.count());
		stack.push("a".charAt(0));
		assertEquals(1, stack.count());
		assertEquals("a".charAt(0), stack.peek().charValue());
		stack.push("b".charAt(0));
		assertEquals(2, stack.count());
		assertEquals("b".charAt(0), stack.pull().charValue());
		assertEquals(1, stack.count());
	}
}

