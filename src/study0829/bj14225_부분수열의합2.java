package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14225_부분수열의합2 {
	static int N, S;
	static int[] p;
	static int max = 2; // 최악의 경우 모든 원소의 합을 더하는 경우까지 부분수열의 합으로 자연수를 다 만들 수 있을 경우 자연수 출력 index는 max+2
	static boolean[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			max += p[i];
		}
		res = new boolean[max];
		subSet(0, 0);
		
		for (int i = 0; i < max; i++) {
			if (!res[i]) {
				System.out.println(i);
				break;
			}
		}

	}

	private static void subSet(int cnt, int sum) {
		if (cnt == N) {
			res[sum] = true;
			return;

		}
		subSet(cnt + 1, sum + p[cnt]);
		subSet(cnt + 1, sum);
	}
}
