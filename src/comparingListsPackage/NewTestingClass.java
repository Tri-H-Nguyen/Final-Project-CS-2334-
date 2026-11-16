package comparingListsPackage;

public class NewTestingClass {
	public static double arraySum;
	public static double linkedSum;

	public void TestingNewArrayListInt() {
		
	}
	
	public static void initialInt(NewArrayList<Integer> array, NewLinkedList<Integer> linked, int size) {
		long start = System.nanoTime();
		for (int i = 0; i < index; i++) {
			array.add(i);
		}
		long end = System.nanoTime() - start;
		arraySum += (double) end / 1000000.0;
		
		start = System.nanoTime();
		for (int i = 0; i < index; i++) {
			linked.add(0, i);
		}
		end = System.nanoTime() - start;
		linkedSum += (double) end / 1000000.0;
	}


	public static void main(String[] args) {
		arraySum = 0;
		linkedSum = 0;
		
		for (int i = 0; i < 10; i++) {
			NewArrayList<Integer> a = new NewArrayList<>();
			NewLinkedList<Integer> b = new NewLinkedList<>();
			initialInt(a, b, 500000);
		}
		
		System.out.println("Averages: " + (arraySum / 10) + "| " + (linkedSum / 10));

	}
}
