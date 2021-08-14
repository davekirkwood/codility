package net.davekirkwood.codility.lessons.euclideanalgorithm;

public class CommonPrimeDivisors {

	public int solution(int[] A, int[] B) {
		
		int count = 0;
		
		for(int i=0; i<A.length; i++) {
			if(hasAllPrimeFactors(A[i], B[i]) && hasAllPrimeFactors(B[i], A[i])) {
				count++;
			}
		}
		return count;
		
	}
	
	/**
	 * if all the prime factors of Y are factors of X, 
	 * then Y/gcd(X,Y) will be 1 or also contain only factors of X.
	 */
	private boolean hasAllPrimeFactors(int x, int y) {
		if(y==1) {
			return true;
		}
		int gcd = gcd(x, y, 1);
		if(gcd == 1) {
			return false;
		}
		return hasAllPrimeFactors(x, y/gcd);
	}
	

	public int gcd(int a, int b, int res) {
		if (a == b) {
			return res * a;
		} else if ((a % 2 == 0) && (b % 2 == 0)) {
			return gcd(a / 2, b / 2, 2 * res);
		} else if (a % 2 == 0) {
			return gcd(a / 2, b, res);
		} else if (b % 2 == 0) {
			return gcd(a, b / 2, res);
		} else if (a > b) {
			return gcd(a - b, b, res);
		} else {
			return gcd(a, b - a, res);
		}
	}

	public static void main(String[] args) {
		System.out.println(new CommonPrimeDivisors().solution(new int[] { 15, 10, 9 }, new int[] { 75, 30, 5 }));
	}

}