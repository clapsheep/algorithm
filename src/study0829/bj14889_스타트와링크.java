package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889_스타트와링크 {
	static int N, R;
	static int[][] stat;
	static int[] a, b, nums;
	static boolean[] v;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		v = new boolean[N];
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		R = N / 2;
		a = new int[R];
		b = new int[R];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}

	static void dfs(int cnt, int start) {
		if (cnt == R) {
			int bIndex = 0;
			for (int i = 0; i < N; i++) {
				if(!v[i]) {
					b[bIndex++] = nums[i]; 
				}
			}
			int sumA = calc(a);
			int sumB = calc(b);
			min = Math.min(Math.abs(sumA-sumB), min);		
			return;
		}
		for (int i = start; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			a[cnt] = nums[i];
			dfs(cnt + 1,i);
			a[cnt] = 0;
			v[i] = false;
		}

	}

	static int calc(int[] team) {
		int sum = 0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team.length; j++) {
				if(i==j) continue;
				sum += stat[team[i]-1][team[j]-1];
			}
		}
		return sum;
	}

}
