import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4193_수영대회결승전 {
	static int T, N, A, B, C, D;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			int res = bfs(A, B);
			sb.append(res);
			System.out.println(sb.toString());
		}

	}

	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		v[sr][sc] = true;

		int time = 0;
		int storm = 2;
		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (nr == C && nc == D) {
						return time;
					}

					if (!check(nr, nc))
						continue;
					if (v[nr][nc])
						continue;

					if (map[nr][nc] == 2 && storm != 0) {
						q.offer(cur);
						continue;
					} else if (map[nr][nc] == 2 && storm == 0) {
						q.offer(new int[] { nr, nc });
						v[nr][nc] = true;
					}
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc });
						v[nr][nc] = true;
					}
				}
			}
			if (storm == 0) {
				storm = 2;
			} else {
				storm--;
			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
