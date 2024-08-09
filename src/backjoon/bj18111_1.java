package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111_1 {
	static int N, M, B;
	static int[][] map;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = -1;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[n][m]);
				max = Math.max(max, map[n][m]);
			}
		}

		time = Integer.MAX_VALUE;
		int height = 0;
		for (int h = min; h <= max; h++) {
			int t = 0;
			int block = B;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] > h) {
						t += (map[r][c] - h) * 2;
						block+=(map[r][c] - h);
					} else if (map[r][c] < h) {
						t += (h - map[r][c]);
						block-=(h - map[r][c]);
					} else {
						continue;
					}
				}
			}
			if (block < 0)continue;
			
			if (time >= t) {
				time = t;
				height = Math.max(height, h);
			}

		}

		System.out.println(time + " " + height);
	}

}
