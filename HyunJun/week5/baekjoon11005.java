package HyunJun.character.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/11005
public class baekjoon11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = toIntArray(br.readLine());
        int target = arr[0];  // 타겟 10진법 수
        final int radix = arr[1]; // 진법

        StringBuilder str = new StringBuilder();

        while ( target > 0){
            int remainder = target % radix;
            if (remainder < 10)
                str.append(remainder);
            else {
                char ch = (char) ( remainder + 55 );
                str.append(ch);
            }
            target = target / radix;
        }

        System.out.println(str.reverse());

    }


    public static int[] toIntArray(String input) {
        return
                Arrays.stream(input.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
    }
}
