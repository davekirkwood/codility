package net.davekirkwood.codility.lessons.prefixsums;

public class GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q) {
		
		int[][] counters = new int[3][S.length() + 1];
		
		int a = 0;
		int c = 0;
		int g = 0;
		
		for(int i=0; i<S.length(); i++) {
			String ch = S.substring(i, i+1);
			if(ch.equals("A")) {
				a++;
			} else if(ch.equals("C")) {
				c++;
			} else if(ch.equals("G")) {
				g++;
			}
			counters[0][i+1] = a;
			counters[1][i+1] = c;
			counters[2][i+1] = g;
		}
		
		int[] result = new int[P.length];
		for(int i = 0; i<result.length; i++) {
			int startIndex = P[i];
			int endIndex = Q[i] + 1;
			
			int r = 4;
			
			for(int j=0; j<3; j++) {
				if(counters[j][startIndex] != counters[j][endIndex]) {
					r = j+1;
					break;
				}
			}
			result[i] = r;
		}
		return result;
		
	}

	public static void main(String[] args) {
		
		GenomicRangeQuery grq = new GenomicRangeQuery();
		int[] result = grq.solution("CAGCCTA",
				new int[] { 2,5,0 }, new int[] { 4,5,6 });
		for(int i : result) {
			System.out.println(i);
		}
	}

}
