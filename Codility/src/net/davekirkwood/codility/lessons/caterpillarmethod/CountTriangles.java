package net.davekirkwood.codility.lessons.caterpillarmethod;

import java.util.Arrays;

public class CountTriangles {

	public int solution(int[] A) {
		
		Arrays.sort(A);

		// 1, 2, 5, 8, 10, 12
		
		int triangles = 0;
		
		for(int catBack = 0; catBack < A.length-2; catBack++) {
			
			int catFront = catBack + 2;
			
			for(int m = catBack + 1; m<A.length-1; m++) {
				
				while(catFront < A.length && A[catBack] + A[m] > A[catFront]) {
					catFront++;
				}
				triangles += catFront - m - 1;
				
			}
		}
		
		return triangles;
		
		
	}

	public static void main(String[] args) {

		System.out.println(new CountTriangles().solution(new int[] {
				10, 2, 5, 1, 8, 12
		}));

	}
}
