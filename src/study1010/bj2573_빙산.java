package study1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2573_빙산 {
	static int N, M;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while (!isDivided()) {
			if(checkAllZero()) {
				System.out.println(0);
				return; 
			}
			time++;
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, temp[i], 0, M);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] != 0) {
						int meltCnt = calcMelt(i, j, temp);
						map[i][j] -= meltCnt;
						map[i][j] = Math.max(map[i][j], 0);
					}
				}
			}
		}
		System.out.println(time);
	}

	private static boolean checkAllZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int calcMelt(int r, int c, int[][] temp) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!outCheck(nr, nc))
				continue;
			if (temp[nr][nc] == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean isDivided() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, M);
		}

		boolean[][] v = new boolean[N][M];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] > 0 && !v[i][j]) {
					bfs(temp, v, i, j, ++cnt);
				}

			}
		}

		return cnt > 2 ? true : false;
	}

	private static void bfs(int[][] temp, boolean[][] visited, int i, int j, int mark) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!outCheck(nr, nc) || visited[nr][nc])
					continue;
				if (temp[nr][nc] != 0) {
					visited[nr][nc] = true;
					temp[nr][nc] = mark;
					q.offer(new int[] { nr, nc });
				}
			}
		}

	}

	private static boolean outCheck(int r, int c) {

		return r >= 0 && c >= 0 && r < N && c < M;
	}

}