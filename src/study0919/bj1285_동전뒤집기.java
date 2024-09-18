package study0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1285_동전뒤집기 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'H') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		boolean b = true;
		while (b) {
			for (int r = 0; r < N; r++) {
				int cnt = 0;
				for (int c = 0; c < N; c++) {
					cnt += map[r][c];
				}
				if (cnt > N / 2) {
					swapRow(r);
				}
				cnt= 0;
			}
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int r = 0; r < N; r++) {
					cnt += map[r][c];
				}
				if (cnt > N / 2) {
					swapCol(c);
				}
				cnt = 0;
			}
			b = check();
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res += map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(res);
	}

	private static boolean check() {
		for (int r = 0; r < N; r++) {
			int cnt = 0;
			for (int c = 0; c < N; c++) {
				cnt += map[r][c];
			}
			if (cnt > N / 2) {
				return true;
			}
			cnt= 0;
		}
		for (int c = 0; c < N; c++) {
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				cnt += map[r][c];
			}
			if (cnt > N / 2) {
				return true;
			}
			cnt = 0;
		}
		return false;
	}

	private static void swapCol(int col) {
		for (int j = 0; j < N; j++) {
			map[j][col] = 1 - map[j][col];
		}

	}

	private static void swapRow(int row) {
		for (int j = 0; j < N; j++) {
			map[row][j] = 1 - map[row][j];
		}

	}

}
