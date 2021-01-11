package net.davekirkwood.codility.lessons.timecomplexity;

import java.util.HashSet;

public class PermMissingElement {
	
   public int solution(int[] A) {
   	 
   	HashSet<Integer> list = new HashSet<>();
   	for(int i=1; i<=A.length+1; i++) {
   		list.add(i);
   	}
   	for(int i=0; i<A.length; i++) {
   		list.remove((Integer)A[i]);
   	}
   	return list.iterator().next();
   	
   }
   	
	public static void main(String[] args) {
		System.out.println(new PermMissingElement().solution(new int[] { 2,3,1,5 }));		//4
	}
	
}
