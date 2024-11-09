import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bubble_codesignal {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	

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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}
		for (int i = N-1; i > 0; i++) {
			for (int j = M-1; j > 0; j++) {
				if(map[i][j] != 0) {
					
				}
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] { i, j });
		v[i][j] = true;
		int now = map[i][j];
		boolean flag = false;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if(map[nr][nc]==now) {
					flag = true;
					v[nr][nc] = true;
					q.offer(new int[] {nr,nc});
					map[nr][nc] = 0;
				}else {
					continue;
				}

			}

		}
		if(flag) {
			map[i][j] = 0;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
