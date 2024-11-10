package study1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21609_상어중학교 {
	static int N, M, res;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;

	static class Group implements Comparable<Group> {
		List<int[]> pos = new ArrayList<>();
		int row, col, size, color, rainbow;

		public Group(List<int[]> pos, int row, int col, int size, int color, int rainbow) {
			this.pos = pos;
			this.row = row;
			this.col = col;
			this.size = size;
			this.color = color;
			this.rainbow = rainbow;
		}

		@Override
		public String toString() {
			return pos + " / row : " + row + " / col : " + col + " / size : " + size + " / color : " + color
					+ " / rainbow : " + rainbow;
		}

		@Override
		public int compareTo(Group o) {
			if (o.size != size) {
				return Integer.compare(o.size, size);
			} else {
				if (this.rainbow != o.rainbow) {
					return Integer.compare(o.rainbow, rainbow);
				} else {
					if (this.row != o.row) {
						return Integer.compare(o.row, row);
					} else {
						return Integer.compare(o.col, col);
					}
				}
			}
		}
	}

	static PriorityQueue<Group> gs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = 0;
		gs = new PriorityQueue<>();
		
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			while (true) {
				v=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && map[i][j] != 0 && map[i][j] != -2 && !v[i][j]) {
						bfs(i, j);
					}
				}
			}

			if(gs.isEmpty())break;
			Group cur = gs.poll();
			res += Math.pow(cur.size, 2);

			for (int[] pos : cur.pos) {
				map[pos[0]][pos[1]] = -2;
			}
			gravity();
			rotate();
			gravity();
			gs.clear();
		}
		System.out.println(res);
	}

	private static void rotate() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, N);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[N - 1 - j][i] = temp[i][j];
			}
		}
	}

	private static void gravity() {
		for (int r = N - 1; r >= 0; r--) {
			for (int c = N - 1; c >= 0; c--) {
				int temp = map[r][c];
				if (temp != -1) {
					int nr = r;
					while (true) {
						nr++;
						if (!check(nr, c)) {
							break;
						}
						if (map[nr][c] == -1) {
							break;
						}
						if (map[nr][c] == -2) {
							map[nr][c] = temp;
							map[nr - 1][c] = -2;
						} else {
							break;
						}
					}
				}

			}
		}

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] localV = new boolean[N][N];
		q.offer(new int[] { i, j });
		localV[i][j] = true;
		v[i][j] = true;
		int color = map[i][j];
		int rainbow = 0;
		int row = i;
		int col = j;
		int size = 0;
		List<int[]> pos = new ArrayList<>();
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			size++;
			if (map[cur[0]][cur[1]] == 0) {
				rainbow++;
			}
			pos.add(new int[] { cur[0], cur[1] });
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (localV[nr][nc])
					continue;
				if (map[nr][nc] == color || map[nr][nc] == 0) {
					localV[nr][nc] = true;
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
		if (size >= 2) {
			gs.offer(new Group(pos, row, col, size, color, rainbow));
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
