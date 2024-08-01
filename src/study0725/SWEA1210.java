package study0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	static int T = 10;
	static int N = 100;
	static int[][] map;
	static int nowR, nowC;
	static int[] dr = { -1, 0, 0 };
	static int[] dc = { 0, -1, 1 }; // 상 좌 우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N+2][N+2];
		for (int t = 1; t <= T; t++) {
			int trash = Integer.parseInt(br.readLine());

			for (int i = 1; i < N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						nowR = i;
						nowC = j;
					}
				}

			}
			int d = 0;
			int sc = 100;
				while(true) {
					if(nowR==0) {
						sc = nowC;
						break;
					}
					
					map[nowR][nowC]=2;
					
					// 왼쪽으로 가는 경우
					if(map[nowR][nowC-1] == 1 && map[nowR-1][nowC]== 1 
							&& map[nowR][nowC+1]==0 ) {
						d=1;
					}
					//오른쪽으로 가는 경우
					if(map[nowR][nowC+1]==1 && map[nowR-1][nowC]==1
							&&map[nowR][nowC-1]==0) {
						d=2;
					}
					// 위로 가는 경우
					if(map[nowR][nowC-1]==0 && map[nowR-1][nowC]==1 && map[nowR][nowC+1] ==2
							|| map[nowR][nowC+1]==0 && map[nowR-1][nowC]==1 &&map[nowR][nowC-1]==2) {
						d=0;
					}
					// 다음 방향
					nowR = nowR+dr[d];
					nowC = nowC+dc[d];
					
				}
				System.out.println("#"+t+" "+(sc-1));
		}

	}

}