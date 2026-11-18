package comparingListsPackage;

import java.util.Set;
import java.util.TreeSet;

public class NewTestingClass {
	public static final int TRIALS_NUM = 20;
	public static boolean warmingUp = true;

	public static void TestingNewList(int size) {
		
		//Integers Test
		NewArrayList<Integer> a = new NewArrayList<>();
		NewLinkedList<Integer> b = new NewLinkedList<>();
		
		//Initialization
		if (!warmingUp) {
			System.out.println("Initializing Integer ArrayList and Linked List of size " + size + ": ");
		}
		printResults("Initializing", addIntAtIndex(a, -1, size), addIntAtIndex(b, 0, size));
		
		//Traversal
		printResults("Traversal (" + size + ")", traverse(a, TRIALS_NUM), traverse(b, TRIALS_NUM));
		
		//Add at Index 0
		printResults("Add at Index 0", addIntAtIndex(a, 0, TRIALS_NUM), addIntAtIndex(b, 0, TRIALS_NUM));
				
		//Add in Middle
		printResults("Add in Middle", addIntAtIndex(a, a.size() / 2, TRIALS_NUM), addIntAtIndex(b, b.size() / 2, TRIALS_NUM));
				
		//Add at End
		printResults("Add at End", addIntAtIndex(a, -1, TRIALS_NUM), addIntAtIndex(b, -1, TRIALS_NUM));
		
		//Tests Remove at Index 0, Middle, and at End
		TestingRemove(a, b);
		
		//Random Getter Test for 100 random indexes
		randomGetterTest(a, b, size);
		
		if (!warmingUp) {
			System.out.println();
		}
		
		//Doubles
		NewArrayList<Double> c = new NewArrayList<>();
		NewLinkedList<Double> d = new NewLinkedList<>();
				
		//Initializing
		if (!warmingUp) {
			System.out.println("Initializing Doubles ArrayList and Linked List of size " + size + ": ");
		}
		printResults("Initializing", addDoubleAtIndex(c, -1, size), addDoubleAtIndex(d, 0, size));
				
		//Traversal
		printResults("Traversal (" + size + ")", traverse(c, TRIALS_NUM), traverse(d, TRIALS_NUM));
				
		//Add at Index 0
		printResults("Add at Index 0", addDoubleAtIndex(c, 0, TRIALS_NUM), addDoubleAtIndex(d, 0, TRIALS_NUM));
				
		//Add in Middle
		printResults("Add in Middle", addDoubleAtIndex(c, c.size() / 2, TRIALS_NUM), addDoubleAtIndex(d, d.size() / 2, TRIALS_NUM));
				
		//Add at End
		printResults("Add at End", addDoubleAtIndex(c, -1, TRIALS_NUM), addDoubleAtIndex(d, -1, TRIALS_NUM));
				
		//Tests Remove at Index 0, Middle, and at End
		TestingRemove(c, d);
		
		//Random Getter Test for 100 random indexes
		randomGetterTest(c, d, size);
		if (!warmingUp) {
			System.out.println();
		}
						

	}
	
	//Compares the removal of entries from the custom ArrayList and custom LinkedList.
	public static void TestingRemove(NewArrayList<?> a, NewLinkedList<?> b) {
		//Remove at Index 0
		printResults("Remove at Index 0", removeAtIndex(a, 0, TRIALS_NUM), removeAtIndex(b, 0, TRIALS_NUM));
				
		//Remove in Middle
		printResults("Remove in Middle", removeAtIndex(a, a.size() / 2, TRIALS_NUM), removeAtIndex(b, b.size() / 2, TRIALS_NUM));

		//Remove at End
		printResults("Remove at End", removeAtIndex(a, -1, TRIALS_NUM), removeAtIndex(b, -1, TRIALS_NUM));
				
	}
	
	/**
	 * Adds 'trials' amount of Integers to 'list' at the index 'index'.
	 * If 'index' is a negative number, add 'trials' amount of integers to the end of 'list'.
	 * @param list
	 * @param index
	 * @param trials
	 * @return
	 */
	public static long addIntAtIndex(NewList<Integer> list, int index, int trials) {
		long totalNS = 0;
		long start;
		
		if (index < 0) {
			
			for (int i = trials - 1; i >= 0; i--) {
				start = System.nanoTime();
				list.add(i);
				totalNS += System.nanoTime() - start;
			}
		} else {
			for (int i = 0; i < trials; i++) {
				start = System.nanoTime();
				list.add(index, i);
				totalNS += System.nanoTime() - start;
			}
		}
		//System.out.println(list);
		if (trials == TRIALS_NUM) {
			totalNS /= trials;
		}
		return totalNS;
	}
	
