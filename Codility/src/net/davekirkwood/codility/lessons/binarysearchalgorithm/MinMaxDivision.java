package net.davekirkwood.codility.lessons.binarysearchalgorithm;

public class MinMaxDivision {

	public int solution(int K, int M, int[] A) {
		
		int min = 0;
		int max = 0;
		for(int a : A) {
			max += a;
			min = Math.max(min, a);
		}
		
		int bestAnswer = max;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int blocks = checkBlocks(A, mid);
			if(blocks > K) {
				min = mid + 1;
			} else {
				max = mid - 1;
				if(mid < bestAnswer) {
					bestAnswer = mid;
				}
			}
		}
		return bestAnswer;
		
	}
	
	private int checkBlocks(int[] A, int guess) {
		int blocks = 1;
		int blockSum = 0;
		
		for(int a : A) {
			blockSum += a;
			if(blockSum > guess) {
				blockSum = a;
				blocks++;
			}
		}
		return blocks;
		
	}

	public static void main(String[] args) {

		System.out.println(new MinMaxDivision().solution(
				3, 
				5,
				new int[] { 2, 1, 5, 1, 2, 2, 2 }
				));
		
	}

}
