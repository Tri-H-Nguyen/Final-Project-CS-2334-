package comparingListsPackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class ComparisonTests {
	
	private static long start;
	private static long end;
	private static ArrayList<Object> a;
	private static LinkedList<Object> b;
	private static NewArrayList<Object> c;
	
	/**
	 * Tests how long it takes to fill each list with size of size.
	 * Repeats each trial and takes an average time for each test.
	 * @param size
	 * @param numOfTrials
	 */
	public static void fillWithIntegers(int size, int numOfTrials) {
		
		int[] trialData;
		
		//Testing to see how long it takes to fill the java ArrayList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			a = new ArrayList<>();
			start = System.nanoTime();
			for(int j = 0; j < size; j++) {
				a.add(j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("After " + numOfTrials + " trials, it took an average of " + 
							average(trialData) + " nanoseconds to fill the Java ArrayList with "
							+ size + " Integers.");
	
		//Testing to see how long it takes to fill the java LinkedList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			b = new LinkedList<>();
			start = System.nanoTime();
			for(int j = 0; j < size; j++) {
				b.add(j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("After " + numOfTrials + " trials, it took an average of " + 
							average(trialData) + " nanoseconds to fill the Java LinkedList with "
							+ size + " Integers.");
		
		//Testing to see how long it takes to fill the our ArrayList with a size of size.
		trialData = new int[numOfTrials];
		for (int i = 0; i < numOfTrials; i++) {
			c = new NewArrayList<>();
			start = System.nanoTime();
			for(int j = 0; j < size; j++) {
				c.add(j);
			}
			end = System.nanoTime();
			trialData[i] = (int) (end - start);
		}
		System.out.println("After " + numOfTrials + " trials, it took an average of " + 
							average(trialData) + " nanoseconds to fill our ArrayList with "
							+ size + " Integers.");
		
	}
	
	public static void removeFirst(int numOfTrial) {
		
		
		for (int i = 0; i < numOfTrial; i++) {
			b.remove(0);
			System.out.println(b);
		}
		
		for (int i = 0; i < numOfTrial; i++) {
			c.remove(0);
			System.out.println(c);
		}
	}
	
	public static int average(int[] trialData) {
		int sum = 0;
		for (int i : trialData) {
			sum += i;
		}
		return sum / trialData.length;
		
	}
	
	
	public static void main(String[] args) {
		fillWithIntegers(20, 10);
		removeFirst(10);
	}
	
}
