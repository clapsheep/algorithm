package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2669 {
	static int[][] map = new int[100][100];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int minx = Integer.parseInt(st.nextToken());
			int miny = Integer.parseInt(st.nextToken());
			int maxx = Integer.parseInt(st.nextToken());
			int maxy = Integer.parseInt(st.nextToken());

			for (int i = miny; i < maxy; i++) {
				for (int j = minx; j < maxx; j++) {
					map[i][j] = 1;
				}
			}

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}
}
