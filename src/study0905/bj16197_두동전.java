package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16197_두동전 {
	static int N, M, min;
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
		min = Integer.MAX_VALUE;
		click(coin1, coin2, 0);
		System.out.println(min > 10 ? -1 : min);
	}

	// c1과 c2의 좌표가 밖으로 나가면? return;
	// 근데 둘 중에 1개만 나가야 함.
	static void click(int[] c1, int[] c2, int cnt) {
		if (checkOut(c1) || checkOut(c2)) {
			if (checkOut(c1) && checkOut(c2)) {
				return;
			} else {
				min = Math.min(min, cnt);
				return;
			}
		}
		for (int d = 0; d < 4; d++) {
			int[] nc1 = move(c1, d);
			int[] nc2 = move(c2, d);
			if (nc1 == null || nc2 == null)
				continue;
			if (v1[nc1[0]][nc1[1]] || v2[nc2[0]][nc2[1]])
				continue;
			v1[nc1[0]][nc1[1]] = true;
			v2[nc2[0]][nc2[1]] = true;
			click(nc1, nc2, cnt + 1);
			v1[nc1[0]][nc1[1]] = false;
			v2[nc2[0]][nc2[1]] = false;

		}

	}

	private static int[] move(int[] coin, int d) {
		int nr = coin[0] + dr[d];
		int nc = coin[1] + dc[d];
		if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') {
//		if (map[nr][nc] == '#') {
			return null;
		} else {
			int[] ncoin = { nr, nc };
			return ncoin;
		}
	}

	static boolean checkOut(int[] coin) {
		if (coin[0] >= 0 && coin[0] < N && coin[1] >= 0 && coin[1] < M)
			return false; // 안나갔다.
		else
			return true; // 나갔다.
	}

}
