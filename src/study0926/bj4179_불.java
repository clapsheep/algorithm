package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4179_불 {
	static int R, C;
	static char[][] map;
	static int[] jh;
	static List<int[]> fire;
	static boolean[][] v, vF;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		fire = new ArrayList<>();
		map = new char[R][C];
		v = new boolean[R][C];
		vF = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j];
				if (map[i][j] == 'J') {
					jh = new int[] { i, j };
				}
				if (map[i][j] == 'F') {
					fire.add(new int[] { i, j });
				}
			}
		}

		int res = bfs();
		System.out.println(res >= 0 ? res : "IMPOSSIBLE");
	}

	private static int bfs() {
		int time = 0;
		Queue<int[]> moveFire = new LinkedList<>();
		Queue<int[]> moveJH = new LinkedList<>();
		for (int[] f : fire) {
			moveFire.offer(f);
			vF[f[0]][f[1]] = true;
		}
		moveJH.offer(jh);
		v[jh[0]][jh[1]] = true;

		while (!moveJH.isEmpty()) {
			time++;
			int Jsize = moveJH.size();
			int Fsize = moveFire.size();
			
			//지훈이가 움직이기
			for (int i = 0; i < Jsize; i++) {
				int[] cur = moveJH.poll();
				if (map[cur[0]][cur[1]] == 'F')
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc)) {
						return time;
					}
					if (v[nr][nc])
						continue;
					if (map[nr][nc] == '#' || map[nr][nc] == 'F')
						continue;
					moveJH.offer(new int[] { nr, nc });
					v[nr][nc] = true;
				}
			}
			// 불번지기 움직이기
			for (int i = 0; i < Fsize; i++) {
				int[] cur = moveFire.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (vF[nr][nc])
						continue;
					if (map[nr][nc] == '#')
						continue;
					moveFire.offer(new int[] { nr, nc });
					map[nr][nc] = 'F';
					vF[nr][nc] = true;
				}
			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
