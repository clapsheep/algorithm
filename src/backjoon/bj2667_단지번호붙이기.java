package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static int g;
	static int[] groups;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		v = new boolean[N][N];
		g = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, ++g);
				}
			}
		}


		groups = new int[g - 2 + 1];

		for (int k = 2; k <= g; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == k)
						groups[k - 2]++;
				}

			}
		}
		System.out.println(groups.length);
		Arrays.sort(groups);
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i]);
		}
	}

	private static void bfs(int sr, int sc, int gnum) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		map[sr][sc] = gnum;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 1) {
					q.offer(new int[] { nr, nc });
					map[nr][nc] = gnum;
				}
			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
