package net.davekirkwood.codility.exercises.exercise1;

public class LongestPassword {

	public int solution(String S) {
		String[] words = S.split(" ");
		int longestWord = -1;
		for(String word : words) {
			if(checkWord(word)) {
				longestWord = Math.max(longestWord, word.length());
			}
		}
		return longestWord;
	}
	
	public boolean checkWord(String word) {
		int letterCount = 0;
		int numberCount = 0;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(Character.isUpperCase(c) || Character.isLowerCase(c)) {
				letterCount++;
			} else if(Character.isDigit(c)) {
				numberCount++;
			} else {
				return false;
			}
		}
		return(letterCount % 2 == 0 && numberCount % 2 ==1);
	}

	public static void main(String[] args) {
//		System.out.println(new LongestPassword().solution("test 5 a0A pass007 ?xy1"));
		System.out.println(new LongestPassword().solution("abcdef£123 abcdefg123 abcdefg1234"));
	}

}
