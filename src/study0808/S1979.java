package study0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1979 {
	static int T;
	static int N;
	static int K;
	static int[][] arr;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				 st = new StringTokenizer(br.readLine());
				 for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

				}

			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
