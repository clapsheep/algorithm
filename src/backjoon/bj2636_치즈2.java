package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636_치즈2 {
	static int N, M, airMark;
	static int[][] map, temp;
	static boolean[][] v;
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

		airMark = 100;
		airCheck(0, 0);

		int cnt = 0;
		int size = chz.size();

//		while (!isEmpty()) {
			for (int i = 0; i < size; i++) {
				int[] cheeze = chz.get(i);
				if(isMelting(cheeze[0], cheeze[1])) {
					map[cheeze[0]][cheeze[1]] = 0; 
				}
			}
			airCheck(0, 0);
			
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
//		}

		System.out.println(cnt);
	}

	private static boolean isEmpty() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isMelting(int r, int c) {
		int temp = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc))
				continue;
			if (map[nr][nc] >= 100)
				temp++;
		}
		return temp >= 2;
	}

	private static void airCheck(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { sr, sc });
		v[sr][sc] = true;
		map[sr][sc] = airMark;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (v[nr][nc])
					continue;

				if (map[nr][nc] != 1) { // 치즈 아닌 바깥 공기부분
					q.offer(new int[] { nr, nc });
					v[nr][nc] = true; // 트루
					map[nr][nc] = airMark;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
