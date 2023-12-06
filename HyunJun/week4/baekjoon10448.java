package HyunJun.character.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


//https://www.acmicpc.net/problem/10448
public class baekjoon10448 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = br.read();

        int[] triNumbers = createTriNumbersArray(45);
        HashSet<Integer> sumSet = createSumHashSet(triNumbers);

        for (int i = 0; i < cnt; i++) {
            System.out.println(isExpressAsTriNumber(br.read(), sumSet) ? 1 : 0);
        }
    }

    private static boolean isExpressAsTriNumber(int target, HashSet<Integer> sumSet) {
        for (int triNumber : sumSet) {
            if (sumSet.contains(target - triNumber)) {
                return true;
            }
        }
        return false;
    }
    private static int[] createTriNumbersArray(int limit) {
        int[] triangularNumbers = new int[limit];
        for (int n = 1; n <= limit; n++) {
            triangularNumbers[n - 1] = (n * (n + 1)) / 2;
        }
        return triangularNumbers;
    }

    private static HashSet<Integer> createSumHashSet(int[] numbers) {
        HashSet<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        return sumSet;
    }


}
