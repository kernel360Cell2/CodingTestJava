package baekjoon_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int total = 0;
        int minCnt = Integer.MAX_VALUE;

        while (true) {
            if (total >= S) {
                minCnt = Math.min(minCnt, end - start);
                total -= numbers[start++];
            } else if (end == N) {
                break;
            } else {
                total += numbers[end++];
            }
        }

        if (minCnt == Integer.MAX_VALUE) {
            minCnt = 0;
        }

        System.out.println(minCnt);
    }
}
