package HyunJun.character.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class baekjoon19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputData = getData(br);
        int paradizeSize = inputData.get(0);
        int assistantCount = inputData.get(1);
        List<Integer> paradizeStatus = getData(br);

        for (int i = 0; i < assistantCount; i++) {
            List<Integer> instruction = getData(br);
            IntStream.range(instruction.get(0)-1, instruction.get(1))
                    .forEach(n -> {
                        int temp = paradizeStatus.get(n) + instruction.get(2);
                        paradizeStatus.add(n, temp);
                    });

        }
        paradizeStatus.forEach(n -> System.out.print(n + " "));

    }

    private static List<Integer> getData(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


    }
}