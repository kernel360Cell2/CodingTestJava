package org.example.bj16713;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {

    private static int[] initialInputArray;
    private static int[] numberInputArray;
    private static int[] indexArray;

    private static int[] getSubQueryResult() {
        int[] subQueryArray = new int[numberInputArray.length + 1];
        subQueryArray[0] = 0;

        for(int i=1; i<=numberInputArray.length; i++) {
           subQueryArray[i] = subQueryArray[i-1] ^ numberInputArray[i-1];
        }
        return subQueryArray;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        numberInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        int[] subQuery = getSubQueryResult();
        for (int i=0; i<initialInputArray[1]; i++) {
            indexArray = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            result ^= subQuery[indexArray[1]] ^ subQuery[indexArray[0] - 1] ;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
