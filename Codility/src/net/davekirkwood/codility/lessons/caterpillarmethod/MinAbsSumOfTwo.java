package net.davekirkwood.codility.lessons.caterpillarmethod;

import java.util.Arrays;

public class MinAbsSumOfTwo {

	public int solution(int[] A) {
		Arrays.sort(A);
		
		int startIndex = 0;
		int endIndex = A.length-1;
		int minAbsSum = Integer.MAX_VALUE;
		
		while(startIndex <= endIndex) {
			
			int absSum = Math.abs(A[startIndex] + A[endIndex]);
			if(absSum < minAbsSum) {
				minAbsSum = absSum;
			}
			
			if(Math.abs(A[startIndex]) > Math.abs(A[endIndex])) {
				startIndex++;
			} else {
				endIndex--;
			}
			
		}
		return minAbsSum;
		
		
	}

	public static void main(String[] args) {
		System.out.println(new MinAbsSumOfTwo().solution(new int[] { 1, 4, -3 }));
	}

}
