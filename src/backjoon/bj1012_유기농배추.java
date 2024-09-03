package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1012_유기농배추 {
	static int T, M, N, K, mark;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			
			mark = 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						mark++;
					}
				}
			}
			
			System.out.println(mark-2);
			
			
		}

	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		map[sr][sc] = mark;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 1) {
					q.offer(new int[] { nr, nc });
					map[nr][nc]=mark;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
