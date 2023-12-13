import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> sellBookLog = new HashMap<>();
		int max = 0;

		int totalBook = Integer.parseInt(st.nextToken());
		for (int i = 0; i < totalBook; i++) {
			st = new StringTokenizer(br.readLine());
			String sellBook = st.nextToken();
			if (sellBookLog.containsKey(sellBook)) {
				sellBookLog.put(sellBook, sellBookLog.get(sellBook) + 1);
			} else {
				sellBookLog.put(sellBook, 1);
			}
			if (sellBookLog.get(sellBook) > max) {
				max = sellBookLog.get(sellBook);
			}
		}

		List<String> keySet = new ArrayList<>(sellBookLog.keySet());
		Collections.sort(keySet);

		for (String key : keySet) {
			if (sellBookLog.get(key) == max) {
				System.out.println(key);
				break;
			}
		}

		br.close();
	}
}
