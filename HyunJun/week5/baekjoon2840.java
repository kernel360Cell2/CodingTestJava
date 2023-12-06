package HyunJun.character.week5;

import java.util.Arrays;

//https://www.acmicpc.net/problem/2840
public class baekjoon2840 {
    public static void main(String[] args) {

    }


    public static int[] toIntArray(String input) {
        return
                Arrays.stream(input.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
    }
}
