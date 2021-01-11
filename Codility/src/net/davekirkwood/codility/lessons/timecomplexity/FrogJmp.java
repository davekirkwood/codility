package net.davekirkwood.codility.lessons.timecomplexity;

public class FrogJmp {

   public int solution(int x, int y, int D) {
   	
   	int distance = y-x;
   	int jumps = (int)Math.ceil(distance / (double)D);
   	return jumps;
   }
   	
	public static void main(String[] args) {
		System.out.println(new FrogJmp().solution(10, 85, 30));
		System.out.println(new FrogJmp().solution(10, 10, 30));
	}
	
}
