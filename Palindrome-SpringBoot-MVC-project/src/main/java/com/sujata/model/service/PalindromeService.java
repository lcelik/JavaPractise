package com.sujata.model.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
	

	public int getPalindrome(int number) {

		int palindrome = 0;
		
		while(number > 0) {
			
			int remainder=number%10;
			palindrome = palindrome * 10 + remainder;
			number = number/10;
		}
		return palindrome;
	}
	

	
	
	
	
	
	
//	public boolean getPalindrome(int number) {
//        int temp = number;
//        int sum=0;
//        while (number > 0) {
//            int r = number % 10;  //getting remainder
//            sum = (sum * 10) + r;
//            number = number / 10;
//        }
//        if (temp == sum)
//           return true;
//        else
//            return false;
//    }
	

}


