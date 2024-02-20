package stonehee.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NyanCat {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(findMaxLength(str, N));
    }

    private static int findMaxLength(String str, int N) {
        Map<Character, Integer> charCount = new HashMap<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < str.length(); end++) {
            charCount.put(str.charAt(end), charCount.getOrDefault(str.charAt(end), 0) + 1);

            while (charCount.size() > N) {
                char startChar = str.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

}
