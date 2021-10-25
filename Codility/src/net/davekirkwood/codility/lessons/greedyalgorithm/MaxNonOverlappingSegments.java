package net.davekirkwood.codility.lessons.greedyalgorithm;

public class MaxNonOverlappingSegments {

	public int solution(int[] A, int[] B) {
		
		int currentPosition = -1;
		int segmentCount = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] > currentPosition) {
				currentPosition = B[i];
				segmentCount++;
			}
		}
		
		return segmentCount;
		
	}

	public static void main(String[] args) {

		System.out.println(new MaxNonOverlappingSegments().solution(
				new int[] { 1, 3, 7, 9, 9 },
				new int[] { 5, 6, 8, 9, 10 }));
		
		System.out.println(new MaxNonOverlappingSegments().solution(
				new int[] { },
				new int[] { }));

		System.out.println(new MaxNonOverlappingSegments().solution(
				new int[] { 1 },
				new int[] { 2 }));

	}

}
