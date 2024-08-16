package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2567_색종이2 {
	static int N;
	static int[][] map = new int[102][102];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for (int i = r; i <= r+9; i++) {
				for (int j = c; j <= c+9; j++) {
					map[i][j] = 1;
				}
			}
		
		}
		
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(map[i][j]==0) {
					for (int d = 0; d < 4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(nr>=0 && nr<102 && nc >= 0 && nc < 102) cnt += map[nr][nc];
					}
					
				}
			}
	
		}
		System.out.println(cnt);
		
	}

}
