package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1764_듣보잡 {
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> name = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			name.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			String input= br.readLine();
			if(name.containsKey(input)) {
				name.put(input,2);
			}
		}
		int cnt= 0;
		List<String> res = new ArrayList<>();
		for (String n : name.keySet()) {
			if(name.get(n)==2) {
				cnt++;
				res.add(n);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		Collections.sort(res);
		for (String n : res) {
			sb.append(n).append("\n");
		}
		System.out.println(sb.toString());

	}

}
