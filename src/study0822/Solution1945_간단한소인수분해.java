package study0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1945_간단한소인수분해 {
	static int T;
	static int N;
	static int a, b, c, d, e;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			div(N);

			System.out.println("#" + t + " " + a + " " + b + " " + c + " " + d + " " + e);
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
		}

	}

	static int div(int n) {
		if (n == 1) {
			return n;
		}
		if (n % 2 == 0) {
			a++;
			return div(n / 2);
		}
		if (n % 3 == 0) {
			b++;
			return div(n / 3);
		}
		if (n % 5 == 0) {
			c++;
			return div(n / 5);
		}
		if (n % 7 == 0) {
			d++;
			return div(n / 7);
		}
		if (n % 11 == 0) {
			e++;
			return div(n / 11);
		} else {
			return n;
		}
	}

}
