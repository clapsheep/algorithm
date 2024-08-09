package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj1360 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Stack<String> str = new Stack<>();
		String[] s = new String[N];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			String word = st.nextToken();
			int idx = Integer.parseInt(st.nextToken());
			
			switch (action) {
			case "type":
				break;
			case "undo":
				break;
			}
		}

	}

}
