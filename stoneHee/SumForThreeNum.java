package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SumForThreeNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMaxSum(nums));
    }

    private static int findMaxSum(int[] nums) {
        int[] possibleNumbers = getPossibleNumbers(nums);
        for(int i = nums.length -1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                int targetNum = nums[i] - nums[j];
                if(arrContainsTarget(targetNum,possibleNumbers)) {
                    return nums[i];
                }
            }

        }
        return 0;
    }

    private static int[] getPossibleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] possibleNumbers = new int[nums.length * nums.length];
        int idx = 0;
        for (int i : nums) {
            for (int j : nums) {
                possibleNumbers[idx++] = i + j;
            }
        }
        Arrays.sort(possibleNumbers);
        return possibleNumbers;
    }

    private static boolean arrContainsTarget(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
