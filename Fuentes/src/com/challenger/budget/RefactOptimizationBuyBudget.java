package com.challenger.budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Iterator;

/*
 * Java Optimization Algorithm
 * Assume now James have 900 bucks and there are 4 items in a shop in different price.
 * ref: https://stackoverflow.com/questions/58343689/java-optimization-algorithm
 */
public class RefactOptimizationBuyBudget {

	static ArrayList<Integer> acomuladoResult;
	static Integer ultimoValorestaBalance;

	static Map<Integer, ArrayList<Integer>> handleAllSumPossibilities(ArrayList<Integer> itemList, int balance,
			ArrayList<Integer> combination, Map<Integer, ArrayList<Integer>> qualifyItemsCombination) {

		int sum = 0;
		Integer remain = null;

		for (int x : combination) {
			sum += x;
		}
		

		if (sum <= balance && sum != 0) {
			remain = (balance - sum);

			qualifyItemsCombination.put(remain, combination);
			if (ultimoValorestaBalance == null || ultimoValorestaBalance >= remain) {
				
				if(ultimoValorestaBalance != null && ultimoValorestaBalance == remain) {
					acomuladoResult = combination.size() > acomuladoResult.size()? qualifyItemsCombination.put(remain, combination) : acomuladoResult;	
				}else {
					acomuladoResult = qualifyItemsCombination.put(remain, combination);
				}
				
				ultimoValorestaBalance = remain;
			
			}
		}

		for (int i = 0; i < itemList.size(); i++) {
			ArrayList<Integer> remainingItems = new ArrayList<Integer>();

			int pointingItem = itemList.get(i);
			for (int j = i + 1; j < itemList.size(); j++)
				remainingItems.add(itemList.get(j));

			ArrayList<Integer> combinationRecord = new ArrayList<Integer>(combination);

			combinationRecord.add(pointingItem);

			Map<Integer, ArrayList<Integer>> retrievedItemsCombination = handleAllSumPossibilities(remainingItems,
					balance, combinationRecord, qualifyItemsCombination);
			qualifyItemsCombination = retrievedItemsCombination;

		}
		return qualifyItemsCombination;
	}

	static ArrayList<Integer> findBestCombination(ArrayList<Integer> itemList, int balance) {
		acomuladoResult = new ArrayList<Integer>();
		handleAllSumPossibilities(itemList, balance, new ArrayList<Integer>(), new HashMap<>());
		return acomuladoResult;
	}

	public static void main(String args[]) {
		ArrayList<Integer> itemList = new ArrayList<>();
        
        itemList.add(327);
        itemList.add(422);
        itemList.add(241);
        itemList.add(634);
        itemList.add(712);
        itemList.add(308);
        itemList.add(551);


		int balance = 1610;
		ArrayList<Integer> result = findBestCombination(itemList, balance);
//		for (int i = 0; i < result.size(); i++)
//			System.out.println(result.get(i));

		System.out.println(ultimoValorestaBalance);
		System.out.println(result.toString());

	}
}