package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10431_줄세우기 {
	static int N = 20;
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append(t).append(" ");
			int x = Integer.parseInt(st.nextToken());
			int[] s = new int[N];
			int cnt = 0;
			for (int n = 0; n < N; n++) {
				s[n] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if(s[j]>s[i]) cnt++;
				}
			}
			sb.append(cnt);
			System.out.println(sb);
		}
	}
}
