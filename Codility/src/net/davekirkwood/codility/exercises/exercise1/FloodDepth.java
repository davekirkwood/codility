package net.davekirkwood.codility.exercises.exercise1;

public class FloodDepth {

	public int solution(int[] A) {
		
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		
		int leftHeight = 0;
		int rightHeight = 0;
		for(int i=0; i<A.length; i++) {
			leftHeight = Math.max(leftHeight, A[i]);
			left[i] = leftHeight;
			
			rightHeight = Math.max(rightHeight, A[A.length-1-i]);
			right[A.length-1-i] = rightHeight;
		}
		
		int maxDepth = 0;
		for(int i=0; i<A.length; i++) {
			
			int depth = Math.min(left[i], right[i]) - A[i];
			maxDepth = Math.max(maxDepth, depth);
		}
		return maxDepth;
		
		
	}

	public static void main(String[] args) {
		System.out.println(new FloodDepth().solution(new int[] {
				1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2
		}));
	}

}
