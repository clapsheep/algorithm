package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

	// DP로 풀어야하는 문제라 아직 모름
public class bj14501_퇴사_DP {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) + 1;
		int[] T = new int[N];
		int[] P = new int[N];
		int max = 0;
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			int sum = 0;
			int time = 0;
			int pay = 0;
			for (int j = 1; j < N; j++) {
				if (time == 0) {
					time = T[j];
					pay = P[j];
				}
				time--;
				if (time == 0) {
					sum += pay;
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
