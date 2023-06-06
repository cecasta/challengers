package com.challenger.budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;

import com.challenger.budget.TransporterInc.Container;

import java.util.LinkedHashMap;
import java.util.Iterator;

/*
 * Java Optimization Algorithm
 * Assume now James have 900 bucks and there are 4 items in a shop in different price.
 * ref: https://stackoverflow.com/questions/58343689/java-optimization-algorithm
 */
public class Refact2OptimizationBuyBudget {

	static ResultadoContenedor resultado;
	static Integer ultimoValorestaBalance;

	public static class Container {
		public String name;
		public double transportCost;
		public double containerPrice;

		public Container(String name, double containerPrice, double transportCost) {
			this.name = name;
			this.transportCost = transportCost;
			this.containerPrice = containerPrice;
		}
	}

	public static class ResultadoContenedor {
		public ArrayList<Container> containers;
		public Integer restantantePresupuesto;

		public ResultadoContenedor() {
		}

		public ResultadoContenedor(ArrayList<Container> container, Integer restantantePresupuesto) {
			this.containers = container;
			this.restantantePresupuesto = restantantePresupuesto;

		}
	}

	static void handleAllSumPossibilities(ArrayList<Container> itemList, int balance,
			ArrayList<Container> combination) {

		int sum = 0;
		Integer remain = null;

		for (Container container : combination) {
			sum += container.transportCost;
		}

		if (sum <= balance && sum != 0) {
			remain = (balance - sum);

			if (ultimoValorestaBalance == null || ultimoValorestaBalance >= remain) {

				if (ultimoValorestaBalance != null && ultimoValorestaBalance == remain) {
					resultado = combination.size() > resultado.containers.size()
							? new ResultadoContenedor(combination, remain)
							: resultado;
				} else {
					resultado = new ResultadoContenedor(combination, remain);
				}

				ultimoValorestaBalance = remain;

			}
		}

		for (int i = 0; i < itemList.size(); i++) {
			ArrayList<Container> remainingItems = new ArrayList<Container>();
			Container pointingItem = itemList.get(i);
			for (int j = i + 1; j < itemList.size(); j++) {
				Container itemC = itemList.get(j);
				remainingItems.add(itemC);
			}

			ArrayList<Container> combinationRecord = new ArrayList<Container>(combination);

			combinationRecord.add(pointingItem);

			handleAllSumPossibilities(remainingItems, balance, combinationRecord);

		}
	}

	public static void main(String args[]) {
		ArrayList<Container> data = new ArrayList<Container>();
		data.add(new Container("C1", 7630, 327));
		data.add(new Container("C2", 9495, 422));
		data.add(new Container("C3", 6025, 241));
		data.add(new Container("C4", 12680, 634));
		data.add(new Container("C5", 14240, 712));
		data.add(new Container("C6", 6160, 308));
		data.add(new Container("C7", 13224, 551));
		//data.add(new Container("C8", 13224, 1608));

		int balance = 1610;
		handleAllSumPossibilities(data, balance, new ArrayList<Container>());
		if(resultado != null)
			resultado.containers.forEach(c -> System.out.print(c.name + " "));

		// System.out.println(ultimoValorestaBalance);
		// System.out.println(result.combinacionCostoTransporte.toString());
		// System.out.println(resultado.combinacionCostoTransporte.toString());

	}
}