package study0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj16954_움직이는미로탈출 {
	static int N = 8;
	static int[][] map;
	static int[] dr = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 0, 1, 1, 0, -1, -1, -1, 0, 1 };
	static List<int[]> walls;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		
		walls = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char cur = input.charAt(j);
				if (cur == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = -1;
					walls.add(new int[] { i, j });
				}
			}
		}
		int res = bfs();
		System.out.println(res);
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited;
		q.offer(new int[] {7,0});
		while (!q.isEmpty()) {
			int size = q.size();
			visited  = new boolean[N][N];
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (cur[0] == 0 && cur[1] == 7)
					return 1;
				if(!checkWall(cur[0],cur[1]))continue;
				
				for (int d = 0; d < 9; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc)) // 범위 나가는지 체크
						continue;
					if(visited[nr][nc]) continue;
					if (!checkWall(nr, nc)) // 벽으로 갔는지 체크;
						continue;
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}

			}
			moveWall();
			
		}
		return 0;
	}

	private static void moveWall() {
		for (int[] w : walls) {
			w[0]++;
		}
		
	}

	private static boolean checkWall(int r, int c) {
		for (int[] w : walls) {
			if (w[0] == r && w[1] == c) {
				return false;
			}
		}
		return true;
	}

	private static boolean check(int r, int c) {
		return r < N && c < N && r >= 0 && c >= 0;
	}

}
