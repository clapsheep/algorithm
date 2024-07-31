package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1913 {
	static int N;
	static int searchNum;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };

	// 시작 좌표
	static int initR = 0;
	static int initC = 0;
	
	static int searchR=-1;
	static int searchC=-1;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		searchNum = Integer.parseInt(br.readLine());
		
		int count = N * N;
		int d = 0;
		
		int r = initR;
		int c = initC;
		
		while (count>0) {
			
			map[r][c] = count;
			
			if(count == searchNum) {
				searchR = r;
				searchC = c;
			}
			
			int nr = r + dr[d];
			int nc = c + dc[d];
						
			if (nr >= N || nr < 0 || nc >= N || nc < 0 || map[nr][nc]!=0) {
				d=(d+1)%4;
			}
			r += dr[d];
			c += dc[d];
			count--;
		
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		sb.append((searchR+1)+" "+(searchC+1));
		System.out.println(sb.toString());
	}

}
