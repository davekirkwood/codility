package net.davekirkwood.codility.lessons.prefixsums;

public class PassingCars {

   public int solution(int[] A) {
   	int eastBoundCarsSeen = 0;
   	int passingCars = 0;
   	for(int a : A) {
   		if(a == 0) {
   			eastBoundCarsSeen++;
   		} else {
   			passingCars+=eastBoundCarsSeen;
   			if(passingCars > 1000000000) {
   				return -1;
   			}
   		}
   	}
   	return passingCars;
   }
	
	
	public static void main(String[] args) {
		PassingCars pc = new PassingCars();
		System.out.println(pc.solution(new int[] { 1 }));
	}
}
