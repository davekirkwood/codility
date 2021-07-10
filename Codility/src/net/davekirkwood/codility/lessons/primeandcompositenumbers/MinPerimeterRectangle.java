package net.davekirkwood.codility.lessons.primeandcompositenumbers;

public class MinPerimeterRectangle {

	public int solution(int N) {

		for(int i= (int)Math.ceil(Math.sqrt(N)); i>=1; i--) {
			if(((double)N/i) % 1 == 0) {
				return i*2 + ((N/i) * 2);
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		System.out.println(new MinPerimeterRectangle().solution(30));

	}

}
