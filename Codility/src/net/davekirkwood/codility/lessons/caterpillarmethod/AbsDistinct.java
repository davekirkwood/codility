package net.davekirkwood.codility.lessons.caterpillarmethod;

import java.util.HashSet;

public class AbsDistinct {

	public int solution(int[] A) {
		HashSet<Long> distinctValues = new HashSet<>();
		int count = 0;
		for(int a : A) {
			if(distinctValues.contains(Math.abs((long)a))) {
				
			} else {
				distinctValues.add(Math.abs((long)a));
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(new AbsDistinct().solution(new int[] { -5, -3, -1, 0, 3, 6 }));

	}

}
