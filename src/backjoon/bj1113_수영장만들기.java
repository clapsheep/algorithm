package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1113_수영장만들기 {
	static int N, M;
	static int[][] map;
	static int[][] level;
	static Queue<int[]>[] q;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		level = new int[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			String input = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = input.charAt(j - 1)-'0';
			}
		}
		q = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			q[i] = new LinkedList<>();
		}
		bfs();
		int res = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				res += (level[i][j] - map[i][j]);
			}
		}
		System.out.println(res);

	}

	private static void bfs() {
		q[1].add(new int[] { 0, 0 });
		boolean v[][] = new boolean[N + 2][M + 2];

		for (int i = 1; i < 10; i++) {
			while (!q[i].isEmpty()) {
				int[] cur = q[i].poll();
				int curR = cur[0];
				int curC = cur[1];
				if (v[curR][curC])
					continue;
				v[curR][curC] = true;
				level[curR][curC] = i;
				for (int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					if (!check(nr, nc) || v[nr][nc])
						continue;
					if (map[nr][nc] <= i) {
						q[i].offer(new int[] { nr, nc });
					} else {
						q[map[nr][nc]].offer(new int[] { nr, nc });
					}
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N + 2 && c < M + 2;
	}

}
