package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj12100_2048 {
	static int N = 3;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		print();
		moveRight();
		print();
		moveDown();
		print();
		moveLeft();
		print();
		moveUp();
		print();

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	public static void moveRight() {
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 1; j--) {
				while(true) {
					int nr = i;
					int nc = j+1;
					if(!check(nr,nc))break;
					if(map[nr][nc]!= 0) {
						if(map[nr][nc] == map[i][j]) {
							
						}
					}
				}
				
//				if (map[i][j] == map[i][j - 1]) {
//					int sum = map[i][j] + map[i][j - 1];
//					map[i][j] = sum;
//					if (j == 1) {
//						map[i][0] = 0;
//					}
//				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r<N && c<N;
	}

	public static void moveDown() {
		for (int i = N - 1; i >= 1; i--) {
			for (int j = 0; j < N; j++) {
				int sum = map[i][j] + map[i - 1][j];
				map[i][j] = sum;
				if (i == 1) {
					map[0][j] = 0;
				}
			}
		}

	}

	public static void moveLeft() {
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int sum = map[i][j] + map[i][j - 1];
				map[i][j] = sum;
				if (j == 1) {
					map[i][N - 1] = 0;
				}
			}
		}
	}

	public static void moveUp() {
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				int sum = map[i][j] + map[i + 1][j];
				map[i][j] = sum;
				if (i == N - 2) {
					map[N - 1][j] = 0;
				}
			}
		}
	}

}
