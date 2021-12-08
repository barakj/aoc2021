package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day7 {

    public static void main(String[] args) throws IOException {
        FileInputStream fstream = new FileInputStream("textfile.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        List<Integer> input = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while ((strLine = br.readLine()) != null) {
            // parse
            for (String str : strLine.split(",")) {
                int num = Integer.parseInt(str);
                max = Math.max(num, max);
                input.add(num);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i=1;i<=max;i++) {
            int cost = getCost(i, input);
            minCost = Math.min(minCost, cost);
        }

        System.out.println(minCost);
    }

    // Get from every number in input list to number v.
    private static int getCost(int v, List<Integer> input) {
        int sum = 0;
        for (int n : input) {
            int min = Math.min(v, n);
            int max = Math.max(v, n);
            sum += (((max - min) * (max - min + 1)) / 2);
        }

        return sum;
    }
}
