package net.davekirkwood.codility.lessons.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

public class CountSemiPrimes {

	public int[] solution(int N, int[] P, int[] Q) {
		
		/*
		 * Find Primes (2, 3, 5, 7, 11 and 13) 
		 */
		boolean[] notPrimes = new boolean[N+1];
		for(int a = 2; a<=N/2; a++) {
			for(int b = a * 2; b<=N; b += a) {
				notPrimes[b] = true;
			}
		}
		
		List<Integer> primes = new ArrayList<>();
		for(int a = 2; a <= N; a++) {
			if(!notPrimes[a]) {
				primes.add(a);
			}
		}
		
		/*
		 * Find semi-primes (4, 6, 9, 10, 14, 15, 21, 22, 25, 26)
		 */
		int[] semiPrimes = new int[N+1];
		for(int a = 0; a<primes.size()-1; a++) {
			for(int b = a; b<primes.size()-1; b++) {
				int primea = primes.get(a);
				int primeb = primes.get(b);
				if((long)primea*primeb >= semiPrimes.length) {
					break;
				}
				semiPrimes[primea*primeb] = 1;
			}
		}
		
		int c = 0;
		for(int i=0; i<semiPrimes.length; i++) {
			c += semiPrimes[i];
			semiPrimes[i] = c;
		}
		
		/*
		 * Get result
		 */
		int[] result = new int[P.length];
		
		for(int i=0; i<P.length; i++) {
			result[i] = semiPrimes[Q[i]] - semiPrimes[P[i]-1];
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		int[] answer = new CountSemiPrimes().solution(26, new int[] { 1, 4, 16 }, new int[] { 26, 10, 20 });
		for (int a : answer) {
			// Expect 10,4,0
			System.out.println(a);
		}

	}

}
