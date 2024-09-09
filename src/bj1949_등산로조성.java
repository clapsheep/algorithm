import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1949_등산로조성 {
	static int T, N, K, maxHeight, res;
	static int[][] map, temp;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			temp = new int[N][N];
			maxHeight = 0;
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = map[i][j];
					maxHeight = Math.max(maxHeight, map[i][j]); // 정점에서 시작하기 위한 정점 파악
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = map[i][j];
					for (int k = 0; k <= K; k++) {
						map[i][j] = tmp - k; // 모든 칸에 대하여 0부터 K만큼 깎는다.

						List<int[]> V = new ArrayList<>(); // 현재 최고 높이 정점을 찾는다.
						for (int a = 0; a < N; a++) {
							for (int b = 0; b < N; b++) {
								if (map[a][b] == maxHeight) {
									V.add(new int[] { a, b }); // 정점 리스트 생성
								}
							}
						}

						for (int[] start : V) { // 정점들을 시작 점으로
							v= new boolean[N][N];
							v[start[0]][start[1]]=true;
							dfs(start[0], start[1], 1 ,v);
						}

					}
					for (int l = 0; l < N; l++) {
						System.arraycopy(temp[l], 0, map[l], 0, N);
					}
				}
			}
			sb.append(res);
			System.out.println(sb.toString());
		}
	}

	private static void dfs(int r, int c, int cnt, boolean[][]visit) {
		res = Math.max(res, cnt);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (check(nr, nc))
				continue;
			if(visit[nr][nc])continue;
			if (map[r][c] > map[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, cnt + 1,visit);
				visit[nr][nc] = false;
			}
		}

	}

	private static boolean check(int n, int c) {
		return n < 0 || n >= N || c < 0 || c >= N;
	}

}
