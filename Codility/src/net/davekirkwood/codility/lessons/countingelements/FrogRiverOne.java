package net.davekirkwood.codility.lessons.countingelements;

import java.util.HashSet;

public class FrogRiverOne {

   public int solution(int X, int[] A) {
      
   	HashSet<Integer> hs = new HashSet<>();
      for(int i=1; i<=X; i++) {
      	hs.add(i);
      }
      
      for(int i=0; i<A.length; i++) {
      	if(hs.remove(A[i])) {
      		if(hs.isEmpty()) {
      			return i;
      		}
      	}
      }
      return -1;
   }
   
   public static void main(String[] args) {
   	
   	FrogRiverOne fro = new FrogRiverOne();
   	
   	System.out.println(fro.solution(5, new int[] { 1,3,1,4,2,3,5,4 } ));
   	System.out.println(fro.solution(1, new int[] { 1 } ));

   	
   }
   
}
