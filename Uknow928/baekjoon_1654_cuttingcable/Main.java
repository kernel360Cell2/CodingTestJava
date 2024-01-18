package baekjoon_1654_cuttingcable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 틀림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long a = 1;
        long b = Arrays.stream(arr).max().getAsInt();
        long mid;

        while (a < b) {
            mid = (a+b)/2;
            long finalMid = mid;
            long count = Arrays.stream(arr).mapToLong(x -> x/ finalMid).sum();
            if (count >= N) {
                a = mid + 1;
            } else {
                b = mid;
            }
        }
        System.out.println(a-1);

    }

}
