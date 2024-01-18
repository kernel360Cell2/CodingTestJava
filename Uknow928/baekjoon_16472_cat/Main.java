package baekjoon_16472_cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int max = 0;
        List<Character> charList = new ArrayList<>();
        charList.add(str.charAt(0));

        int i =0;
        int j =0;

        while (true) {
            if (charList.stream().distinct().count() < N) {
                if (j == str.length() - 1) {
                    max = Math.max(max, j-i+1);
                    break;
                }

                charList.add(str.charAt(++j));
//                System.out.println(charList);
            } else {
                if (j < str.length() - 1 && charList.contains(str.charAt(j+1))) {
                    charList.add(str.charAt(++j));
                    continue;
                }
                if (charList.stream().distinct().count() == N) {
                    max = Math.max(max, j-i+1);
                }
                if (i == j) {
                    break;
                }
                charList.remove(0);
                i++;
//                charList.remove(Character.valueOf(str.charAt(i++)));
//                System.out.println(charList);

            }
        }

        System.out.println(max);

    }

}
