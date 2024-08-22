package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501_퇴사 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int time = T[i];
			for (int j = 0; j <N; j++) {
				if(time==0) {
					sum+=P[j];
					time = T[j];
				}
				time--;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
