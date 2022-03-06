
public class StackFactory {

	public <T>Stack createStack(String stackType, String listType){	
		if (stackType.equals("ArrayList")) {
			return new StackArrayList<T>();
		}

		if (stackType.equals("Vector")){
			return new StackVector<T>();
		}

		if (stackType.equals("List")) {
			if(listType.equals("Doblemente Encadenada")) {
				return new DoubleLinkedList<T>();
			}
			else {
				return new SingleLinkedList<T>();
			}
		}

		return null;
	}
}
