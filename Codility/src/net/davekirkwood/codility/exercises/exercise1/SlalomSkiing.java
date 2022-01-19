package net.davekirkwood.codility.exercises.exercise1;

import java.util.Map.Entry;
import java.util.TreeMap;

public class SlalomSkiing {

	TreeMap<Integer, Integer> flagSteps = new TreeMap<>();

	int[] stepFlags;

	public int solution(int[] A) {

		int maxSteps = 0;
		stepFlags = new int[A.length + 1];

		for (int a : A) {
			maxSteps = Math.max(getSteps(1000000001 + a), maxSteps);
			maxSteps = Math.max(getSteps(1000000000 - a), maxSteps);
			maxSteps = Math.max(getSteps(-1000000001 + a), maxSteps);
		}
		return maxSteps;

	}
	
	public int getSteps(int a) {
		Entry<Integer, Integer> lowerEntry = flagSteps.lowerEntry(a);
		int steps = lowerEntry == null ? 1 : lowerEntry.getValue() + 1;
		int prevFlag = stepFlags[steps];
		if (prevFlag > a) {
			flagSteps.remove(prevFlag);
		}
		flagSteps.put(a, steps);
		stepFlags[steps] = a;
		return steps;
	}

	public static void main(String[] args) {

		int[] A = new int[13];
		A[0] = 15;
		A[1] = 13;
		A[2] = 5;
		A[3] = 7;
		A[4] = 4;
		A[5] = 10;
		A[6] = 12;
		A[7] = 8;
		A[8] = 2;
		A[9] = 11;
		A[10] = 6;
		A[11] = 9;
		A[12] = 3;
		System.out.println(new SlalomSkiing().solution(A));
	}

}
