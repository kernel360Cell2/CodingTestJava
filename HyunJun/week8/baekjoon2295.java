package HyunJun.character.week8;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class baekjoon2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int cnt = Integer.parseInt(bufferedReader.readLine());

        List<Integer> inputData = new ArrayList<>(cnt);
        for (int i = 0; i < cnt; i++) {
            inputData.add(i, Integer.parseInt(bufferedReader.readLine()));
        }

        int mx = findCombinationMaxValue(inputData);
        System.out.println(mx);

    }

    public static int findCombinationMaxValue(List<Integer> data){

        Collections.sort(data);
        HashSet<Integer> hashSet = new HashSet<>();
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < data.size() - 2 ; i++) {
            for (int j = 2; j < data.size() ; j++) {
                int sum = data.get(i) + data.get(i+1) + data.get(j);
                if (sum > data.get(data.size()-1)){
                    break;
                }
                mx = Collections.binarySearch(data, sum) >= 0 ? Math.max(sum, mx) : mx;
            }
        }
        return mx;

    }
}
