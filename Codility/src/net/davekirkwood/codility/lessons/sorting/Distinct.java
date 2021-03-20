package net.davekirkwood.codility.lessons.sorting;

import java.util.HashSet;

public class Distinct {

	
	
	public int solution(int[] A) {

		HashSet<Integer> h = new HashSet();
		for(int a : A) {
			h.add(a);
		}
		
		return h.size();
		
	}

	public static void main(String[] args) {
		Distinct d = new Distinct();
		System.out.println(d.solution(new int[] { }));
	}
}
