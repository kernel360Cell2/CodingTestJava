import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(st.nextToken());
		int[] numbers = new int[count];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int[] cloneNumbers = numbers.clone();
		Arrays.sort(cloneNumbers);

		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int n : cloneNumbers) {
			if (!map.containsKey(n)) {
				map.put(n, i++);
			}
		}


		for (int n : numbers)
			sb.append(map.get(n)).append(' ');

		System.out.println(sb.toString());


		br.close();
	}
}
