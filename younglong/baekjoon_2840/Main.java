package baekjoon_2840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] wheel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] pieceArr = new String[wheel[0]];
        Arrays.fill(pieceArr, "?");

        int currentPos = wheel[0] - 1;
        String[] firstTurn = br.readLine().split(" ");
        pieceArr[currentPos] = firstTurn[1];

        for (int i = 1; i < wheel[1]; i++) {
            String[] turn = br.readLine().split(" ");

            int cycleCnt = Integer.parseInt(turn[0]);

            currentPos -= cycleCnt;
            if(currentPos < 0) currentPos += wheel[0];

            if (!pieceArr[currentPos].equals("?") && !pieceArr[currentPos].equals(turn[1])) {
                System.out.println("!");
                return;
            }

            pieceArr[currentPos] = turn[1];
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder mvTarget = new StringBuilder();

        for (int i = 0; i < wheel[0]; i++) {
            if (i < currentPos) {
                mvTarget.append(pieceArr[i]);
                continue;
            }
            sb.append(pieceArr[i]);
        }
        sb.append(mvTarget);
        System.out.println(sb);
    }
}