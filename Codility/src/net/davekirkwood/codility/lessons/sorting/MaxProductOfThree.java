package net.davekirkwood.codility.lessons.sorting;

public class MaxProductOfThree {

	int[] smallest = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
	int[] largest = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
	
   public int solution(int[] A) {
      for(int a : A) {
      	considerLarge(a);
      	considerSmall(a);
      }
      
      int product1 = largest[0] * largest[1] * largest[2];
      int product2 = largest[0] * smallest[0] * smallest[1];
      return Math.max(product1, product2);
   }
   
   private void considerLarge(int a) {
   	if(a > largest[0]) {
   		largest[2] = largest[1];
   		largest[1] = largest[0];
   		largest[0] = a;
   	} else if(a > largest[1]) {
   		largest[2] = largest[1];
   		largest[1] = a;
   	} else if(a > largest[2]) {
   		largest[2] = a;
   	}
   }
   
   private void considerSmall(int a) {
   	if(a < smallest[0]) {
   		smallest[1] = smallest[0];
   		smallest[0] = a;
   	} else if(a < smallest[1]) {
   		smallest[1] = a;
   	}
   }
	
   public static void main(String[] args) {
   	
   	System.out.println(new MaxProductOfThree().solution(new int[] { 4, 5, 1, 0 } ));
   	
   }
}
