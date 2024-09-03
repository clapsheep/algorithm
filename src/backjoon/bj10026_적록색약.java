package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj10026_적록색약 {
	static int N, count;
	static int[][] mapx, map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		StringBuilder sb= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mapx = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] == 'R') {
					mapx[i][j] = 1;
					map[i][j] = 1;
				} else if (temp[j] == 'G') {
					mapx[i][j] = 1;
					map[i][j] = 2;
				} else {
					mapx[i][j] = 0;
					map[i][j] = 0;
				}
			}

		}
		
		// 정상을 위한 로직
		count = 3;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= 2) {
					bfs(i, j);
					count++;
				}
			}
		}
		sb.append(count-3).append(" ");
		// 색약을 위한 로직
		count = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mapx[i][j] <= 1) {
					bfsx(i, j);
					count++;
				}
			}
		}
		sb.append(count-2);
		System.out.println(sb.toString());
		
	}

	private static void bfsx(int sr, int sc) {
		int temp = mapx[sr][sc];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		mapx[sr][sc] = count;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (!check(nr, nc))
					continue;
				if (mapx[nr][nc] == temp) {
					q.offer(new int[] { nr, nc });
					mapx[nr][nc] = count;
				}
			}
		}
		
	}

	private static void bfs(int sr, int sc) {
		
		int temp = map[sr][sc];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		map[sr][sc] = count;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == temp) {
					q.offer(new int[] { nr, nc });
					map[nr][nc] = count;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
