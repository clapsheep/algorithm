package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		N = Integer.parseInt(br.readLine());
		while (N != 0) {
			map = new int[N][N];
			sb.append("Problem ").append(t++).append(": ");
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = bfs();
			sb.append(res).append("\n");
			N = Integer.parseInt(br.readLine());

		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[][] v = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE);
		}

		q.offer(new int[] { 0, 0, map[0][0] });
		v[0][0] = map[0][0];
		int mean = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			if (r == N - 1 && c == N - 1) {
				mean = Math.min(mean, cost);
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (cost + map[nr][nc] < v[nr][nc]) {
					v[nr][nc] = cost + map[nr][nc];
					q.offer(new int[] { nr, nc, cost + map[nr][nc] });
				}
			}

		}

		return mean;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
