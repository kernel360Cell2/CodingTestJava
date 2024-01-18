package HyunJun.character.week9;

import java.io.*;
import java.util.Arrays;

public class baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = toIntArray(br.readLine());
        int cnt = array[0];
        int mx = array[1];
        int[] numlist = toIntArray(br.readLine());

        System.out.println(findSmallestLength(cnt, numlist, mx));


    }

    private static int findSmallestLength(int cnt, int[] numlist, int mx) {
//        for (int step = 1; step < cnt; step++) {
//            for(int j = 0; j < cnt -step ; j+=step){
//                int sum = IntStream.rangeClosed(j,j+step)
//                        .map(n -> numlist[n])
//                        .sum();
//
//                if (sum >= mx)
//                    return step + 1;
//            }
//        }
//        return 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < cnt; end++) {
            sum += numlist[end];

            while (sum >= mx) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= numlist[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int[] toIntArray(String input) {
        return
                Arrays.stream(input.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray();
    }


}


