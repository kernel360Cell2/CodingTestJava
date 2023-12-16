package org.example.bj19951;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    private static int[] initialInputArray;
    private static int[] resultArray;
    private static int[] indexArray;

    private static void cumulateNumbers(int start, int end, int updateNum) {
        for (int i=start-1; i<end; i++) {
            resultArray[i] += updateNum;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        resultArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i=0; i<initialInputArray[1]; i++) {
            indexArray = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            cumulateNumbers(indexArray[0], indexArray[1], indexArray[2]);
        }

        for (int j=0; j<resultArray.length; j++) {
            bw.write(resultArray[j] + " ");
        }
        bw.flush();
    }
}
