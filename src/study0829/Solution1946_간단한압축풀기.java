package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1946_간단한압축풀기 {
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			List<String> str = new ArrayList<>();
			for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				String word = st.nextToken();
				int repeat = Integer.parseInt(st.nextToken());
				for (int i = 0; i < repeat; i++) {
					str.add(word);
				}
			}
			String res = "";
			for (int i = 1; i <= str.size(); i++) {
				res += str.get(i-1);
				if(i%10 == 0) {
					res += "\n";
				}
			}
			System.out.println("#"+t);
			System.out.println(res);
			
			
		}

	}

}