	/**
	 * Adds 'trials' amount of Doubles to 'list' at the index 'index'.
	 * If 'index' is a negative number, add 'trials' amount of integers to the end of 'list'.
	 * @param list
	 * @param index
	 * @param trials
	 * @return
	 */
	public static long addDoubleAtIndex(NewList<Double> list, int index, int trials) {
		long totalNS = 0;
		long start;
		if (index < 0) {
			
			for (int i = trials - 1; i >= 0; i--) {
				start = System.nanoTime();
				list.add(Math.random());
				totalNS += System.nanoTime() - start;
			}
		} else {
			for (int i = 0; i < trials; i++) {
				start = System.nanoTime();
				list.add(index, Math.random());
				totalNS += System.nanoTime() - start;
			}
		}
		//System.out.println(list);
		if (trials == TRIALS_NUM) {
			totalNS /= trials;
		}
		return totalNS;
	}
	
	/**
	 * Deletes value at the index in a list. Repeats for trials number of times.
	 * @param index
	 * @param trials
	 * @return
	 */
	public static long removeAtIndex(NewList<?> list, int index, int trials){
		long totalNS = 0;
		long start;
		if (index < 0) {
			
			for (int i = trials - 1; i >= 0; i--) {
				start = System.nanoTime();
				list.remove(list.size() - 1);
				totalNS += System.nanoTime() - start;
			}
		} else {
			for (int i = 0; i < trials; i++) {
				start = System.nanoTime();
				list.remove(index);
				totalNS += System.nanoTime() - start;
			}
		}
		//System.out.println(list);
		return totalNS / trials;
	}
	
	/**
	 * Test the time (in nanoseconds) it takes to get the value at a random index at in a list.
	 * Tests 25 indexes in the first, second, third, and forth quarter of a list. 
	 * @param array
	 * @param linked
	 * @param size
	 */
	public static void randomGetterTest(NewArrayList<?> array, NewLinkedList<?> linked, int size) {
		Set<Integer> randomNumSet = new TreeSet<>();
		
		for (int i = 0; i < 4; i++) {
			randomNumSet = fetchRandomNumSet(size, i);
			printResults("Random get (%" + (25 * i) + " to %" + (25 * (i + 1) + ")"),
					randomGet(array, randomNumSet), randomGet(linked, randomNumSet));
		}
	}
	
	/**
	 * Creates a set of random numbers sorted from least to greatest.
	 * @param size
	 * @param mult
	 * @return
	 */
	public static TreeSet<Integer> fetchRandomNumSet(int size,int mult) {
		TreeSet<Integer> rng = new TreeSet<>();

		while (rng.size() != 25) {
			rng.add( (int) (Math.random() * (size / 4)) + (size / 4) * mult);
		}
		
		return rng;
	}
	
	/**
	 * Returns the amount of time it takes to get 25 values from a list at the indexes
	 * given by the set.
	 * @param list
	 * @param set
	 * @param mult
	 * @return
	 */
	public static long randomGet(NewList<?> list, Set<Integer> set) {
		
		long start;
		long totalNS = 0;
		for (int i = 0; i < TRIALS_NUM; i++) {
			for (int num : set) {
				start = System.nanoTime();
				list.get(num);
				totalNS += System.nanoTime() - start;
			}
		}
		return totalNS / TRIALS_NUM;
	}
	
	public static long traverse(NewList<?> list, int trials) {
		long start;
		long totalNS = 0;
		
		for (int j = 0; j < trials; j++) {
			start = System.nanoTime();
			list.traverse();
			totalNS += System.nanoTime() - start;
		}

		return totalNS / trials;
	}
	
	/**
	 * Formats a string 
	 * @param testType
	 * @param arrayTime
	 * @param LinkedTime
	 */
	private static void printResults(String testType, long arrayTime, long LinkedTime) {
		if (!warmingUp) {
        	System.out.printf("%30s | Array: %8s ns | Linked: %8s ns%n", testType, arrayTime, LinkedTime);
    
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Comparing Custom ArrayList and LinkedList");
		System.out.println("(Averages after " + TRIALS_NUM + " trials)");
		//Warm Up Test
		TestingNewList(100000);
		TestingNewList(200000);
		warmingUp = false;
		TestingNewList(10000);
		TestingNewList(50000);
		TestingNewList(100000);
		TestingNewList(200000);
		TestingNewList(300000);
		TestingNewList(400000);
		TestingNewList(500000);
		

	}
}
