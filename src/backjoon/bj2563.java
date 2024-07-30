package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2563 {
		
	static int N = 100;
	static int[][] paper = new int[N][N];
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int i = r; i < r+10; i++) {
				for (int j = c; j < c+10; j++) {
					paper[i][j] = 1;
				}
			}
		}

		int res=0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if(paper[i][j]==1) {
					res+=1;
				}
			}
		}
		System.out.println(res);

	}

}
