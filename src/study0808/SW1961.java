package study0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1961 {
	static int T;
	static int N;
	static int[][] arr, d90, d180, d270;
	static String[] s90, s180, s270;  
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			d90 = new int[N][N];
			s90 = new String[N];
			Arrays.fill(s90, "");
			
			d180 = new int[N][N];
			s180 = new String[N];
			Arrays.fill(s180, "");
			
			d270 = new int[N][N];
			s270 = new String[N];
			Arrays.fill(s270, "");

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					d90[c][N - 1 - r] = arr[r][c];
					s90[c] += arr[r][c];
				}
			}
			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					d180[c][N - 1 - r] = d90[r][c];
					s180[c] += d90[r][c];
				}
			}
			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					d270[c][N - 1 - r] = d180[r][c];
					s270[c] += d180[r][c];
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				System.out.println(s90[i] + " " + s180[i] + " " + s270[i]);
			}
		}
	}

}
