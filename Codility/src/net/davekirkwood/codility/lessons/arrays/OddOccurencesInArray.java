package net.davekirkwood.codility.lessons.arrays;
import java.util.HashSet;

public class OddOccurencesInArray {

	HashSet<Integer> aList = new HashSet<Integer>();
	
   public int solution(int[] A) {
      
   	for(int i=0; i<A.length; i++) {
   		int a = A[i];
   		if(aList.contains(a)) {
   			aList.remove(new Integer(a));
   		} else {
   			aList.add(a);
   		}
   	}
   	
   	return aList.iterator().next();
   	
   }
	
	public static void main(String[] args) {
		OddOccurencesInArray ooia = new OddOccurencesInArray();
		ooia.solution(new int[] { 9, 3, 9, 3, 9, 7, 9 });
	}
	
}
