package baekjoon_1806_bubunhap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 시간초과 당함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int i = 0;
        int j = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum < S) {
                if (j == N-1) {
                    break;
                }
                sum += arr[++j];

            } else {
                min = Math.min(min, j-i+1);
                if (i == j) {
                    break;
                }
                sum -= arr[i++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);
    }

}
