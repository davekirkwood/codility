package net.davekirkwood.codility.lessons.caterpillarmethod;

import java.util.HashSet;

public class CountDistinctSlices {

	HashSet<Integer> caterpillar = new HashSet<>();
	int catFront = 0;
	int catRear = 0;
	int[] A;
	
	public int solution(int M, int[] A) {

		this.A = A;
		
		int count = 0;
		
		while(A.length > catFront || A.length > catRear) {
			if(A.length > catFront && !caterpillar.contains(A[catFront])) {
				moveHeadForward();
//				outputCat();
				count += caterpillar.size();
				if(count > 1000000000) {
					return 1000000000;
				}
			} else {
				moveTailForward();
//				outputCat();
			}
		}
		return count;
		
	}
	
	private void moveHeadForward() {
		caterpillar.add(A[catFront]);
		catFront++;
	}
	
	private void moveTailForward() {
		caterpillar.remove(A[catRear]);
		catRear++;
	}
	
//	private void outputCat() {
//		Iterator<Integer> iCat = caterpillar.iterator();
//		String s = "";
//		while(iCat.hasNext()) {
//			s += iCat.next() + " : ";
//		}
//		System.out.println(s);
//	}
//	

	public static void main(String[] args) {
//		System.out.println(new CountDistinctSlices().solution(6, new int[] { 3, 4, 5, 5, 2 }));
		System.out.println(new CountDistinctSlices().solution(6, new int[] { 1, 2, 3, 4, 5 }));
	}

}
