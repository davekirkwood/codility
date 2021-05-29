package net.davekirkwood.codility.lessons.leader;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {

	private int dominator;
	private int dominatorCount;
	
   public int solution(int[] A) {
   	
      Map<Integer, Integer> counters = new HashMap<>();
      for(int i=0; i<A.length; i++) {
      	int a = A[i];
      	if(!counters.containsKey(a)) {
      		counters.put(a, 1);
      	} else {
      		counters.put(a,  counters.get(a) + 1);
      	}
      	if(counters.get(a) > A.length/2) {
      		dominator = a;
      		dominatorCount = counters.get(a);
      	}
      }
      
      int equiLeaders = 0;
      
      int leadersInRightSide = dominatorCount;
      int countRightSide = A.length;
      int countLeftSide = 0;
      int leadersInLeftSide = 0;
      for(int i=0; i<A.length; i++) {
      	if(A[i] == dominator) {
      		leadersInRightSide--;
      		leadersInLeftSide++;
      	}
      	countLeftSide++;
      	countRightSide--;
      	
      	if(leadersInLeftSide > countLeftSide / 2) {
         	if(leadersInRightSide > countRightSide / 2) {
         		equiLeaders++;
         	}
         	
      	}
      }
      
      
      return equiLeaders;
   }
	
	public static void main(String[] args) {
		System.out.println(new EquiLeader().solution(new int[] {  }));
	}
	
}
