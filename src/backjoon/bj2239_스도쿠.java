package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj2239_스도쿠 {
	static int[][] map = new int[9][9];
	static List<int[]> e = new ArrayList<>();
	static int size;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) {
					e.add(new int[] { i, j });
				}
			}
		}
		size = e.size();

		dfs(0);
		System.out.println(sb.toString());
	}

	private static boolean dfs(int cnt) {
		if (cnt == size) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			return true;
		}

		int[] cur = e.get(cnt);

		for (int j = 1; j <= 9; j++) {
			if (isValid(cur[0], cur[1], j)) {
				map[cur[0]][cur[1]] = j;
				if (dfs(cnt + 1)) {
					return true;
				}
				map[cur[0]][cur[1]] = 0;
			}
		}
		return false;

	}

	private static boolean isValid(int row, int col, int num) {
		// Check row
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == num)
				return false;
		}

		// Check column
		for (int i = 0; i < 9; i++) {
			if (map[i][col] == num)
				return false;
		}

		// Check 3x3 box
		int boxRow = row - row % 3;
		int boxCol = col - col % 3;
		for (int i = boxRow; i < boxRow + 3; i++) {
			for (int j = boxCol; j < boxCol + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

}
