package HyunJun.character.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class baekjoon1302 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = br.read();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count ; i++) {
            String book = br.readLine();
            if( !map.containsKey(book))
                map.put(book, 1);
            else
                map.put(book,map.get(book) + 1);
        }

        Optional<Map.Entry<String, Integer>> first = map.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                .findFirst();

        first.ifPresent(System.out::print);

    }

}
