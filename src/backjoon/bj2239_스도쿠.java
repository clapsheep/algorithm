package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj2239_스도쿠 {
	static int[][] map = new int[9][9];
	static List<int[]> e = new ArrayList<>();
	static int size;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
				if (map[i][j] == 0) {
					e.add(new int[] { i, j });
				}
			}
		}

		size = e.size();
		v = new boolean[size];
		dfs(0);

	}

	private static void dfs(int cnt) {
		if (cnt == size) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}

		int[] cur = e.get(cnt);
		if (v[cnt]) {
			dfs(cnt + 1);
		}
		
		int temp = map[cur[0]][cur[1]];
		for (int j = 1; j <= 9; j++) {
			if (checkRow(cur[0], j))
				continue;
			if (checkCol(cur[1], j))
				continue;
			if (check3x3(cur, j))
				continue;
			map[cur[0]][cur[1]] = j;
			v[cnt] = true;
			dfs(cnt + 1);
			v[cnt] = false;
			map[cur[0]][cur[1]] = temp;
		}

	}

	private static boolean check3x3(int[] cur, int num) {
		int r = 0;
		if (cur[0] < 6) {
			r = 3;
		} else if (cur[0] < 9) {
			r = 6;
		}
		int c = 0;
		if (cur[1] < 6) {
			c = 3;
		} else if (cur[1] < 9) {
			c = 6;
		}
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (map[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkCol(int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkRow(int r, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num) {
				return true;
			}
		}
		return false;
	}

}
