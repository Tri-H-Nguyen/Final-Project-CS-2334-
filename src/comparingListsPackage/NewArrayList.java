package comparingListsPackage;

import java.util.Arrays;

public class NewArrayList<T> {
	
	private T[] array;
	private int size;
	private int numElements;
	
	@SuppressWarnings("unchecked")
	public NewArrayList() {
		array = (T[]) new Object[10];
		size = 10;
		numElements = 0;
	}
	
	@SuppressWarnings("unchecked")
	public NewArrayList(int size) {
		array = (T[]) new Object[size];
		this.size = size;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public void add(T t) {
		add(numElements, t);
	}
	
	public void add(int index, T t) {
		if (index >= size) {
			expandSize();
		}
		for (int i = numElements; i > index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = t;
		numElements++;
	}
	
	public void remove(int index) {
		for (int i = index; i < numElements - 1; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		numElements--;
		if (numElements <= size / 2) {
			shrinkSize();
		}
	}
	
	public void expandSize() {
		array = Arrays.copyOf(array, size * 2);
		size *= 2;
	}
	
	public void shrinkSize() {
		array = Arrays.copyOf(array, size / 2);
		size /= 2;
	}
	
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, numElements));
	}
}
