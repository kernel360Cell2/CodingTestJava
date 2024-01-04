package org.example.bj16472;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxAlphabet = Integer.parseInt(br.readLine());
        char[] stringLine = br.readLine().toCharArray();

        // 알파벳 종류 수
        int[] count = new int[26];

        int start = 0;
        int end = 0;

        // 탐색중 발견된 가장 긴 부분 문자열
        int maxLen = 0;

        // 현재 유니크한 알파벳 개수
        int curAlphabet = 0;

        while (end < stringLine.length) {
            // 새롭게 추가된 철자(char)가 색인이 되어있지 않다면
            if (count[stringLine[end] - 'a'] == 0) {
                curAlphabet++;
            }

            // 알파벳 종류에 색인을 추가
            count[stringLine[end] - 'a']++;

            // 현재 유니크한 알파벳 개수가 최대 개수를 초과한다면
            // 시작 지점의 알파벳을 색인에서 제거
            while (curAlphabet > maxAlphabet) {
                count[stringLine[start] - 'a']--;

                if (count[stringLine[start] - 'a'] == 0) {
                    curAlphabet--;
                }

                start++;
            }

            // 현재 포인터 간의 거리와 메모리에 저장된 가장 긴 길이를 비교하여 업데이트함
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        bw.write(String.valueOf(maxLen));
        bw.flush();

        br.close();
        bw.close();
    }
}