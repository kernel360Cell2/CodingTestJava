package baekjoon_16472;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String strings = br.readLine();

        int maxCnt = Integer.MIN_VALUE;

        for (int i = 0; i < strings.length(); i++) {
            char startChar = strings.charAt(i);
            int count = 1;

            if (i > 0 && startChar == strings.charAt(i - 1)) {
                continue;
            }

            Set<Character> set = new HashSet<>();
            set.add(strings.charAt(i));

            for (int j = i + 1; j < strings.length(); j++) {
                set.add(strings.charAt(j));

                if (set.size() > N) {
                    break;
                }

                count++;
            }

            maxCnt = Math.max(maxCnt, count);
        }

        bw.write(maxCnt + "");
        bw.flush();
        bw.close();
    }
}
