package comparingListsPackage;

public class NewLinkedList<T> {
	
	private NewNode<T> nodeHead;
	private int size;
	
	public NewLinkedList() {
		nodeHead = new NewNode<T>();
		size = 0;
	}

	public T get(int index) {
		return null;
	}
	
	public void add(T t) {
		add(size, t);
	}
	

	public void add(int index, T t) {
		NewNode<T> temp = nodeHead;
		if (size == 0) {
			nodeHead.setData(t);
		}
		else if (index == 0) {
			nodeHead = new NewNode<T>(t, temp);
			size++;
			return;
		}
		else {
			for (int i = 0; i < index - 1; i++) {
			temp = temp.getNextNode();
			}
			if (index == size) {
				temp.addNewNode(t);
			}
			else {
				temp.insertNode(t);
			}
		}
		size++;
		
	}
	
	public void remove(int index) {
		
	}
	
	public String toString() {
		return "[" + nodeHead.toString().substring(0, nodeHead.toString().length() - 5).replace(" ", ", ") + "]";
	}
}

