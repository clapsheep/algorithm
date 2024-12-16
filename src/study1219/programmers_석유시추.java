package study1219;

import java.io.*;
import java.util.*;

//테스트 1 〉	통과 (0.13ms, 75.9MB)
//테스트 2 〉	통과 (0.40ms, 86.5MB)
//테스트 3 〉	통과 (0.22ms, 90.5MB)
//테스트 4 〉	통과 (0.20ms, 84.2MB)
//테스트 5 〉	통과 (0.16ms, 79.4MB)
//테스트 6 〉	통과 (0.96ms, 79.8MB)
//테스트 7 〉	통과 (1.22ms, 86.8MB)
//테스트 8 〉	통과 (0.72ms, 89.2MB)
//테스트 9 〉	통과 (3.17ms, 73.5MB)
//테스트 1 〉	통과 (27.98ms, 65.8MB)
//테스트 2 〉	통과 (75.42ms, 74.8MB)
//테스트 3 〉	통과 (80.20ms, 74.6MB)
//테스트 4 〉	통과 (22.87ms, 65.3MB)
//테스트 5 〉	통과 (79.73ms, 73.9MB)
//테스트 6 〉	통과 (25.75ms, 66.7MB)

public class programmers_석유시추 {
	static int N, M; // 최대 500
	static int mark;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static List<Integer> group;

	public int solution(int[][] land) {
		map = land;
		N = land.length;
		M = land[0].length;
		mark = 2;
		v = new boolean[N][M];
		group = new ArrayList<>(); // 해당 석유그룹 번호의 석유량
		group.add(0);
		group.add(0); // 유의미한 그룹번호는 2부터 시작;

		// 석유 그룹 마킹
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 || v[i][j])
					continue;
				marking(i, j, mark);
				mark++;
			}
		}

		int res = 0;
		int groupCnt = group.size(); // 그룹 갯수
		for (int c = 0; c < M; c++) {
			int temp = 0;
			boolean[] vis = new boolean[groupCnt]; // 해당 그룹 방문여부
			for (int r = 0; r < N; r++) {
				if (map[r][c] > 1) {
					vis[map[r][c]] = true;
				}
			}
			for (int i = 0; i < groupCnt; i++) {
				if (vis[i]) {
					temp += group.get(i);
				}
			}
			res = Math.max(res, temp);
		}

		return res;
	}

	public static void marking(int r, int c, int m) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		v[r][c] = true;
		// 해당 그룹 석유량
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == 1) {
				map[cur[0]][cur[1]] = mark;
				cnt++;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc) || v[nr][nc] || map[nr][nc] == 0)
					continue;
				v[nr][nc] = true;
				q.offer(new int[] { nr, nc });
			}

		}
		// 석유량 해싱
		group.add(cnt);
	}

	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}