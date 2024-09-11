package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16197_두동전 {
	static int N, M;
	static char[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[] coin1 = new int[2], coin2 = new int[2];
	static boolean isFindCoin1;
	static boolean[][] v1;
	static boolean[][] v2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v1 = new boolean[N][M];
		v2 = new boolean[N][M];
		isFindCoin1 = false;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'o') {
					if (!isFindCoin1) {
						coin1[0] = i;
						coin1[1] = j;
						isFindCoin1 = true;
					} else {
						coin2[0] = i;
						coin2[1] = j;
					}
				}
			}
		}

		int res = bfs(coin1, coin2);
		System.out.println(res > 10 ? -1 : res);
	}

	static int bfs(int[] c1, int[] c2) {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		q.offer(c1);
		q.offer(c2);

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			if (cnt > 10)
				return -1;
			for (int i = 0; i < size / 2; i++) {
				int[] cur1 = q.poll();
				int[] cur2 = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr1 = cur1[0] + dr[d];
					int nc1 = cur1[1] + dc[d];
					int nr2 = cur2[0] + dr[d];
					int nc2 = cur2[1] + dc[d];
					if (!check(nr1, nc1) && !check(nr2, nc2)) { // 둘다 나가면 안되고,
						continue;
						// 둘중에 하나가 나가면 OK
					} else if ((!check(nr1, nc1) && check(nr2, nc2)) || (check(nr1, nc1) && !check(nr2, nc2))) {
						return cnt;
					} else { // 둘다 안에 있으
						if (map[nr1][nc1] == '#') {
							q.offer(cur1);
						}
						if (map[nr2][nc2] == '#') {
							q.offer(cur2);
						}
						if (map[nr1][nc1] == '.' || map[nr1][nc1] == 'o') {
							q.offer(new int[] { nr1, nc1 });

						}
						if (map[nr2][nc2] == '.' || map[nr2][nc2] == 'o') {
							q.offer(new int[] { nr2, nc2 });

						}
					}
				}
			}
			
		}

		return -1;

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
