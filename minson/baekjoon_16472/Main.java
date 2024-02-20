package stonehee.baekjoon.minson.baekjoon_16472;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");

        int start=0;
        int end=0;
        int max=0;
        if(n>=str.length) {
            System.out.println(str.length);
            return;
        }
        Map<String,Integer> map = new HashMap<>();
        int preS = start;

        while(start <= end && end < str.length) {
            if((start != end || end == 0) && preS == start) {
                map.put(str[end], map.getOrDefault(str[end], 0) + 1);
            }

            if(map.size() <= n) {
                max = Math.max(max, end-start+1);
                end++;
                preS = start;
            } else {
                int num = map.get(str[start]) - 1;
                if(num == 0) {
                    map.remove(str[start]);
                } else {
                    map.put(str[start], num);
                }
                start++;
            }
        }
        System.out.println(max);
    }
}
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//
//        String catTalk = st.nextToken();
//        String[] catTalkCharList = catTalk.split("");
//        String[] Alphabet = new String[N];
//
//        int length = 0;
//        int max = 0;
//        for (int i = 0; i < catTalkCharList.length; i++) {
//            if (catTalkCharList[i].equals(Alphabet[])) {
//                length++;
//            } else {
//                Alphabet[0] = Alphabet[1];
//                Alphabet[1] = catTalkCharList[i];
//                max = Integer.max(max, length);
//            }
//        }
//
//        br.close();
//    }
//
//}
