package study0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1284 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int cnt = 0;
			int[] d = { -1, K };
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//열 확인
			for (int r = 0; r < N; r++) {
				for (int i = 0; i <= N - K ; i++) {
					int sum = 0;
					// 앞뒤 체크
					int before = i + d[0];
					int after = i + d[1];
					if (before >= 0) {
						if (arr[r][before] != 0) {
							continue;
						}
					}
					if (after < N) {
						if (arr[r][after] != 0) {
							continue;
						}
					}
					
					for (int j = i; j < i + K; j++) {
						sum += arr[r][j];
					}
					if (sum == K) {
						cnt++;
					}
				}
			}
			// 행 확인
			for (int r = 0; r < N; r++) {
				for (int i = 0; i <= N - K ; i++) {
					int sum = 0;
					
					// 앞뒤 체크
					int before = i + d[0];
					int after = i + d[1];
					if (before >= 0) {
						if (arr[before][r] != 0) {
							continue;
					
						}
					}
					if (after < N) {
						if (arr[after][r] != 0) {
							continue;
						}
					}
	
					for (int j = i; j < i + K; j++) {
						sum += arr[j][r];
					}
					if (sum == K) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}

	}

}
