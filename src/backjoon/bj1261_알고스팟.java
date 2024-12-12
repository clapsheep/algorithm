package backjoon;

import java.util.*;
import java.io.*;

public class bj1261_알고스팟 {
	static int R, C, res;
	static int[][] map, v;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new int[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j) - '0';
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		
		res = bfs();
		System.out.println(res);
	}

	private static int bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		q.offer(new int[] {0,0,0});
		v[0][0] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == R-1 &&  cur[1] == C-1) {
				return cur[2];
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(!check(nr,nc))continue;
				if(map[nr][nc] + cur[2] < v[nr][nc]) {
					v[nr][nc] = map[nr][nc] + cur[2];
					q.offer(new int[] {nr,nc,map[nr][nc] + cur[2]});
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean check(int r, int c) {
		return r>=0 && c >=0 && r<R && c<C;
	}

}
