package com.challenger.budget;

import java.util.ArrayList;

import com.challenger.budget.CombinationExample2.Item;
import com.challenger.budget.TransporterInc.Container;

public class TransporterInc {

	private ArrayList<Container> containers;
	private ArrayList<String> solutions;
	private double sumTotal;
	private double budgetOri;
	
    public static class Container
    {
        public String name;
        public double transportCost;
        public double containerPrice;

        public Container(String name, double containerPrice, double transportCost)
        {
            this.name = name;
            this.transportCost = transportCost;
            this.containerPrice = containerPrice;
        }
    }
    
    
    
    public ArrayList<String> selectContainers(double budget, ArrayList<Container> data){
    	
        solutions = new ArrayList<String>();
        this.containers = data;
        this.budgetOri = budget;
        solve(new ArrayList<Container>(), 0, budget);
        return solutions;
    }
    
    
    private void solve(ArrayList<Container> items, int first, double budget)
    {
        if(sumTotal<=budgetOri)
        {
            // We have found a solution, store it
            solutions.add(items.stream().map(e -> e.name).toString());
        }
        else
        {
            // Search for an item that fits in the budget
            for(int i=first;i<containers.size();i++)
            {
            	Container item = containers.get(i);
                if(item.transportCost<=budget)
                {
                	sumTotal+=item.transportCost;
                    items.add(item);
                    solve(items, i, budget-item.transportCost);
                    items.remove(items.size()-1);
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
    	TransporterInc obj = new TransporterInc();
    	ArrayList<Container> data = new ArrayList<Container>();
    	data.add(new Container("C1", 7630, 327));
    	data.add(new Container("C2", 9495, 422));
    	data.add(new Container("C3", 6025, 241));
    	data.add(new Container("C4", 12680, 634));
    	data.add(new Container("C5", 14240, 712));
    	data.add(new Container("C6", 6160, 308));
    	data.add(new Container("C7", 13224, 551));
    	
    	ArrayList<String> result =obj.selectContainers(1610, data);
        
        for(int i=0;i<result.size();i++)
        	System.out.println(result.get(i));
    }
	
}
