package com.challenger.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContarRepetidosArray {
	List<Integer> unicos = new ArrayList<>();
	
	// esta opcion no es optima tiene una complejidad n2
	public void optionOne(int[] arr) {
		for (int i=0;i < arr.length;i++) {
			int numero = arr[i];
			int contador = 0;
			if(unicos.contains(numero)) continue;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == numero) contador++;
			}
			unicos.add(numero);
			System.out.println("Numero: " + numero +", cantidad: "+contador);
		}	
	}
	
	public void optionTwo(int[] arr) {
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		for(int numero : arr) {
			if(countMap.containsKey(numero)) {
				Integer cont = countMap.get(numero) +1;
				countMap.put(numero, cont);
			}else {
				countMap.put(numero, 1);
			}
		}
		countMap.forEach((n, v) -> {
			System.out.println("Numero: " + n +", cantidad: "+ v);
		});

	}
	
	
	
	public static void main(String args[]) {
		int[] arr = {2,2,4,5,5,1,4,5,1,2};
		ContarRepetidosArray obj = new ContarRepetidosArray();
		//obj.optionOne(arr);
		obj.optionTwo(arr);
		
	}
	

}
