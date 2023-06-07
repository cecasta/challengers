package com.challenger.budget.hackerang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieCollection {
    public static int findMinimumDays(List<Float> durations) {
        int n = durations.size();
        Collections.sort(durations); 
        
        int days = 0;
        int i = 0;
        while (i < n) {
            float remainingTime = 3.0f; 
            while (i < n && remainingTime >= durations.get(i)) {
                remainingTime -= durations.get(i);
                i++;
            }
            days++;
        }
        
        return days;
    }
    
    public static void main(String[] args) {
        List<Float> durations = new ArrayList<>();
        durations.add(1.01f);
        
        1.01, 1.01, 1.01, 1.4, 2.4
        int minimumDays = findMinimumDays(durations);
        System.out.println("Minimum number of days: " + minimumDays);
    }
}

