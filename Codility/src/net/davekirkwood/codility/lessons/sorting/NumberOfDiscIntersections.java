package net.davekirkwood.codility.lessons.sorting;

public class NumberOfDiscIntersections {

	public int solution(int[] A) {
		int[] starts = new int[A.length];
		for(int i = 0; i<A.length; i++) {
			int radius = A[i];
			int startPos = i-radius;
			if(startPos < 0) {
				startPos = 0;
			}
			starts[startPos]++;
		}
		
		int total = 0;
		for(int i =0 ;i<starts.length; i++) {
			total += starts[i];
			starts[i] = total;
		}
		
		int totalIntersections = 0;
		for(long i=0; i<A.length; i++) {
			long radius = A[(int)i];
			long endPos = i+radius;
			if(endPos > A.length-1) {
				endPos = A.length-1;
			}
			int intersections = (int)(Math.max(starts[(int)i], starts[(int)endPos]) - (i+1));
			totalIntersections += intersections;
			if(totalIntersections > 10000000) {
				return -1;
			}
		}
		return totalIntersections;
	}

	public static void main(String[] args) {
		System.out.println(new NumberOfDiscIntersections().solution(new int[] { 1, 5, 2, 1, 4, 0 }));
	}

}
