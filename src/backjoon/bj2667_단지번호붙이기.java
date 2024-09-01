package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[i]-'0';
			}
		}
		v = new boolean[N][N];
	}

}
