package comparingListsPackage;

public abstract class NewLinkedList<T> {
	
	private NewNode<T> nodeHead;
	
	public NewLinkedList() {
		
	}
	
	public NewLinkedList(int size) {
		
	}

	public abstract T get(int index);
	
	public abstract void add(T t);
	
	public abstract void add(int index, T t);
	
	public abstract void remove(int index);
}

