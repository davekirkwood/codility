package net.davekirkwood.codility.lessons.prefixsums;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		
		int indexOfMinOf2 = -1;
		int minSumOf2 = Integer.MAX_VALUE;
		
		int indexOfMinOf3 = -1;
		int minSumOf3 = Integer.MAX_VALUE;
		
		for(int i = 0; i<A.length-1; i++) {
			int val1 = A[i];
			int val2 = A[i+1];
			int sumOf2 = val1 + val2;
			if(sumOf2 < minSumOf2) {
				minSumOf2 = sumOf2;
				indexOfMinOf2 = i;
			}
			
			if(i < A.length-2) {
				int val3 = A[i+2];
				int sumOf3 = val1 + val2 + val3;
				if(sumOf3 < minSumOf3) {
					minSumOf3 = sumOf3;
					indexOfMinOf3 = i;
				}
					
			}
		}
		if(indexOfMinOf3 == -1) {
			return indexOfMinOf2;
		}
		double avg2 = (double)minSumOf2 / 2;
		double avg3 = (double)minSumOf3 / 3;
		if(avg2 < avg3) {
			return indexOfMinOf2;
		}
		if(avg3 < avg2) {
			return indexOfMinOf3;
		}
		return Math.min(indexOfMinOf2, indexOfMinOf3);
	}
	
	public static void main(String[] args) {
		MinAvgTwoSlice mats = new MinAvgTwoSlice();
		System.out.println(mats.solution(new int[] { 10, 11, -20, 5 }));
	}
	
	
}
