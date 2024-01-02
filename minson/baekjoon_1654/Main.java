package stonehee.baekjoon.minson.baekjoon_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lanLength = new int[K];
        long max = 0;
        long min = 0;
        long mid;
        for (int i = 0; i < K; i++) {
            lanLength[i] = Integer.parseInt(br.readLine());
            if (max < lanLength[i]) {
                max = lanLength[i];
            }
        }
        max++;
        while (min < max) {
            long count = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < lanLength.length; i++) {
                count += (lanLength[i] / mid);
            }
            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

}
