package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9019_DSLR {
	static int A, B, T;
	static boolean[] v;
	static String[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			v = new boolean[10000];
			ans = new String[10000];
			Arrays.fill(ans, "");
			bfs(A);
			System.out.println(ans[B]);
		}
	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		v[n] = true;
		while (!q.isEmpty() && !v[B]) {
			int cur = q.poll();
			int d = D(cur);
			int s = S(cur);
			int l = L(cur);
			int r = R(cur);

			if (!v[d]) {
				v[d] = true;
				q.offer(d);
				ans[d] = ans[cur] + "D";
			}
			if (!v[s]) {
				v[s] = true;
				q.offer(s);
				ans[s] = ans[cur] + "S";
			}
			if (!v[l]) {
				v[l] = true;
				q.offer(l);
				ans[l] = ans[cur] + "L";
			}
			if (!v[r]) {
				v[r] = true;
				q.offer(r);
				ans[r] = ans[cur] + "R";
			}
		}

	}

	private static int R(int num) {
		int il = (num - num / 10 * 10) * 1000;
		return num / 10 + il;
	}

	private static int L(int num) {
		return (num - num / 1000 * 1000) * 10 + num / 1000;
	}

	private static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}

	private static int D(int num) {
		return (2 * num) % 10000;
	}

}
