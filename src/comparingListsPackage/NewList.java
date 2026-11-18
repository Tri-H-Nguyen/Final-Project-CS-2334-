package comparingListsPackage;

public interface NewList<T> {
	
	public abstract void add(T t);
	
	public abstract void add(int index, T t);
	
	public abstract T get(int index);
	
	public abstract void remove(int index);
	
	public abstract void traverse();
	
	public abstract int size();
	
	
}
