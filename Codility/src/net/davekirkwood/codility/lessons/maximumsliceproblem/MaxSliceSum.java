package net.davekirkwood.codility.lessons.maximumsliceproblem;

public class MaxSliceSum {

	public int solution(int[] A) {
			
		long sum = Integer.MIN_VALUE;
		long maxSum = Integer.MIN_VALUE;
		
		for(int a : A) {
			sum = Math.max(sum + a, a);
			maxSum = Math.max(sum, maxSum);
		}
		return (int)maxSum;
		
	}

	public static void main(String[] args) {

		System.out.println(new MaxSliceSum().solution(new int[] { 3, 2, -6, 4, 0 }));

	}
}
