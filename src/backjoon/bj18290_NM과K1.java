package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18290_NM과K1 {
	static int N, M, K, max;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = -1000000;
		dfs(0, 0, 0, 0, v);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt, int sum, boolean[][] v) {
		if (cnt == K) {
			max = Math.max(sum, max);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 당사자가 방문한 적 있는지? 당사자주변에 방문한 적 있는지?
				if (canSelect(i, j, v)) {
					v[i][j] = true;
					dfs(i, j, cnt + 1, sum + map[i][j], v);
					v[i][j] = false;
				}
			}
		}

	}

	private static boolean check(int r, int c, boolean[][] v) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && v[nr][nc]) {
				if (v[nr][nc])
					return false;
			} else {
				continue;
			}
		}

		return true;
	}

	private static boolean canSelect(int r, int c, boolean[][] v) {
		if (v[r][c])
			return false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && v[nr][nc]) {
				return false;
			}
		}
		return true;
	}
}
