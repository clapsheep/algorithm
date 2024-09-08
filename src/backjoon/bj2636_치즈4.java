package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636_치즈4 {
	static int N, M;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cheeseCount = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeseCount++;
			}
		}
		int time = 0;
		while(cheeseCount>0) {
			time++;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] v= new boolean[N][M];
			q.offer(new int[] {0,0});
			v[0][0] = true;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr= cur[0] + dr[i];
					int nc = cur[1] +dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc])continue;
					if(map[nr][nc]==0) {
						q.offer(new int[] {nr,nc});
						v[nr][nc] = true;
					}else {
						map[nr][nc]++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]>=3) {
						cheeseCount--;
						map[i][j] = 0;
					}else if(map[i][j] == 2) {
						map[i][j] = 1;
					}
				}
			}
		}
		System.out.println(time);
	}
}