package comparingListsPackage;

public abstract class NewNode<T> {
	
	private NewNode<T> nextNode;
	private T data;
	
	public NewNode(T t) {
		
	}
	
	public abstract T getData();
	
	public abstract NewNode<T> getNextNode();
	
	public abstract void setData(T t);
	
	public abstract void setNextNode(NewNode<T> nextNode);
}

	

