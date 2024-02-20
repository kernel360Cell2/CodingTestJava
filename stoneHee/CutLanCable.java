package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;

public class CutLanCable {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] lanCables = br.readLine().split(" ");
        int alreadyHaveCableCount = Integer.parseInt(lanCables[0]);
        int needCableCount = Integer.parseInt(lanCables[1]);

        int[] lanLengths = new int[alreadyHaveCableCount];
        for (int i = 0; i < alreadyHaveCableCount; i++) {
            lanLengths[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(findMaxLength(lanLengths, needCableCount));
    }

    private static int findMaxLength(int[] lanLengths, int needCableCount) {
        long min = 1;
        long max = getMaxLength(lanLengths);

        while(min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int lanLength : lanLengths) {
                cnt += lanLength / mid;
            }

            if(cnt < needCableCount) max = mid;
            else min = mid + 1;
        }

        return (int) (min - 1);
    }

    private static int getMaxLength(int[] lanLengths) {
        int max = 0;
        for (int lanLength : lanLengths) {
            max = Math.max(max, lanLength);
        }
        return max;
    }

}
