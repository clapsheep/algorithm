package swea;


import java.util.Scanner;

public class SWEA1954 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] nums = new int[N][N];
			int dir = 0; // 현재 방향 인덱스
			int initR = 0, initC = 0; // 시작 좌표

			for (int i = 1; i <= N * N; i++) {
				nums[initR][initC] = i;
				int tempR = initR + dr[dir];
				int tempC = initC + dc[dir];
				if (tempR < 0 || tempR >= N || tempC < 0 || tempC >= N || nums[tempR][tempC] != 0) {
					dir = (dir + 1) % 4;
					tempR = initR + dr[dir];
					tempC = initC + dc[dir];
				}
				initR = tempR;
				initC = tempC;
			}
			System.out.printf("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(nums[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
