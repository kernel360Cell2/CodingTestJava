package HyunJun.character.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class baekjoon16713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputData = getData(br);

        int sequenceCount = inputData.get(0);
        int queryCount = inputData.get(1);

        List<Integer> sequence = getData(br);
        int finalResult = 0;
        for (int i = 0; i < queryCount; i++) {
            List<Integer> query = getData(br);
            int queryStart = query.get(0);
            int queryEnd = query.get(1);

            finalResult ^= IntStream.range(queryStart - 1, queryEnd)
                    .map(sequence::get)
                    .reduce(0, (x, y) -> x ^ y);
        }

        System.out.println("result = " + finalResult);
    }

    private static List<Integer> getData(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toList();
    }
}