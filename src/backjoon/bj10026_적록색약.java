package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class bj10026_적록색약 {
	static int N;
	static char[][] map;
	static int blind;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

	}

}
