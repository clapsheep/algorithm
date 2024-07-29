package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer	st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int strike = 0;
			for (int r = 0; r <= N-M; r++) {
				for (int c = 0; c <= N-M; c++) {
					
					for (int dr = r; dr <= r+M-1; dr++) {
						for (int dc = c; dc <= c+M-1; dc++) {
							strike += map[dr][dc];
						}
					}
					
					if(max<strike) {
						max=strike;
					}
					strike=0;
					
				}
			}
			System.out.println("#"+(i+1)+" "+max);
			
		}
		
	}
}
