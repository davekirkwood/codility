package net.davekirkwood.codility.exercises.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangleBuilderGreaterArea {

	public int solution(int[] A, int X) {

		Map<Integer, Integer> fenceCounts = new HashMap<>();
		
		List<Integer> fences = new ArrayList<>();
		
		int pens = 0;
		
		for(int a : A) {
			fenceCounts.put(a, fenceCounts.get(a) == null ? 1 : fenceCounts.get(a) + 1);
			if(fenceCounts.get(a) == 2) {
				fences.add(a);
			}
			if(fenceCounts.get(a) == 4) {
				if((long)a*a >= X) {
					pens++;
				}
			}
		}
		
		Collections.sort(fences);
		
		int longIndex = fences.size()-1;
		int shortIndex = 0;
		
		while(shortIndex < fences.size()-1) {
			
			while(shortIndex < longIndex && 
					(long)fences.get(shortIndex) * fences.get(longIndex) >= X) {
				longIndex--;
			}
			
			pens += fences.size()-1 - longIndex;
			
			if(pens > 1000000000) {
				return -1;
			}
			
			shortIndex++;
			
			longIndex = Math.max(longIndex, shortIndex);
			
		}
		
		return pens;
		
	}

	public static void main(String[] args) {

		int[] A = new int[9];
		A[0] = 1;
		A[1] = 2;
		A[2] = 5;
		A[3] = 1;
		A[4] = 1;
		A[5] = 2;
		A[6] = 3;
		A[7] = 5;
		A[8] = 1;
		
		int X = 5;
		
		System.out.println(new RectangleBuilderGreaterArea().solution(A, X));

	}

}
