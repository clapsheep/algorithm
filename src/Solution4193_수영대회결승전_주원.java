import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4193_수영대회결승전_주원 {

	static class point {
		int r;
		int c;

		point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		next: for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			boolean[][] v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			Queue<point> q = new LinkedList<>();
			q.offer(new point(A, B));

			int torn = 2;
			int time = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				time++;
				for (int i = 0; i < size; i++) {
					point cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur.r + dr[d];
						int nc = cur.c + dc[d];
						if (nr == C && nc == D) {
							System.out.println("#" + t + " " + time);
							continue next;
						}
						if (!check(nr, nc))
							continue;
						if (v[nr][nc])
							continue;
						if (map[nr][nc] == 2 && torn == 0) {
							q.offer(new point(nr, nc));
							v[nr][nc] = true;
							continue;
						} else if (map[nr][nc] == 2 && torn != 0) {
							q.offer(new point(cur.r, cur.c));
						}

						if (map[nr][nc] == 0) {
							q.offer(new point(nr, nc));
							v[nr][nc] = true;
						}

					}
				}
				if (torn == 0) {
					torn = 2;
				} else {
					torn--;
				}
			}
			System.out.println("#" + t + " " + -1);
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
