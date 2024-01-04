package org.example.bj1806;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] initialInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numberArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int tempSum = 0;

        while (end < numberArray.length) {
            tempSum += numberArray[end];

            while (tempSum >= initialInputArray[1]) {
                minLength = Math.min(minLength, end - start + 1);
                tempSum -= numberArray[start];
                start++;
            }

            end++;
        }

        if (minLength == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(minLength));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}