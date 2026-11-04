package comparingListsPackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class ComparisonTests {
	
	private static final int TRIAL_SIZE = 20;
	private static final int BASE_TEST_SIZE = 1000;
	
	private static long start;
	private static long end;
	private static ArrayList<Object> a;
	private static LinkedList<Object> b;
	private static NewArrayList<Object> c;
	private static NewLinkedList<Object> d;
	
	private static int[] trialData;
	
	public static void initalizeArrays(int size) {
		a = new ArrayList<>();
		b = new LinkedList<>();
		c = new NewArrayList<>();
		d = new NewLinkedList<>();

	}
	
	/**
	 * Tests how long it takes to add each list with size amount of Integers.
	 * Repeats each trial and takes an average time for each test.
	 * @param numOfIntegers
	 * @param numOfTrials
	 */
	public static void addIntegers(int index, int numOfIntegers, int numOfTrials) {
		
		System.out.println("Over " + numOfTrials + " trials, the average time to fill each list with Integers 1 to " + numOfIntegers + " was:");
		//Testing to see how long it takes to fill the java ArrayList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			for(int j = 0; j < numOfIntegers; j++) {
				a.add(index, j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
			//System.out.println(a);
		}
		System.out.println("Java ArrayList: " + average(trialData) + " nanoseconds");
	
		//Testing to see how long it takes to fill the java LinkedList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			for(int j = 0; j < numOfIntegers; j++) {
				b.add(index, j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
			//System.out.println(b);
		}
		System.out.println("Java LinkedList: " + average(trialData) + " nanoseconds");
		
		//Testing to see how long it takes to fill the Recreated ArrayList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			for(int j = 0; j < numOfIntegers; j++) {
				c.add(index, j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
			//System.out.println(c);
		}
		System.out.println("Recreated ArrayList: " + average(trialData) + " nanoseconds");
		
		//Testing to see how long it takes to fill the Recreated LinkedList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			for(int j = 0; j < numOfIntegers; j++) {
				d.add(index, j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
			//System.out.println(d);
		}
		System.out.println("Recreated LinkedList: " + average(trialData) + " nanoseconds");
		
		
		System.out.println();
	}
	
	public static void remove(int index, int numOfTrials) {
		
		System.out.println("Over " + numOfTrials + " trials, the average time to remove an element at index " + index + " was:");
		
		//ArrayList
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			a.remove(index);
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("Java ArrayList: " + average(trialData) + " nanoseconds");
		
		//LinkedList
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			b.remove(index);
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("Java LinkedList: " + average(trialData) + " nanoseconds");
		
		//Recreated ArrayList
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			start = System.nanoTime();
			c.remove(index);
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("Recreated ArrayList: " + average(trialData) + " nanoseconds");
		
		
		
		System.out.println();
	}
	
	public static int average(int[] trialData) {
		int sum = 0;
		for (int i : trialData) {
			sum += i;
		}
		return sum / trialData.length;
		
	}
	
	
	public static void main(String[] args) {
		
		initalizeArrays(0);
		addIntegers(0,BASE_TEST_SIZE, TRIAL_SIZE);
		addIntegers(BASE_TEST_SIZE / 2, BASE_TEST_SIZE, TRIAL_SIZE);
		//remove(0,TRIAL_SIZE);
		//remove((int) (Math.random() * (BASE_TEST_SIZE - (TRIAL_SIZE / BASE_TEST_SIZE))/5), TRIAL_SIZE);
		//remove((int) (Math.random() * (BASE_TEST_SIZE - (TRIAL_SIZE / BASE_TEST_SIZE))/5) + (BASE_TEST_SIZE / 5), TRIAL_SIZE);
		//remove((int) (Math.random() * (BASE_TEST_SIZE - (TRIAL_SIZE / BASE_TEST_SIZE))/5) + ((BASE_TEST_SIZE * 2) / 5), TRIAL_SIZE);
		//remove((int) (Math.random() * (BASE_TEST_SIZE - (TRIAL_SIZE / BASE_TEST_SIZE))/5) + ((BASE_TEST_SIZE * 3) / 5), TRIAL_SIZE);
		//remove((int) (Math.random() * (BASE_TEST_SIZE - (TRIAL_SIZE / BASE_TEST_SIZE))/5) + ((BASE_TEST_SIZE * 4) / 5), TRIAL_SIZE);

	}
	
}
