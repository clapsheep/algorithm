import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767_프로세서연결하기 {
	static int T, N;
	static int[][] map;
	static List<Core> Cores;
	static int CC, max, min;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static class Core {
		int r;
		int c;

		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			Cores = new ArrayList<>();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (!(i == 0 || j == 0)) {
							Cores.add(new Core(i, j));
						}
					}
				}
			}
			CC = Cores.size();
			max = 0;
			min = N * N;
			
			dfs(0, 0, 0);
			sb.append(min);
			System.out.println(sb.toString());
		}
	}

	private static void dfs(int depth, int maxCore, int minLine ) {
		if(N-depth+maxCore<max)return;
		if (depth == CC) {
			if (maxCore > max) {
			    max = maxCore;
			    min = minLine;
			} else if (maxCore == max) {
			    min = Math.min(min, minLine);
			}
			return;
		}
		int[][] temp = new int[N][N]; // 원본에서 복사한 임시 맵
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, N);
		}

		Core curr = Cores.get(depth); // 현재 depth의 코어 꺼내기
		for (int d = 0; d < 4; d++) {
			if (!isPossible(curr, d)) { // 끝까지 갈 수 있는 곳이 아니면?
				dfs(depth + 1, maxCore, minLine);
			} else {
				int currLine = calcLine(curr, d); // 갈 수 있다면? 전선연결하고 해당 갯수 반환;
				dfs(depth + 1, maxCore + 1, minLine + currLine);
			}
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, map[i], 0, N);
			}
		}
	}

	private static int calcLine(Core curr, int d) {
		int r = curr.r;
		int c = curr.c;
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

	private static boolean isPossible(Core curr, int d) {
		int r = curr.r;
		int c = curr.c;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (!check(r, c))
				return true;
			if (map[r][c] == 2 || map[r][c]==1)
				return false;
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
