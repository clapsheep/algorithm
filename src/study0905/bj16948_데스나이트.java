package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16948_데스나이트 {
	static int N, r1, c1, r2, c2;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		int res = bfs(r1, c1);
		System.out.println(res);
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		v[r][c] = true;
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (cur[0] == r2 && cur[1] == c2)
					return time;
				for (int d = 0; d < 6; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (v[nr][nc])
						continue;
					q.offer(new int[] { nr, nc });
					v[nr][nc] = true;
				}
			}
			time++;
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
