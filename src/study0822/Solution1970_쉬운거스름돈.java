package study0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1970_쉬운거스름돈 {
	static int T, N;
	static int[] won;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			won = new int[8];
			calc(N);
			
			String res = "";
			for (int i = 0; i < won.length; i++) {
				res += (won[i] + " ");
			}
			System.out.println("#" + t);
			System.out.println(res);

		}

	}

	static int calc(int n) {
		if (n >= 50000) {
			won[0]++;
			return calc(n - 50000);
		} else if (n >= 10000) {
			won[1]++;
			return calc(n - 10000);
		} else if (n >= 5000) {
			won[2]++;
			return calc(n - 5000);
		} else if (n >= 1000) {
			won[3]++;
			return calc(n - 1000);
		} else if (n >= 500) {
			won[4]++;
			return calc(n - 500);
		} else if (n >= 100) {
			won[5]++;
			return calc(n - 100);
		} else if (n >= 50) {
			won[6]++;
			return calc(n - 50);
		} else if (n >= 10) {
			won[7]++;
			return calc(n - 10);
		} else {
			return 0;
		}

	}
}
