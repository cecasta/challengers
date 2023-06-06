package com.challenger.budget.hackerang;

import java.util.HashSet;
import java.util.Set;

public class ShortestSubstring02 {

	    public static int findMinLength(String s) {
	        int n = s.length();
	        Set<Character> uniqueChars = new HashSet<>();
	        int len = 0;
	        for (int i = 0; i < n; i++) {
	            if (uniqueChars.contains(s.charAt(i))) {
	                for (int j = n - 1; j >= i; j--) {
	                    if (uniqueChars.contains(s.charAt(j))) {
	                        len = j - i + 1;
	                        break;
	                    } else {
	                        uniqueChars.add(s.charAt(j));
	                    }
	                }
	                break;
	            } else {
	                uniqueChars.add(s.charAt(i));
	            }
	        }
	        return len;
	    }
	    
	    public static int findShortestSubstring(String s) {
	        int ans = findMinLength(s);
	        s = new StringBuilder(s).reverse().toString();
	        ans = Math.min(ans, findMinLength(s));
	        return ans;
	    }
	    
	    public static void main(String[] args) {
	        String input = "abcbbk"; // Reemplaza con tu cadena de entrada
	        int minLength = findMinLength(input);
	        System.out.println("Longitud mínima de la subcadena: " + minLength);
	        
	        int shortestSubstring = findShortestSubstring(input);
	        System.out.println("Subcadena más corta: " + shortestSubstring);
	    }
}


