package org.example.bj2295;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    private static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        int[] numberArray = new int[numberCount];
        TreeSet<Integer> sumTreeSet = new TreeSet<>();

        // 1. 입력을 받아 배열에 저장한다.
        for (int i=0; i<numberCount; i++) {
            numberArray[i] = Integer.parseInt(br.readLine());
        }

        // 2. 배열을 오름차순으로 정렬한다.
        Arrays.sort(numberArray);

        // 3. 가능한 모든 두 수의 합을 오름차순으로 정렬하도록 TreeSet에 저장한다.
        for (int j=0; j<numberCount; j++) {
            for(int k=0; k<numberCount; k++) {
                sumTreeSet.add(numberArray[j] + numberArray[k]);
            }
        }

        // 4. 수를 저장한 배열의 가장 큰 수부터 해당 수에 대하여
        //    가장 작은 수부터 차감한 수가 두 수의 합 TreeSet에 있는지 확인하여 -> 있으면 그 큰 수가 세수의 합중 가장 큰 값으로 출력
        for (int l=numberCount-1; l>0; l--) {
            for(int m=0; m<=l; m++) {
                if (sumTreeSet.contains(numberArray[l] - numberArray[m])) {
                    if (numberArray[l] > result) {
                        result = numberArray[l];
                    }
                }
            }
        }
        System.out.print(result);
    }
}
