import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1987_알파벳 {
	static int R, C;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 1);
		// (0,0)부터 시작하며, 현재 이동한 위치는 0회

		System.out.println(ans);
	}

	public static void dfs(int r, int c, int count) {
		visit[map[r][c]] = true;
		ans = Math.max(ans, count); // 정답을 갱신해준다.
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc)) {
				if (visit[map[nr][nc]] == false) {
					dfs(nr, nc, count + 1);
					visit[map[nr][nc]] = false;
				}

			}
		}

	}

	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
