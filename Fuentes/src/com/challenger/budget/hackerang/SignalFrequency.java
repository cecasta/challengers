package com.challenger.budget.hackerang;

import java.util.Arrays;
import java.util.List;

public class SignalFrequency {
    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        int maxEqual = 0;
        int updates = 0;
        int minLength = Math.min(signalOne.size(), signalTwo.size());

        for (int i = 0; i < minLength; i++) {
            if (signalOne.get(i).equals(signalTwo.get(i))) {
                if (signalOne.get(i) > maxEqual) {
                    maxEqual = signalOne.get(i);
                    updates++;
                }
            }
        }

        return updates;
    }
    
    
    
    public static void main(String[] args) {
        List<Integer> signalOne = Arrays.asList(1, 2, 3, 4, 1);
        List<Integer> signalTwo = Arrays.asList(5, 4, 3, 4, 1);

        int numUpdates = SignalFrequency.updateTimes(signalOne, signalTwo);
        System.out.println("Number of updates: " + numUpdates);
    }
}

