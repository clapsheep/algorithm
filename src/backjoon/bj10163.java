package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10163 {
	static int N;
	static int[][] board = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for (int j = startx; j < startx+width; j++) {
				for (int k = starty; k < starty+height; k++) {
					board[j][k] = i;
				}
			}
		}
		int[] res = new int[N];
		for (int n = 0; n < N; n++) {
			
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(board[i][j] == n+1) {
						res[n]++;
					}
				}
			}
			
		}
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}

}
