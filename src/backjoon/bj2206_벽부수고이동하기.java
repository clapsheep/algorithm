package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<int[]> walls;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		walls = new ArrayList<>();
		walls.add(new int[] { 0, 0 });
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j] - '0';
				if (map[i][j] == 1) {
					walls.add(new int[] { i, j });
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int[] w : walls) {
			System.out.println("("+w[0]+","+w[1]+")");
			
		}
		for (int[] pass : walls) {
			int dist = bfs(pass);
			res = Math.min(dist, res);
		}
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);

	}

	private static int bfs(int[] pass) {
		map[pass[0]][pass[1]] = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] { 0, 0 });
		v[0][0] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (cur[0] == N - 1 && cur[1] == M - 1) {
					return cnt;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (v[nr][nc])
						continue;
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc });
						v[nr][nc] = true;
					}
				}
			}
			cnt++;
		}
		if (pass[0] != 0 && pass[1] != 0) {
			map[pass[0]][pass[1]] = 1;
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
