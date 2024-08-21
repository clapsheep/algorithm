package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj11866_요세푸스문제0 {
	static int[] q;
	static int front = 0, rear = 0;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<Integer> q = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			q.add(i + 1);
		}

		int index = 0;
		while (q.size() != 0) {
			index = (index + K - 1) % q.size();
			sb.append(q.remove(index));
			if(q.size()==0) {
				sb.append(">");
			}else {
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}

}
