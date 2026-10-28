package comparingListsPackage;

public abstract class NewArrayList<T> {
	
	private T[] array;
	
	public NewArrayList() {
		
	}
	
	public NewArrayList(int size) {
		
	}
	
	public abstract T get(int index);
	
	public abstract void add(T t);
	
	public abstract void add(int index, T t);
	
	public abstract void remove(int index);
}
