package com.challenger.budget.hackerang;

import java.util.List;

public class ComplianceCrawler {
    public static int minimumSteps(List<String> loggedMoves) {
        int level = 0;
        for (String move : loggedMoves) {
            if (move.equals("../")) {
                level -= 1;
            } else if (move.startsWith("/") || move.startsWith("./")) {
                continue;
            } else {
                level += 1;
            }
        }
        return Math.abs(level);
    }

    public static void main(String[] args) {
        List<String> loggedMoves = List.of("x/", "y/", "../", "z/", "./");
        System.out.println(minimumSteps(loggedMoves));  // Output: 2
    }
}
