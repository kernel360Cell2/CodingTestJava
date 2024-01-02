package baekjoon_1654;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] KN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = KN[0];
        int N = KN[1];

        int[] cables = new int[K];
        long totalLen = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            totalLen += cables[i];
        }

        int maxLength = getMaxLength(cables, N, totalLen / N);

        bw.write(maxLength + "");
        bw.flush();
        bw.close();
    }

    private static int getMaxLength(int[] cables, int targetCount, long startLen) {
        long high = startLen;
        long low = 1;
        long maxLength = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            int count = 0;

            for (int i = 0; i < cables.length; i++) {
                count += cables[i] / mid;
            }

            if (count < targetCount) {
                high = mid - 1;
            } else {
                low = mid + 1;
                maxLength = Math.max(maxLength, mid);
            }

        }

        return (int) maxLength;
    }
}