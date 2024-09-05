package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636_치즈 {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int airMark;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static List<int[]> chz;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		chz = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 1)
					chz.add(new int[] { i, j });
			}
		}

		v = new boolean[N][M];
		airMark = 101;
		airCheck(0, 0);
		
		int cnt = 0;
		
		while (chz.size()!=0) {

			for (int i = 0; i < chz.size(); i++) {
				int[] cheese = chz.get(i);
					if (isMelting(cheese[0], cheese[1]))
						v[cheese[0]][cheese[1]] = true;
						chz.remove(i);
				}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (v[i][j])
						map[i][j] = airMark;
				}
			}
			cnt++;

		}
		System.out.println(cnt-1);
	}

	private static boolean isMelting(int r, int c) {
		int temp = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (check(nr, nc) && map[nr][nc] > 100)
				temp++;
		}

		return temp >= 2;
	}

	private static void airCheck(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { sr, sc });
		map[sr][sc] = airMark;
		v[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (v[nr][nc])
					continue;
				if (map[nr][nc] != 1) {
					q.offer(new int[] { nr, nc });
					map[nr][nc] = airMark;
					v[nr][nc] = true;

				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
