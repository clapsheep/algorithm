package backjoon;

import java.util.Scanner;

public class bj9663_NQueen {
	static int N, res;
	static int[] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N]; // map의 index는Row, 값은 Col이라고 생

		res = 0;
		dfs(0);// 첫 열부터 보면서 내려가겠다.
		System.out.println(res);

	}

	private static void dfs(int cnt) {
		if (cnt == N) { // row 끝까지 내려갔다?
			res++;// 가능한 경우이므로 추가
			return;
		}
		for (int i = 0; i < N; i++) { // 해당 row에서 모든 Col을 조회
			map[cnt] = i; // map[cnt][i]에 퀸을 놓아보겠다.
			if (isOk(cnt)) { 
				dfs(cnt + 1);
			}
		}

	}

	private static boolean isOk(int row) {
		for (int i = 0; i < row; i++) {
			if (map[row] == map[i]) {
				return false;
			} else if (Math.abs(row - i) == Math.abs(map[row] - map[i])) {
				return false;
			}
		}
		return true;
	}

}
