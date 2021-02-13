package net.davekirkwood.codility.lessons.countingelements;

import java.util.HashSet;

public class PermCheck {

	public int solution(int[] A) {
		HashSet<Integer> nums = new HashSet<>();
		for(int i=1; i<=A.length; i++) {
			nums.add(i);
		}
		
		for(int a : A) {
			if(!nums.contains(a)) {
				return 0;
			} else {
				nums.remove(a);
			}
		}
		
		return nums.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) {
		PermCheck pc = new PermCheck();
		System.out.println(pc.solution(new int[] { 1 }));
	}

}
