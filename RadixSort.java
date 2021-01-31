package radixSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class RadixSort {
	
	public static ArrayList<Integer> radixSort(ArrayList<Integer> arr, int mostDigits){
		
		@SuppressWarnings("unchecked")
		Queue<Integer>[] q = new Queue[10];
		
		for (int i = 0; i < 10; i++) {
			q[i] = new PriorityQueue<Integer>();
		}
		
		int powerOf10 = 1;
		for (int i = 0; i < mostDigits; i++) {
			for (int j = 0; j < arr.size(); j ++) {
				int getCrtDigit = getDigit(arr.get(j), powerOf10);
				q[getCrtDigit].add(arr.get(j));
			}
			int item = 0;
			for (int j = 0; j < 10; j++) {
				while(!q[j].isEmpty()) {
					arr.set(item, q[j].poll().intValue());
					item++;
				}
			}
			System.out.println(arr);
			powerOf10 *= 10;
		}
		return arr;
	}
	
	public static int getDigit(int n, int powerOf10) {
		return n / powerOf10 % 10;
	}
	
	static int countDigits (int n) {
		if (n == 0) {
			return 0;
		} else
			return 1 + countDigits(n / 10);
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1000);
		arr.add(4);
		arr.add(25);
		arr.add(319);
		arr.add(88);
		arr.add(51);
		arr.add(3430);
		arr.add(8471);
		arr.add(701);
		arr.add(1);
		arr.add(2989);
		arr.add(657);
		arr.add(713);
		
		int mostDigits = countDigits(Integer.valueOf(Collections.max(arr)));
		System.out.println(arr);
		arr = radixSort(arr, mostDigits);
		

	}

}
