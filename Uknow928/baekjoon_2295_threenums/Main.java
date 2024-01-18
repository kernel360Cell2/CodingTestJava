package baekjoon_2295_threenums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        List<Integer> sumList= new ArrayList<>();
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N; j++){
                sumList.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(sumList);

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (Collections.binarySearch(sumList, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

}
