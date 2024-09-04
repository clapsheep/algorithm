package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj15686_치킨배달 {
	static int N, M, homeCount, chickenCount, res;
	static int[][] map;
	static List<int[]> HS, CK;
	static boolean[] v;
	static int[][] alive;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HS = new ArrayList<>();
		CK = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 1)
					HS.add(new int[] { i, j });
				if (input == 2)
					CK.add(new int[] { i, j });
			}
		}
	
		alive = new int[M][2];
		homeCount = HS.size();
		chickenCount = CK.size();
		v = new boolean[chickenCount];
		res = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(res);
	}

	private static void dfs(int cnt, int start) {
		if (cnt == M) {
			int index = 0;
			for (int i = 0; i < chickenCount; i++) {
				if (v[i]) {
					alive[index++] = CK.get(i);
				}
			}
			
			// 살아 남은 치킨집의 배열(alive)를 가지고 가장 가까운 집을 탐색해서 거리를 더한 후 최소값 비교;
			int chikenLength = 0;
			for (int i = 0; i < homeCount; i++) {
				chikenLength += calcMin(i, alive);
			}
			res = Math.min(res, chikenLength);
			return;
		}
		for (int i = start; i < chickenCount; i++) {
			if (v[i])
				continue;
			v[i] = true;
			dfs(cnt + 1, i);
			v[i] = false;
		}

	}

	private static int calcMin(int homeIndex, int[][] ckList) {
		int[] homeAdress = HS.get(homeIndex);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			int length = Math.abs(homeAdress[0] - ckList[i][0]) + Math.abs(homeAdress[1] - ckList[i][1]);
			min = Math.min(min, length);
		}
		return min;
	}

}
