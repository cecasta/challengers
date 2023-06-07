package com.challenger.budget.hackerang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvenDifference01 {

	
	public static int findLongestSubsequence(List<Integer> arr) {
		Collections.sort(arr);
		int primerPar = encontrarPrimerPar(arr);
        int ultimoPar = encontrarUltimoPar(arr);
        int primerImpar = encontrarPrimerImpar(arr);
        int ultimoImpar = encontrarUltimoImpar(arr);
		
        int result = 1;
   	    if (primerImpar != -1)
   	    	result = Math.max(result, ultimoImpar - primerImpar + 1);
	    if (primerPar != -1)
	    	result = Math.max(result, ultimoPar - primerPar + 1);
	    return result;
	}
	
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(5);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(4);

        System.out.println(findLongestSubsequence(arr));
    }

    private static int encontrarPrimerPar(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1; // No se encontró ningún número par
    }

    private static int encontrarUltimoPar(List<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1; // No se encontró ningún número par
    }

    private static int encontrarPrimerImpar(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1; // No se encontró ningún número impar
    }

    private static int encontrarUltimoImpar(List<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1; // No se encontró ningún número impar
    }

}
