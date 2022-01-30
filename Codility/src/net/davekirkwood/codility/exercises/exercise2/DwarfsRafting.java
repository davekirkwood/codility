package net.davekirkwood.codility.exercises.exercise2;

public class DwarfsRafting {

	private static int EMPTY_CELL = 0;
	private static int BARREL = 1;
	private static int DWARF = 2;
	
	class Raft {
		
		int[][] cells;
		
		int size;
		
		int staticDwarfs = 0;
		
		public Raft(int size) {
			this.size = size;
			cells = new int[size][size];
		}
		
		public void addBarrel(int x, int y) {
			cells[x][y] = BARREL;
		}
		
		public void addDwarf(int x, int y) {
			cells[x][y] = DWARF;
			staticDwarfs++;
		}
		
		public int getSeats() {
			
			int maxTopLeft = getSeats(0, size/2, 0, size/2);
			int maxTopRight = getSeats(size/2, size, 0, size/2);
			int maxBottomLeft = getSeats(0, size/2, size/2, size);
			int maxBottomRight = getSeats(size/2, size, size/2, size);
			
			int minTopLeft = getMinSeats(0, size/2, 0, size/2);
			int minTopRight = getMinSeats(size/2, size, 0, size/2);
			int minBottomLeft = getMinSeats(0, size/2, size/2, size);
			int minBottomRight = getMinSeats(size/2, size, size/2, size);
			
			if(minTopLeft > maxBottomRight) {
				return -1;
			}
			if(minBottomRight > maxTopLeft) {
				return -1;
			}
			if(minTopRight > maxBottomLeft) {
				return -1;
			}
			if(minBottomLeft > maxTopRight) {
				return -1;
			}
			
			int diag1 = Math.min(maxTopLeft, maxBottomRight);
			int diag2 = Math.min(maxTopRight, maxBottomLeft);
			
			return (diag1 * 2) + (diag2 * 2) - staticDwarfs;
			
		}
		
		private int getSeats(int minX, int maxX, int minY, int maxY) {
			
			int seats = 0;
			
			for(int x = minX; x<maxX; x++) {
				for(int y = minY; y<maxY; y++) {
					if(cells[x][y] != BARREL) {
						seats++;
					}
				}
			}
			return seats;
			
		}
		
		private int getMinSeats(int minX, int maxX, int minY, int maxY) {
			
			int seats = 0;
			
			for(int x = minX; x<maxX; x++) {
				for(int y = minY; y<maxY; y++) {
					if(cells[x][y] == DWARF) {
						seats++;
					}
				}
			}
			return seats;
			
		}
		
		public String toString() {
			
			String s = "";
			
			for(int x = 0; x<size; x++) {
				for(int y = 0; y<size; y++) {
					if(cells[x][y] == EMPTY_CELL) {
						s += " |";
					}
					if(cells[x][y] == BARREL) {
						s += "B|";
					}
					if(cells[x][y] == DWARF) {
						s += "D|";
					}
				}
				s += "\n---------------------\n";
			}
			return s;
			
		}
		
	}
	
	public int solution(int N, String S, String T) {

		Raft raft = new Raft(N);
		
		if(S.trim().length() > 0) {
			for(int[] coordinate : getCoordinates(S)) {
				raft.addBarrel(coordinate[0], coordinate[1]);
			}
		}
		
		if(T.trim().length() > 0) {
			for(int[] coordinate : getCoordinates(T)) {
				raft.addDwarf(coordinate[0], coordinate[1]);
			}
		}
		
		return raft.getSeats();
	}
	
	private int[][] getCoordinates(String s) {
		
		String[] sCoords = s.split(" ");
		int[][] coords = new int[sCoords.length][2];
		for(int i=0; i<sCoords.length; i++) {
			String sCoord = sCoords[i];
			int x = Integer.valueOf(sCoord.substring(0, sCoord.length()-1)) - 1;
			int y = (int)sCoord.charAt(sCoord.length()-1) - (int)'A';
			coords[i][0] = x;
			coords[i][1] = y;
		}
		return coords;
		
	}

	public static void main(String[] args) {
		
		System.out.println(new DwarfsRafting().solution(4, "1B 1C 4B 1D 2A", "3B 2D"));
		
	}
	
}
