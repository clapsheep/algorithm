package study1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2580_스도쿠 {
	static int[][] map;
	static List<int[]> empty;
	static int size;
	static boolean isFind;

	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		empty = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					empty.add(new int[] { i, j });
				}
			}
		}
		size = empty.size();
		isFind= false;
		dfs(0);
	}

	private static void dfs(int cnt) {
		if(isFind)return;
		if (cnt == size) {
			isFind=true;
			StringBuilder sb= new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			return;
		}
		int[] cur = empty.get(cnt);
		for (int i = 1; i <= 9; i++) {
			if(!isValid(cur, i))continue; 
				map[cur[0]][cur[1]] = i;
				dfs(cnt+1);
				map[cur[0]][cur[1]] = 0;
		}

	}

	private static boolean isValid(int[] cur, int i) {
		int r = cur[0];
		int c = cur[1];
		for (int j = 0; j < 9; j++) {
			if(map[j][c] == i)
				return false;
		}
		for (int j = 0; j < 9; j++) {
			if(map[r][j] == i)
				return false;
		}
		int boxR = r-r%3;
		int boxC = c-c%3;
		for (int j = boxR; j < boxR+3; j++) {
			for (int k = boxC; k < boxC+3; k++) {
				if(map[j][k]==i)
					return false;
			}
		}
		return true;
	}

}
