package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940_RC카 {
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int distance = 0;
			int speed = 0;
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int gasocdo = 0;
				if (mode != 0) {
					gasocdo = Integer.parseInt(st.nextToken());
				}
				switch (mode) {
				case 0:
					distance += speed;
					break;
				case 1:
					speed += gasocdo;
					distance += speed;
					break;
				case 2:
					speed -= gasocdo;
					if (speed < 0) {
						speed = 0;
					}
					distance += speed;
					break;
				}
			}

			System.out.println("#" + t + " " + distance);
		}

	}

}
