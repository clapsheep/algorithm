package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14502_연구소 {
	static int N, M, result;
	static int[][] map, temp, sel;
	static boolean[][] vv;
	static List<int[]> virus, land;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		virus = new ArrayList<>();
		land = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
				if (map[i][j] == 0) {
					land.add(new int[] { i, j });
				}
			}
		}

		sel = new int[3][2];
		result = 0;
		ncr(0, 0);
		System.out.println(result);
	}

	private static void ncr(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				map[sel[i][0]][sel[i][1]] = 1;
			}
			bfs(virus);
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						count++;
				}
			}
			result = Math.max(count, result);
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, map[i], 0, M);
			}
			return;
		}
		for (int i = start; i < land.size(); i++) {
			sel[cnt] = land.get(i);
			ncr(cnt + 1, i + 1);
			sel[cnt] = null;

		}

	}

	private static void bfs(List<int[]> virus) {
		vv = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			int[] now = virus.get(i);
			q.offer(new int[] { now[0], now[1] });
			vv[now[0]][now[1]] = true;
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (vv[nr][nc])
					continue;
				if (map[nr][nc] == 0) {
					map[nr][nc] = 2;
					q.offer(new int[] { nr, nc });
					vv[nr][nc] = true;
				}
			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
