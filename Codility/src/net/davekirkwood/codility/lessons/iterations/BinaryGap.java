package net.davekirkwood.codility.lessons.iterations;

public class BinaryGap {

   public int solution(int N) {

   	String bString = Integer.toString(N, 2);

   	boolean started = false;
   	
   	int counter = 0;
   	int maxCount = 0;
   	
   	for(int i=0; i<bString.length(); i++) {
   		String c = bString.substring(i, i+1);
   		if(c.equals("1")) {
   			if(started) {
   				if(counter > maxCount) {
   					maxCount = counter;
   				}
   			}
   			counter = 0;
   			started = true;
   		}
   		if(c.equals("0")) {
   			counter++;
   		}
   	}
   	
   	return maxCount;
   }
	
	public static void main(String[] args) {
		BinaryGap gb = new BinaryGap();
		System.out.println(gb.solution(1041));
	}
	
}
