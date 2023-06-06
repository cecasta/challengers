package com.challenger.budget;

import java.util.HashMap;
import java.util.Map;

public class Calories {

	public static void main(String[] args) {
		Calories obj = new Calories();
		 //double[] price = {327,422,241,634,712,308,551};
		 //int[] calories = {7630,9495,6025,12680,14240,6160,13224};
		 double[] price = {1.25,1.0,0.75};
		 int[] calories = {100,70,80};
		 double budget = 1.70;
		 Map<Double,Integer> map = new HashMap<>();
		System.out.println(obj.findMaxCal(price, calories, budget, map));

	}

	
	public int findMaxCal(double[] price, int[] cals, double budget, Map<Double,Integer> m){
		int maxCal = 0;
		//if already calculated return
		if(m.containsKey(budget)){
			return m.get(budget);
		}
		for(int i=0; i<price.length; i++){
			if(budget-price[i]>=0){				
				maxCal = Math.max(maxCal, findMaxCal(price, cals, budget-price[i], m)+cals[i]);
			}
		}	
		m.put(budget, maxCal);
		return maxCal;
	}
}
