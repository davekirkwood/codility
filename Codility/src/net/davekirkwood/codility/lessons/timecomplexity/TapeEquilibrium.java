package net.davekirkwood.codility.lessons.timecomplexity;

public class TapeEquilibrium {

   public int solution(int[] A) {
   	int numbersOnRight = 0;
   	for(int i=0; i<A.length; i++) {
   		numbersOnRight += A[i];
   	}
   	
   	int minDiff = Integer.MAX_VALUE;
   	
   	int numberOnLeft = 0;
   	for(int i=0; i<A.length-1; i++) {
   		numbersOnRight -= A[i];
   		numberOnLeft += A[i];
   		if(Math.abs(numberOnLeft - numbersOnRight) < minDiff) {
   			minDiff = Math.abs(numberOnLeft - numbersOnRight);
   		}
   	}
   	return minDiff;
   }
   	
	public static void main(String[] args) {
		System.out.println(new TapeEquilibrium().solution(new int[] { 1000,-1000 }));
	}
	
}
