package comparingListsPackage;

import java.util.*;

public class TestingClass {
	public static final int TRIALS_NUM = 15;
	public static boolean warmingUp = true;
	/**
	 * Warms up the java code before running the actual tests.
	 * @param size
	 */
	public static void warmUp(int size) {
		ArrayList<Integer> a = new ArrayList<>();
		LinkedList<Integer> b = new LinkedList<>();
		
		addIntAtIndex(a, -1, size); addIntAtIndex(b, 0, size);
		traverse(a, TRIALS_NUM); traverse(b, TRIALS_NUM);
		addIntAtIndex(a, 0, TRIALS_NUM); addIntAtIndex(b, 0, TRIALS_NUM);
		addIntAtIndex(a, -1, TRIALS_NUM); addIntAtIndex(b, -1, TRIALS_NUM);
		removeAtIndex(a, 0, TRIALS_NUM); removeAtIndex(b, 0, TRIALS_NUM);
		removeAtIndex(a, -1, TRIALS_NUM); removeAtIndex(b, -1, TRIALS_NUM);
		randomGetterTest(a, b, size);
		warmingUp = false;
	}
	/**
	 * Tests ArrayList and LinkedList in a variety of tests.
	 * @param size
	 */
	public static void javaListTesting(int size) {
		//Initialize
		ArrayList<Integer> a = new ArrayList<>();
		LinkedList<Integer> b = new LinkedList<>();
		
		//Initializing
		System.out.println("Initializing Integer ArrayList and Linked List of size " + size + ": ");
		printResults("Initializing", addIntAtIndex(a, -1, size), addIntAtIndex(b, 0, size));
		
		//Traversal
		printResults("Traversal (" + size + ")", traverse(a, TRIALS_NUM), traverse(b, TRIALS_NUM));
		
		//Add at Index 0
		printResults("Add at Index 0", addIntAtIndex(a, 0, TRIALS_NUM), addIntAtIndex(b, 0, TRIALS_NUM));
		
		//Add in Middle
		printResults("Add in Middle", addIntAtIndex(a, a.size() / 2, TRIALS_NUM), addIntAtIndex(b, b.size() / 2, TRIALS_NUM));
		
		//Add at End
		printResults("Add at End", addIntAtIndex(a, -1, TRIALS_NUM), addIntAtIndex(b, -1, TRIALS_NUM));
		
		//Remove at Index 0
		printResults("Remove at Index 0", removeAtIndex(a, 0, TRIALS_NUM), removeAtIndex(b, 0, TRIALS_NUM));
		
		//Remove in Middle
		printResults("Remove in Middle", removeAtIndex(a, a.size() / 2, TRIALS_NUM), removeAtIndex(b, b.size() / 2, TRIALS_NUM));

		//Remove at End
		printResults("Remove at End", removeAtIndex(a, -1, TRIALS_NUM), removeAtIndex(b, -1, TRIALS_NUM));
		
		//Random Getter Test for 100 random indexes
		randomGetterTest(a, b, size);

		System.out.println();
	}
	
	/**
	 * Adds 'trials' amount of integers to 'list' at the index 'index'.
	 * If 'index' is a negative number, add 'trials' amount of integers to the end of 'list'.
	 * @param list
	 * @param index
	 * @param trials
	 * @return
	 */
	public static long addIntAtIndex(List<Integer> list, int index, int trials) {
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
	 * Deletes 
	 * @param index
	 * @param trials
	 * @return
	 */
	public static long removeAtIndex(List<?> list, int index, int trials){
		
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
	 * Traverses through a list and returns the time in nanoseconds.
	 * @param list
	 * @return
	 */
	public static long traverse(List<?> list, int trials) {
		long start;
		long totalNS = 0;
		
		ListIterator<?> itr = list.listIterator();
		for (int j = 0; j < trials; j++) {
			start = System.nanoTime();
			while(itr.hasNext() ) {
				itr.next();
			}
			totalNS += System.nanoTime() - start;
		}

		return totalNS / trials;
	}
	
	/**
	 * Test the time (in nanoseconds) it takes to get the value at a random index at in a list.
	 * Tests 25 indexes in the first, second, third, and forth quarter of a list. 
	 * @param array
	 * @param linked
	 * @param size
	 */
	public static void randomGetterTest(ArrayList<?> array, LinkedList<?> linked, int size) {
		Set<Integer> randomNumSet = new TreeSet<>();
		
		for (int i = 0; i < 4; i++) {
			randomNumSet = fetchRandomNumSet(size, i);
			printResults("Random get (%" + (25 * i) + " to %" + (25 * (i + 1) + ")"),
					randomGet(array, randomNumSet), randomGet(linked, randomNumSet));
		}
	}
	
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
	public static long randomGet(List<?> list, Set<Integer> set) {
		
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
	
	/**
	 * Formats a string 
	 * @param testType
	 * @param arrayTime
	 * @param LinkedTime
	 */
	private static void printResults(String testType, long arrayTime, long LinkedTime) {
		if (!warmingUp) {
        	System.out.printf("%30s | ArrayList: %8s ns | LinkedList: %8s ns%n", testType, arrayTime, LinkedTime);
    
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Comparing Java ArrayList and LinkedList");
		warmUp(250000);
		//javaListTesting(10);
		javaListTesting(100000);
		javaListTesting(200000);
		javaListTesting(300000);
		javaListTesting(400000);
		javaListTesting(500000);


	}
}
