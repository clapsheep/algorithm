import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3234준환이의양팔저울 {
	static int T, N, M, count;
	static int[] W;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			M = N / 2;
			v = new boolean[N];
			W = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			}

			count = 0;
			ncr(0, 0);

		}

	}

	private static void ncr(int cnt, int start) {
		if (cnt == M) {

			if (check(v))
				count++;
			return;
		}
		for (int i = start; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			ncr(cnt + 1, i);
			v[i] = false;
		}
	}

	private static boolean check(boolean[] vis) {
		Queue<Integer> R = new LinkedList<>();
		Queue<Integer> L = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (vis[i]) {
				R.offer(W[i]);
			} else {
				L.offer(W[i]);
			}
		}
		return false;
	}

}
