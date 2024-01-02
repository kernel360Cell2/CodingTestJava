package org.example.bj1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] lanLines;
    private static int[] initialInputArray;

    // LAN선의 목표 개수
    private static int goalNumber;
    private static int upperBound = 1;
    private static int lowerBound = 1;

    // 현재 LAN선을 자르는 길이
    private static int currentNumber = 1;
    private static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initialInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        goalNumber = initialInputArray[1];

        lanLines = new int[initialInputArray[0]];
        for (int i=0; i<initialInputArray[0]; i++) {
            lanLines[i] = Integer.parseInt(br.readLine());
            if (lanLines[i] > upperBound) {
                upperBound = lanLines[i];
            }
        }

        currentNumber = upperBound / 2;
        while (lowerBound - upperBound >= 0) {
            int sum = 0;
            for(int i = 0; i < lanLines.length; i++) {
                sum += (lanLines[i] / currentNumber);
                if(sum > goalNumber)
                    break;
            }

            if(sum >= goalNumber) {
                lowerBound = currentNumber + 1;
                result = currentNumber;
            } else {
                upperBound = currentNumber - 1;
            }

            currentNumber = (upperBound + lowerBound) / 2;
        }
        System.out.println(result);
    }
}
