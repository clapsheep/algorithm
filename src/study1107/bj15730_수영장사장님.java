package study1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj15730_수영장사장님 {
	static int N, M;
	static int[][] map;
	static int[][] level;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static Queue<int[]>[] qList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map =new int[N+2][M+2];
		level =new int[N+2][M+2];
		
		for (int i = 1; i < N+1; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		qList = new LinkedList[10001];
		for (int i = 0; i <= 10000; i++) {
			qList[i] = new LinkedList<int[]>();
		}
		bfs();
		int res = 0;
		for (int i =1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				res += level[i][j] - map[i][j];
			}
		}
		System.out.println(res);
		
		
	}
	private static void bfs() {
		boolean[][] v = new boolean[N+2][M+2];
		qList[0].offer(new int[] {0,0});
		
		for (int i = 0; i <= 10000; i++) {
			while(!qList[i].isEmpty()) {
				int[] cur = qList[i].poll();
				int curR = cur[0];
				int curC = cur[1];
				if(v[curR][curC])continue;
				v[curR][curC] = true;
				level[curR][curC] = i;
				for (int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					if(!check(nr,nc)||v[nr][nc])continue;
					if(map[nr][nc] <= i) {
						qList[i].offer(new int[] {nr,nc});
					}else {
						qList[map[nr][nc]].offer(new int[]{nr,nc});
					}
				}
			}
			
		}
		
	}
	private static boolean check(int r, int c) {
		return r >=0 && c>=0 && r < N+2 && c<M+2;
	}

}
