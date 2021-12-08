package com.company;

import java.io.*;

public class Day6 {

    public static void main(String[] args) throws IOException {
        FileInputStream fstream = new FileInputStream("textfile.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        long[] arr = new long[9];

        while ((strLine = br.readLine()) != null) {
            // parse
            for (String str : strLine.split(",")) {
                arr[Integer.parseInt(str)]++;
            }
        }

        int MAX_DAYS = 256;
        int LAST_DAY = 0;

        for(int i=0;i<MAX_DAYS;i++) {
            long dying = arr[LAST_DAY];
            rotate(arr);
            arr[6] += dying;
        }

        System.out.println(sum(arr));

    }

    private static long sum(long[] arr) {
        long sum = 0;
        for(long n : arr) {
            sum += n;
        }

        return sum;
    }

    private static void rotate(long[] arr) {
        long temp = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            arr[i] = arr[i + 1];
        }

        arr[8] = temp;
    }

}
