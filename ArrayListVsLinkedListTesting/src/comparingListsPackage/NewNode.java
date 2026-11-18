package comparingListsPackage;

public class NewNode<T> {
	
	private NewNode<T> nextNode;
	private T data;
	
	public NewNode() {
		data = null;
		nextNode = null;
	}
	
	public NewNode(T t) {
		data = t;
		nextNode = null;
	}
	
	public NewNode(T t, NewNode<T> nextNode) {
		data = t;
		this.nextNode = nextNode;
	}
	
	public T getData() {
		return data;
	}
	
	public NewNode<T> getNextNode() {
		return nextNode;
	}
	
	public void setData(T t) {
		data = t;
	}
	
	public void setNextNode(NewNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public void addNewNode(T t) {
		nextNode = new NewNode<T>(t);
	}
	
	public void insertNode(T t) {
		nextNode = new NewNode<T>(t,this.nextNode);
	}
	
	public String toString() {
		return data + " " + nextNode;
	}
}

	

