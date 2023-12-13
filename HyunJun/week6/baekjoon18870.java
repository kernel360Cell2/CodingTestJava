package HyunJun.character.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = br.read();
        int[] intArray = toIntArray(br.readLine());

        Arrays.stream(intArray).parallel()
                .mapToLong(n-> Arrays.stream(intArray).filter(k -> k < n).distinct().count())
                .forEach(n-> System.out.print(n+" "));

    }

    public static int[] toIntArray(String input){
        return
                Arrays.stream(input.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
    }


    }

