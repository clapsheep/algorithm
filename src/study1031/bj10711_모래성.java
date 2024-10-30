package study1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10711_모래성 {
	static int N, M;
	static char[][] map;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Queue<int[]> no;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		no = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '.') {
					no.offer(new int[] { i, j }); // 이전과 반대로 .만 Queue에 넣기
				}
			}
		}
		v = new boolean[N][M];
		int cnt = 0;
		while (!no.isEmpty()) {
			int size = no.size();
			for (int i = 0; i < size; i++) {
				int[] cur = no.poll();
				v[cur[0]][cur[1]] = true;
				for (int d = 0; d < 8; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc) || v[nr][nc])
						continue;

					if (map[nr][nc] != '.') { // 주변숫자 1씩 깎기
						if (--map[nr][nc] == '0') {  // 0이면 새로운 .이 되었으므로 큐에 넣기
							map[nr][nc] = '.';
							no.offer(new int[] { nr, nc });
						}
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt-1);
	}
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
