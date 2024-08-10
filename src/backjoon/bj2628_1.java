package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bj2628_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] w = new int[W + 1];
		int[] h = new int[H + 1];
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int cut = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if (cut == 0) {
				h[pos] = 1;
			} else {
				w[pos] = 1;
			}
		}
		int t = 0;
		int wMax = 0;
		for (int i = 1; i <= W; i++) {
			t++;
			if (w[i] == 1 || i == W) {
				wMax = Math.max(wMax, t);
				t = 0;
			}
		}
		t = 0;
		int hMax = 0;
		for (int i = 1; i <= H; i++) {
			t++;
			if (h[i] == 1 || i == H) {
				hMax = Math.max(hMax, t);
				t = 0;
			}
		}
		System.out.println(wMax * hMax);
	}

}
