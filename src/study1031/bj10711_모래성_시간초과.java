package study1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10711_모래성_시간초과 {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static class Tower{
		int r,c,w;
		public Tower(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	static Queue<Tower> towers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		towers = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (input[j] == '.') {
					map[i][j] = 0;
				}else {
					map[i][j] = input[j] -'0';
					if(map[i][j]<9) {
						towers.offer(new Tower(i,j,map[i][j]));
					}
				}
			}
		}
		int res = 0;
		while(!towers.isEmpty()) {
			List<int[]> destroy = new ArrayList<>();
			int size = towers.size();
			
			for (int i = 0; i < size; i++) {
				Tower cur = towers.poll();
				int cnt = 0;
				for (int d = 0; d < 8; d++) {
					int nr = cur.r+dr[d];
					int nc = cur.c+dc[d];
					if(!check(nr,nc)) {
						continue;
					}
					if(map[nr][nc]==0) {
						cnt++;
					}
				}
				if(cur.w <= cnt) {
					destroy.add(new int[] {cur.r,cur.c});
				}else {
					towers.offer(cur);
				}
			}
			if(destroy.size()==0) {
				break;
			}
			for (int[] pos : destroy) {
				map[pos[0]][pos[1]] = 0;
			}
			res++;
		}
		System.out.println(res);
	}

	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M ;
	}
}
