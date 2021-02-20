package net.davekirkwood.codility.lessons.prefixsums;

public class CountDiv {

   public int solution(int A, int B, int K) {
      
   	int base = (int)Math.ceil((double)A / K);
   	base *= K;
   	B-=base;
   	int count = (int)Math.floor((double)B / K);
   	count++;
   	return count;
   	
   }
   
   public static void main(String[] args) {
   	CountDiv cd = new CountDiv();
   	System.out.println(cd.solution(0, 12, 1));
   }
   
}
