package net.davekirkwood.codility.lessons.primeandcompositenumbers;

import java.util.ArrayList;
import java.util.List;

public class Flags {
	
   public int solution(int[] A) {
      
   	List<Integer> peaks = new ArrayList<>();
   	for(int i=1; i<A.length-1; i++) {
   		if(A[i-1] < A[i]) {
   			if(A[i+1] < A[i]) {
   				peaks.add(i);
   			}
   		}
   	}
   	
   	if(peaks.size() <= 1) {
   		return peaks.size();
   	}
   	
   	int maxFlags = (int)Math.ceil(Math.sqrt(peaks.get(peaks.size()-1) - peaks.get(0)));
   	
   	for(int flags = maxFlags; flags > 1; flags--) {
   		
   		int startIndex = 0;
   		int endIndex = peaks.size()-1;
   		
   		int startFlag = peaks.get(startIndex);
   		int endFlag = peaks.get(endIndex);
   		
   		int flagsPlaced = 2;
   		
   		while(startIndex < endIndex) {
   			
   			startIndex++;
   			endIndex--;
   			if(peaks.get(startIndex) >= startFlag + flags) {
   				if(peaks.get(startIndex) <= endFlag - flags) {
   					flagsPlaced++;
   					startFlag = peaks.get(startIndex);
   				}
   			}
   			
   			if(peaks.get(endIndex) >= startFlag + flags) {
   				if(peaks.get(endIndex) <= endFlag - flags) {
   					flagsPlaced++;
   					endFlag = peaks.get(endIndex);
   				}
   			}
   			
   			if(flagsPlaced == flags) {
   				return flags;
   			}
   			
   		}
   		
   		
   	}
   	return 0;
   	
   }
	
	public static void main(String[] args) {
		
		System.out.println(new Flags().solution(new int[] { 
				1,
			   5,
			   3,
			   4,
			   3,
			   4,
			   1,
			   2,
			   3,
			   4,
			   6,
			   2
		}));
				
	}
}
