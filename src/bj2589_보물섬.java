import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2589_보물섬 {
	static int[][] map;
	static int N, M;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				if (input.charAt(j) == 'W') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					res = Math.max(res, bfs2(i,j));

				}
			}
		}

		System.out.println(res);

	}

	private static int bfs2(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c, 0 });
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			cnt = Math.max(cnt, cur[2]);
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (v[nr][nc])
					continue;
				if(map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.offer(new int[] {nr,nc, cur[2]+1});
				}
			}
		}
		return cnt;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
