package net.davekirkwood.codility.exercises.exercise2;

import java.util.HashMap;
import java.util.Map;

public class HilbertMaze {

	enum ROTATION { Q1, Q2, Q3, Q4 };
	
	class Quarter {
		Point rootPoint;
		ROTATION rotation;
	}
	
	Map<Step, Integer> steps = new HashMap<>();
	
	public int takeStep(int x, int y, int stepsTaken) {
		Step step = new Step(x, y);
		if(steps.containsKey(step)) {
			return steps.get(step) + stepsTaken - 1;
		} else {
			steps.put(step, stepsTaken);
			return -1;
		}
	}
	
	class Step {
		int x;
		int y;
		
		/**
		 * @param x
		 * @param y
		 * @param steps
		 */
		public Step(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		private HilbertMaze getEnclosingInstance() {
			return HilbertMaze.this;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Step other = (Step) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	class Point {
		int x;
		int y;
		
		public Quarter getQuarter(int size) {
			int baseUnit = (int) (Math.pow(2, size-1)*4);		//1=4, 2=8, 3=16
			if(x % baseUnit == 0 || y % baseUnit == 0) {
				return null;
			}
			else {
				int relX = x-baseUnit;
				int relY = y-baseUnit;
			}
			
			
			return null;
		}

		
	}

	public int solution(int N, int A, int B, int C, int D) {
		
		/*
		 * From small to big
		 * 
		 * 	For start and end
		 * 		If not on edge
		 * 			Work out rotation
		 * 			Walk to route square or edge square / check intersection along way.
		 * 
		 * 
		 */
		
		for(int n=0; n<N; n++) {
			
			
			
		}
		
		return -1;
	}

	public static void main(String[] args) {

		/*
		 * Given N = 1, A = 2, B = 1, C = 3 and D = 4 the function should return 8, as
		 * shown above.
		 * Given N = 2, A = 2, B = 5, C = 6 and D = 6 the function should return 7:
		 * Given N = 3, A = 6, B = 6, C = 10 and D = 13 the function should return 39:
		 */

		int N = 1;
		int A = 2;
		int B = 1;
		int C = 3;
		int D = 4;
		// Expected 8
		System.out.println(new HilbertMaze().solution(N, A, B, C, D));

		N = 2;
		A = 2;
		B = 5;
		C = 6;
		D = 6;
		// Expected 7
		System.out.println(new HilbertMaze().solution(N, A, B, C, D));

		N = 3;
		A = 6;
		B = 6;
		C = 10;
		D = 13;
		// Expected 39
		System.out.println(new HilbertMaze().solution(N, A, B, C, D));

		
		
	}

}
