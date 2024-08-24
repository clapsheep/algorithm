package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15658_연산자끼워넣기2 {
	static int N, n, r;
	static int[] nums;
	static List<Character> signs;

	static boolean[] v;
	static char[] s;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		r = N - 1;
		s = new char[r];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		signs = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int sign = Integer.parseInt(st.nextToken());
			for (int j = 0; j < sign; j++) {
				if (i == 0)
					signs.add('+');
				else if (i == 1)
					signs.add('-');
				else if (i == 2)
					signs.add('*');
				else
					signs.add('/');
			}
		}
		n = signs.size();
		v = new boolean[n];
		dfs(0);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);

	}

	static void dfs(int cnt) {
		if (cnt == r) {
			int res = calc(s);
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		char prev = '!';
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			if (prev != signs.get(i)) {
				v[i] = true;
				s[cnt] = signs.get(i);
				prev = signs.get(i);
				dfs(cnt + 1);
				s[cnt] = 0;
				v[i] = false;
			}
		}

	}

	static int calc(char[] sign) {
		int res = nums[0];
		for (int i = 0; i < r; i++) {
			switch (sign[i]) {
			case '+':
				res += nums[i + 1];
				break;
			case '-':
				res -= nums[i + 1];
				break;
			case '*':
				res *= nums[i + 1];
				break;
			case '/':
				res /= nums[i + 1];
				break;

			}
		}
		return res;
	}

}
