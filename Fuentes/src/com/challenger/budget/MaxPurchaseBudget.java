package com.challenger.budget;

import java.util.Arrays;

public class MaxPurchaseBudget {

	
	public static int CalcMaxPurchasedItems(int budget, int[] itemPrices)
	{
		int itemsPurchased = 0;

		Arrays.sort(itemPrices);

		for (int i : itemPrices) {
			budget -= i;

			if (budget < 0)
				break;

			itemsPurchased++;
			//System.out.println(i);
		}
		


		return itemsPurchased;
	}

	
	public static void main(String[] args) {
		int budget = 10;
		//int cost[] = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 };
		int itemPrices[] = { 20 };
		System.out.println(CalcMaxPurchasedItems(budget,itemPrices));
		
		budget = 10;
		int itemPrices2[] = { 5, 6 };
		System.out.println(CalcMaxPurchasedItems(budget,itemPrices2));
		
		budget = 10;
		int itemPrices3[] = { 5 };
		System.out.println(CalcMaxPurchasedItems(budget,itemPrices3));
		
		budget = 10;
		int itemPrices4[] = { 2, 3, 5, 5 };
		System.out.println(CalcMaxPurchasedItems(budget,itemPrices4));
		
		budget = 1610;
		int itemPrices5[] = { 327, 422, 241, 634, 712, 308, 551 };
		System.out.println(CalcMaxPurchasedItems(budget,itemPrices5));
		
		
	}
	
}
