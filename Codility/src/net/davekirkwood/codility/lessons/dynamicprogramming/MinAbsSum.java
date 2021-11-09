package net.davekirkwood.codility.lessons.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinAbsSum {

	public int solution(int[] A) {
		
		Map<Integer, Integer> valCounts = new HashMap<>();
		
		int sum = 0;
		for(int a : A) {
			int absA = Math.abs(a);
			sum += absA;
			if(valCounts.containsKey(absA)) {
				valCounts.put(absA, valCounts.get(absA) + 1);
			} else {
				valCounts.put(absA, 1);
			}
		}
		
		float centre = sum / 2f;
		int range = (int)Math.floor(centre);
		
		int[] r = new int[range + 1];
		r[0] = 0;
		for(int i=1; i<r.length; i++) {
			r[i] = -1;
		}
		
		for(int a : valCounts.keySet()) {
			int countOfA = valCounts.get(a);
			r[0] = countOfA;
			
			for(int i=0; i<r.length; i++) {
				if(r[i] >= 0) {
					r[i] = countOfA;
				} else {
					if(i-a >= 0) {
						r[i] = r[i-a] -1;
					}
				}
			}
		}

		
		for(int i = range; i>=0; i--) {
			if(r[i] >= 0) {
				return (int)((centre-i) * 2);
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {

		System.out.println(new MinAbsSum().solution(new int[] {
				1, 5, 2, -2		
		}));
		
	}

}
