package net.davekirkwood.codility.lessons.fibonaccinumbers;

public class Ladder {

	public int[] solution(int[] A, int[] B) {

		int[] result = new int[A.length];
		
		int maxA = 0;
		for(int i=0; i<A.length; i++) {
			maxA = Math.max(maxA, A[i]);
		}
		
		int[] fibs = new int[A.length+1];
		fibs[0] = 1;
		fibs[1] = 1;
		for(int i=2; i<A.length+1; i++) {
			fibs[i] = (fibs[i-2] + fibs[i-1]) % (int)Math.pow(2, 30);
		}
		
		for(int i=0; i<A.length; i++) {
			int m = (int)Math.pow(2, B[i]);
			result[i] = fibs[A[i]] % m;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		int[] result = new Ladder().solution(
				new int[] { 4, 4, 5, 5, 1 }, 
				new int[] { 3, 2, 4, 3, 1 } );
		
		for(int r : result) {
			System.out.println(r);
		}
		
	}
}
