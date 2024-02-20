package org.example.bj1158;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int K;
    private static int removalIndex;
    private static int cursor = 0;
    private static int[] initialInputArray;
    private static ArrayList<Integer> sequence;

    public static ArrayList<Integer> permutations(int N) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initialInputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        K = initialInputArray[1];
        sequence = permutations(initialInputArray[0]);
        System.out.print("<");
        for(int i=sequence.size(); i>1; i--) {
            removalIndex = ((K % i) + cursor - 1) % i;
            if (removalIndex < 0) {
                removalIndex += i;
            }
            System.out.print(sequence.get(removalIndex)+", ");
            sequence.remove(removalIndex);
            cursor = removalIndex;
        }
        System.out.println(sequence.get(0)+">");
    }
}
