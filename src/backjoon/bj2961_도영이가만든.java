package backjoon;

import java.util.Scanner;

public class bj2961_도영이가만든 {
	static int N, min;
	static int[] sour, beet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		beet = new int[N];
		min = Integer.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			sour[n] = sc.nextInt();
			beet[n] = sc.nextInt();
		}
		subset(0, 1, 0);
		System.out.println(min);

	}

	private static void subset(int cnt, int s, int b) {
		if (cnt == N) {
			if (s != 1 && b != 0) {
				min = Math.min(min, Math.abs(s - b));
			}
			return;
		}
		subset(cnt + 1, s * sour[cnt], b + beet[cnt]);
		subset(cnt + 1, s, b);
	}

}
