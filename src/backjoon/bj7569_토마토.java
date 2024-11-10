package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569_토마토 {
	static int N, M, H;
	static int[][][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { 1, -1 };
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M= Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		boolean isAll = true;
		map = new int[H][N][M];
		Queue<int[]> q = new LinkedList<>();
		v = new boolean[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[h][r][c] = Integer.parseInt(st.nextToken());
					if (map[h][r][c] != -1 && map[h][r][c] == 0) { // 빈칸이 아닌데, 0이면? 안익은게 1개라도 있다.
						isAll = false;
					}
					if (map[h][r][c] == 1) {
						q.offer(new int[] { h, r, c });
						v[h][r][c] = true;
					}
				}
			}
		}
		if (isAll) {
			System.out.println(0);
			return;
		}
		int res = 0;
		while (!q.isEmpty()) {
			res++;
			int size = q.size();
			
			for (int i = 0; i < size; i++) {

				int[] cur = q.poll();
				for (int h = 0; h < 2; h++) {
					int nh = cur[0] + dh[h];
					if (!checkH(nh))
						continue;
					if (v[nh][cur[1]][cur[2]])
						continue;
					if (map[nh][cur[1]][cur[2]] == 0) {
						q.offer(new int[] { nh, cur[1], cur[2] });
						v[nh][cur[1]][cur[2]] = true;
						map[nh][cur[1]][cur[2]]  = 1;
					}
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[1] + dr[d];
					int nc = cur[2] + dc[d];
					if (!check(nr, nc))
						continue;
					if (v[cur[0]][nr][nc])
						continue;
					if (map[cur[0]][nr][nc] == 0) {
						q.offer(new int[] { cur[0], nr, nc });
						v[cur[0]][nr][nc] = true;
						map[cur[0]][nr][nc] = 1;
					}
				}
			}
			
		}
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[h][r][c] == 0) {
						System.out.println(-1);
						return;
					}
					
				}
			}
		}
		System.out.println(res-1);

	}

	private static boolean checkH(int h) {
		return h >= 0 && h < H;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
