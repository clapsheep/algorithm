package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2166_주사위쌓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		
		for (int b = 1; b <= 6; b++) { // 첫 bottom이 될 수 있는 경우의 수
			int bottom = b;
			int top = 0; // top 초기화
			int i = 0; // 현재 주사위 높이

			int sum = 0; // 각 주사위 층의 bottom top 제외 가장 큰 숫자의 합
			while (i < N) { // 주사위 갯수만큼 돌릴거야
				if (bottom == dice[i][0]) { // bottom 0? top 5
					top = dice[i][5];
					int m =0;
					for (int j = 1; j <= 6; j++) { // bottom top 제외 가장 큰 수
						if (j != bottom && j != top) {
							m = Math.max(m,j);
						}
					}
					sum+=m;
				} else if (bottom == dice[i][1]) { // bottom 1? top 3
					top = dice[i][3];
					int m =0;
					for (int j = 1; j <= 6; j++) {
						if (j != bottom && j != top) {
							m = Math.max(m, j);
						}
					}
					sum+=m;
				} else if (bottom == dice[i][2]) { // bottom 2? top 3
					top = dice[i][4];
					int m =0;
					for (int j = 1; j <= 6; j++) {
						if (j != bottom && j != top) {
							m = Math.max(m, j);
						}
					}
					sum+=m;
				} else if (bottom == dice[i][3]) { // bottom 3? top 1
					top = dice[i][1];
					int m =0;
					for (int j = 1; j <= 6; j++) {
						if (j != bottom && j != top) {
							m = Math.max(m, j);
						}
					}
					sum+=m;
				} else if (bottom == dice[i][4]) { // bottom 4? top 2
					top = dice[i][2];
					int m =0;
					for (int j = 1; j <= 6; j++) {
						if (j != bottom && j != top) {
							m = Math.max(m, j);
						}
					}
					sum+=m;
				} else { // bottom 5? top 1
					top = dice[i][0];
					int m =0;
					for (int j = 1; j <= 6; j++) {
						if (j != bottom && j != top) {
							m = Math.max(m, j);
						}
					}
					sum+=m;
				}
				i++; // 다음 위층 주사위로 넘어가자
				bottom = top; // 방금 층의 top이 다음 층의 bottom
			}
			max = Math.max(max, sum); // 모든 경우의 최대값

		}
		System.out.println(max);
	}

}
