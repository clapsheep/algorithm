import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution10966_물놀이를가자_시간초과 {
	static int T, N, M;
	static int[][] map;
	static List<int[]> land;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			land = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					if (input.charAt(j) == 'W') {
						map[i][j] = 1;
					} else {
						land.add(new int[] { i, j });
					}
				}
			}

			int size = land.size();

			int res = 0;
			for (int i = 0; i < size; i++) {
				int[] now = land.get(i);
				res += bfs(now[0], now[1]);
			}
			sb.append(res);
			System.out.println(sb.toString());
		}

	}

	private static int bfs(int nowR, int nowC) {
		Queue<int[]> q = new LinkedList<>();
		int time = 0;
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] {nowR, nowC});
		v[nowR][nowC] = true;
		while (!q.isEmpty()) {
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (map[cur[0]][cur[1]] == 1) {
					return time;
				}
				for (int d = 0; d < 4; d++) {
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
		return 0;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
