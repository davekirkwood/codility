package net.davekirkwood.codility.lessons.dynamicprogramming;

public class NumberSolitaire {

	public int solution(int[] A) {

		int[] r = new int[A.length];
		
		for(int i=0; i<r.length; i++) {
			
			if(i==0) {
				r[i] = A[i];
			} else {
				
				int maxOnThisSquare = Integer.MIN_VALUE;
				for(int j=1; j<=6; j++) {
					if(i-j >=0) {
						maxOnThisSquare = Math.max(maxOnThisSquare, r[i-j] + A[i]);
					}
				}
				r[i] = maxOnThisSquare;
				
			}
			
		}
		return r[r.length-1];
		
		
	}

	public static void main(String[] args) {

		System.out.println(new NumberSolitaire().solution(new int[] {
		
				1,
				-2,
				0,
				9,
				-1,
				-2
				
		}));
		
	   
		
	}

}
