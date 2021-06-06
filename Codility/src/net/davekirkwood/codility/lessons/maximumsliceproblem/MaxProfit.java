package net.davekirkwood.codility.lessons.maximumsliceproblem;

public class MaxProfit {

	public int solution(int[] A) {
		
		int maxProfit = 0;
		
		int cumulativeProfit = 0;
		
		for(int i=1; i<A.length; i++) {
			int profitThisDay = A[i] - A[i-1];
			if(profitThisDay > maxProfit) {
				maxProfit = profitThisDay;
			}
			cumulativeProfit += profitThisDay;
			if(cumulativeProfit > 0) {
				if(cumulativeProfit > maxProfit) {
					maxProfit = cumulativeProfit;
				}
			} else {
				cumulativeProfit = 0;
			}
		}
		
		return maxProfit;
		
	}

	public static void main(String[] args) {

		System.out.println(new MaxProfit().solution(new int[] {
				23171,
				21011,
				21123,
				21366,
				21013,
				21367
		}));

	}

}
