package study0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1959 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// N과 M중 짧은 친구를 담는다.
			int minRange = Math.min(N, M);
	
			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				A[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				B[m] = Integer.parseInt(st.nextToken());
			}

			
			
			int max = Integer.MIN_VALUE;
			
			// 배열 A가 짧은 친구면
			if (minRange == A.length) {	
				for (int k = 0; k < M - minRange+1; k++) { // 긴 친구의 인덱스 추가하며 돌기
					int sum = 0;
					for (int i = 0; i < minRange; i++) { // 짧은 친구들 만큼 길이의 합
						sum += A[i] * B[i + k];
					}
					max = Math.max(sum, max);
				}
			}else { // A가 짧은 친구가 아니면?
				for (int k = 0; k < N - minRange+1; k++) {
					int sum = 0;
					for (int i = 0; i < minRange; i++) {
						sum += A[i+k] * B[i];
					}
					max = Math.max(sum, max);
				}
			}

			System.out.println("#" + t + " " + max);
		}

	}

}
