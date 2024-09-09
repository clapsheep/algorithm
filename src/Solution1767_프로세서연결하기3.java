import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767_프로세서연결하기3 {
	static int T, N, maxCell, minLine, cellSize;
	static int[][] map;
	static List<int[]> Cells;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			Cells = new ArrayList<>();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
							Cells.add(new int[] { i, j });
						}
					}
				}
			}
			
			cellSize = Cells.size();
			maxCell = 0;
			minLine = N * N + 1;
			dfs(0, 0, 0);
			sb.append(minLine);
			System.out.println(sb.toString());
		}

	}

	private static void dfs(int cnt, int cCount, int lCount) {
		if (cellSize - cnt + cCount< maxCell) {
			return;
		}
		if (cnt == cellSize) {
			if (maxCell < cCount) {
				maxCell = cCount;
				minLine = lCount;
			} else {
				if (maxCell == cCount) {
					minLine = Math.min(minLine, lCount);
				}
			}
			return;
		}
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, N);
		}
		int[] cur = Cells.get(cnt);
		for (int d = 0; d < 4; d++) {
			if (!canGoToEnd(cur, d)) {
				dfs(cnt + 1, cCount, lCount);
			} else {
				int line = calc(cur, d);
				dfs(cnt + 1, cCount + 1, lCount + line);
			}
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, map[i], 0, N);
			}
		}
	}

	private static int calc(int[] cell, int d) {
		int r = cell[0];
		int c = cell[1];
		int cnt=0;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (!check(r, c))break;
			cnt++;
			map[r][c] = 2;
		}
		return cnt;
	}

	private static boolean canGoToEnd(int[] cell, int d) {
		int r = cell[0];
		int c = cell[1];
		while (true) {
			r += dr[d];
			c += dc[d];
			if (!check(r, c))
				return true;
			if (map[r][c] == 1 || map[r][c] == 2)
				return false;
		}
	}

	private static boolean check(int r, int c) {

		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
