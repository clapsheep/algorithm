package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21608_상어초등학교 {
	static int N;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] Likes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Likes = new int[N*N][4];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int[] like = new int[4];
			for (int j = 0; j < 4; j++) {
				like[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			Likes[num] = like;
			int R = -1, C = -1;
			int likeCount = -1;
			int emptyCount = -1;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != -1)
						continue;
					int TempLikeCount = checkLike(r, c, like);
					int TempEmptyCount = checkEmpty(r, c);
					if (likeCount < TempLikeCount) {
						R = r;
						C = c;
						likeCount = TempLikeCount;
						emptyCount = TempEmptyCount;

					} else if (likeCount == TempLikeCount) {
						if (emptyCount < TempEmptyCount) {
							R = r;
							C = c;
							emptyCount = TempEmptyCount;
						}
					}
				}
			}
			map[R][C] = num;
		}
		int ans = calcSatisfy();
		System.out.println(ans);

	}

	private static int calcSatisfy() {
		int res= 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = map[i][j];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					if(!check(nr,nc))continue;
					for (int k = 0; k < 4; k++) {
						if(map[nr][nc] == Likes[cur][k]) {
							cnt++;
						}
					}
				}
				if(cnt == 0 ) {
					res += 0;
				}else {
					res+= Math.pow(10, cnt-1);
				}
				
			}
			
		}
		return res;
	}

	private static int checkEmpty(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc))
				continue;
			if (map[nr][nc] == -1) {
				cnt++;
			}
		}
		return cnt;
	}

	private static int checkLike(int r, int c, int[] likeList) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc))
				continue;
			for (int i = 0; i < 4; i++) {
				if (map[nr][nc] == likeList[i]) {
					cnt++;
				}
			}

		}
		return cnt;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
