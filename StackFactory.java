
public class StackFactory {

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
