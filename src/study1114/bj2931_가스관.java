package study1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2931_가스관 {
	static int N, M;
	static char[][] map;
	static int[] start, end;
	// 0 :하->상 // 1 : 좌->우 // 2 : 상->하 // 3 : 우->좌
	static int dirState;
	// 상, 우, 하, 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'M') {
					start = new int[] { i, j };
				}
				if (map[i][j] == 'Z') {
					end = new int[] { i, j };
				}
			}
		}

		int[] emptyPos;

		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == '.')
					continue;
				if (map[nr][nc] != '+') {
					dirState = d;
					q.offer(new int[] { nr, nc });
				}
				if(map[nr][nc] == '+') {
					
				}

			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
