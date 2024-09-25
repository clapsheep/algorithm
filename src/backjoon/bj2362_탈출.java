package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2362_탈출 {
	static int N, K;
	static char[][] map;
	static List<int[]> land, prisoner, door;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		land = new ArrayList<>();
		prisoner = new ArrayList<>();
		door = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] input = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];
				if (map[i][j] == '.') {
					land.add(new int[] { i, j });
				} else if (map[i][j] == 'X') {
					prisoner.add(new int[] { i, j });
				} else if (map[i][j] == 'O') {
					door.add(new int[] { i, j });
				}
			}
		}
		
		dfs(0);
	}

	private static void dfs(int cnt) {
		
		
	}

}
