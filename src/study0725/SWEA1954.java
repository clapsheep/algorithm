package study0725;


import java.util.Scanner;

public class SWEA1954 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			
			int cnt=1;
			int initR=0;
			int initC=0;
			int[][]snail = new int[N][N];
			int d = 0;
			
			while(cnt<=N*N) {
				
				snail[initR][initC] = cnt++;
				
				int nr = initR + dr[d];
				int nc = initC + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || snail[nr][nc]!=0) {
					d = (d+1)%4;
				}
				
				initR = initR + dr[d];
				initC = initC + dc[d];
			}
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}

		}

	}

}
