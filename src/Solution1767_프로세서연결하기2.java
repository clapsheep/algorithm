import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767_프로세서연결하기2 {
	static int T, N, res, totalCell, maxCell, minLine;
	static int[][] map;
	static List<int[]> cells;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			cells  = new ArrayList<>();
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							cells.add(new int[] { i, j });
						}
					}
				}
			}
			totalCell = cells.size();
			maxCell = 0;
			minLine = N * N + 1;
			dfs(0, 0, 0);
			sb.append(minLine);
			System.out.println(sb.toString());
		}
	}

	private static void dfs(int cnt, int cellCount, int lineCount) {
		if (totalCell - cnt + cellCount < maxCell)
			return;
		if (cnt == totalCell) {
			if (cellCount > maxCell) {
				maxCell = cellCount;
				minLine = lineCount;
			} else {
				if (cellCount == maxCell) {
					minLine = Math.min(minLine, lineCount);
				}
			}
			return;
		}
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, N);
		}
		int[] cell = cells.get(cnt);
		for (int d = 0; d < 4; d++) {
			if (!goToEnd(cell, d)) {
				dfs(cnt + 1, cellCount, lineCount);
			} else {
				int currLine = calcLine(cell, d);
				dfs(cnt + 1, cellCount + 1, lineCount + currLine);
			}
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, map[i], 0, N);
			}
		}
	}

	private static int calcLine(int[] cur, int d) {
		int r = cur[0];
		int c = cur[1];
		int cnt = 0;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (!check(r, c))
				break;
			map[r][c] = 2;
			cnt++;
		}
		return cnt;
	}

	private static boolean goToEnd(int[] cur, int d) {
		int r = cur[0];
		int c = cur[1];
		while (true) {
			r += dr[d];
			c += dc[d];
			if (!check(r, c))
				return true;
			if (map[r][c] == 2 || map[r][c] == 1)
				return false;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
