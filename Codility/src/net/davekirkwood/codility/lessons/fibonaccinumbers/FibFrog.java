package net.davekirkwood.codility.lessons.fibonaccinumbers;

import java.util.ArrayList;
import java.util.List;

public class FibFrog {

	List<Integer> fibNums;
	int[] A;
	int target;

	List<Integer> positions = new ArrayList<>();
	
	public int solution(int[] A) {
		this.A = A;
		target = A.length;

		fibNums = new ArrayList<>();
		fibNums.add(0);
		fibNums.add(1);
		for (int i = 0;; i++) {
			int nextFibNum = fibNums.get(i) + fibNums.get(i + 1);
			if (nextFibNum <= A.length + 1) {
				fibNums.add(nextFibNum);
			} else {
				break;
			}
		}

		
		int steps = 0;
		positions.add(-1);
		
		while(!positions.isEmpty()) {
			steps++;
			if(attemptJump()) {
				return steps;
			}
		}
		return -1;

	}

	public boolean attemptJump() {

		List<Integer> newPositions = new ArrayList<>();
		
		for(int position : positions) {

			for (int i = fibNums.size() - 1; i >= 2; i--) {
				int fibNum = fibNums.get(i);

				if (position + fibNum == target) {
					return true;
				}

				if (position + fibNum < target) {
					if(A[position + fibNum] == 1) {
						A[position + fibNum] = 0;
						newPositions.add(position+fibNum);
					}
				}
			}
		}
		
		positions = newPositions;
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new FibFrog().solution(new int[] {
				0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0
		}));
	}

}
