package net.davekirkwood.codility.lessons.greedyalgorithm;

public class TieRopes {

	public int solution(int K, int[] A) {

		int currentLength = 0;
		int ropes = 0;
		
		for(int i=0; i<A.length; i++) {
			currentLength += A[i];
			if(currentLength >= K) {
				ropes++;
				currentLength = 0;
			}
		}
		
		return ropes;
		
	}

	public static void main(String[] args) {
		System.out.println(new TieRopes().solution(4, new int[] {
			    1, 2, 3, 4, 1, 1, 3
		}));
	}

}
