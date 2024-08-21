package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2309 {
	static int N = 9, R = 7;
	static int[] p;
	static int[] nums;
	static boolean[] visited;
	static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p = new int[N];
		visited = new boolean[N];
		nums = new int[R];
		res = new int[R];

		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		nCr(0, 0, 0);
		Arrays.sort(res);
		for (int i = 0; i < R; i++) {
			System.out.println(res[i]);
		}
	}

	private static void nCr(int cnt, int start, int tot) {
		
		if (cnt == R) {
			if (tot == 100) {
				for (int i = 0; i < R; i++) {
					res[i] = nums[i];
					
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[cnt] = p[i];
			nCr(cnt + 1, i + 1, tot + p[i]);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}
