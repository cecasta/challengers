package com.challenger.budget;

import java.util.ArrayList;
import java.util.Arrays;

import com.challenger.budget.CombinationExample2.Item;

/*
 * challenger: algorithm-or-solution-for-selecting-possible-combinations-of-menu-items-within-a
 * ref: https://stackoverflow.com/questions/68606334/algorithm-or-solution-for-selecting-possible-combinations-of-menu-items-within-a
 * output: budget 550
 * Solution 1: [Fruit, Salad]
	Solution 2: [Fries, Fries]
 */
public class CombinationExample2
{
    private ArrayList<Item> menu;
    private ArrayList<String[]> solutions;

    public static class Item
    {
        public String name;
        public int price;

        public Item(String name, int price)
        {
            this.name = name;
            this.price = price;
        }
    }

    public CombinationExample2(ArrayList<Item> menu)
    {
        this.menu = menu;
    }

    public ArrayList<String[]> solve(int budget)
    {
        solutions = new ArrayList<String[]>();
        solve(new ArrayList<Item>(), 0, budget);
        return solutions;
    }

    private void solve(ArrayList<Item> items, int first, int budget)
    {
        if(budget==0)
        {
            // We have found a solution, store it
            solutions.add(items.stream().map(e -> e.name).toArray(String[]::new));
        }
        else
        {
            // Search for an item that fits in the budget
            for(int i=first;i<menu.size();i++)
            {
                Item item = menu.get(i);
                if(item.price<=budget)
                {
                    items.add(item);
                    solve(items, i, budget-item.price);
                    items.remove(items.size()-1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Item> menu = new ArrayList<Item>();
        menu.add(new Item("Fruit", 215));
        menu.add(new Item("Fries", 275));
        menu.add(new Item("Salad", 335));
        menu.add(new Item("Wings", 355));
        menu.add(new Item("Mozzarella", 420));
        menu.add(new Item("Plate", 580));

        CombinationExample2 solver = new CombinationExample2(menu);
        ArrayList<String[]> solutions = solver.solve(550);
        for(int i=0;i<solutions.size();i++)
            System.out.println("Solution "+(i+1)+": "+Arrays.toString(solutions.get(i)));
    }
}