package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503_로봇청소기 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, M, row, col, dir;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken()); // North:0, East:1, South:2,West:3
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // nonClean: 0, clean:1
			}
		}

		clean(row, col, dir);
		System.out.println(cnt);
	}

	static void clean(int r, int c, int d) {
		map[r][c] = -1; // 청소

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 반시계 90도 회전
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if(map[nr][nc]==0) {
					cnt++;
					clean(nr, nc, d);
					return;
				}
			}
		}
		int dir = (d+2) % 4;
		int nr = r + dr[dir];
		int nc = c+ dc[dir];
		if(nr >= 0 && nr <N && nc>=0 && nc <M && map[nr][nc] !=1) {
			clean(nr,nc,d);
		}
	}

}
