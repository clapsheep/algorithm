package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10819_차이를최대로 {
	static int N, max;
	static int[] arr, temp;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		max = -10000;
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if (cnt == N) {
			int res = 0;
			for (int i = 1; i < N; i++) {
				res += Math.abs(temp[i - 1] - temp[i]);
			}
			max = Math.max(res, max);
			return;
		}
		for (int j = 0; j < N; j++) {
			if (v[j])
				continue;
			v[j] = true;
			temp[cnt] = arr[j];
			dfs(cnt + 1);
			temp[cnt] = 0;
			v[j] = false;
		}

	}

}
