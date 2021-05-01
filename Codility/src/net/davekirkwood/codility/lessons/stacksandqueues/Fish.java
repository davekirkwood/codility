package net.davekirkwood.codility.lessons.stacksandqueues;

import java.util.Stack;

public class Fish {

   public int solution(int[] A, int[] B) {
   	
   	int survivals = 0;
   	Stack<Integer> stack = new Stack();
   	
      for(int i=0; i<A.length; i++) {
      	int fish = A[i];
      	int direction = B[i];
      	if(direction == 0) {
      		boolean survives = true;
      		while(!stack.isEmpty()) {
      			int oppFish = stack.pop();
      			if(oppFish > fish) {
      				stack.push(oppFish);
      				survives = false;
      				break;
      			}
      		}
      		if(survives) {
      			survivals++;
      		}
      	} else {
      		stack.push(fish);
      	}
      }
      survivals += stack.size();
      return survivals;
   }
	
	public static void main(String[] args) {
		
		System.out.println(new Fish().solution(
				new int[] { 4, 3, 2, 1, 5 }, 
				new int[] { 0, 1, 0, 0, 0 }
			));
		
	}
	
}
