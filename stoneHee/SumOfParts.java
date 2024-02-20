package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfParts {
    public static void main(String[] args) throws IOException {
        int[] inputs = readInput();
        int N = inputs[0];
        int S = inputs[1];
        int[] nums = Arrays.copyOfRange(inputs, 2, inputs.length);

        int minLength = findMinimumLength(nums, N, S);
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }

    private static int[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 2];
        nums[0] = N;
        nums[1] = S;

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < N + 2; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        return nums;
    }

    private static int findMinimumLength(int[] nums, int N, int S) {
        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, end - start);
                sum -= nums[start++];
            } else if (end == N) {
                break;
            } else {
                sum += nums[end++];
            }
        }
        return minLength;
    }
}
