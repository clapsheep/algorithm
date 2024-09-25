import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16236_아기상어 {
	static class Shark {
		int r, c;
		int size = 2;
		int eat = 0;

		public Shark() {
		}
		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
	};
	static int N;
	static int[][] map;
	static int[] babyPos;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean[][] v;
	static List<int[]>[] fish;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		fish = new ArrayList[7];
		for (int i = 1; i < 7; i++) {
			fish[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					babyPos = new int[] { i, j };
				} else if (map[i][j] == 1) {
					fish[1].add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					fish[2].add(new int[] { i, j });
				} else if (map[i][j] == 3) {
					fish[3].add(new int[] { i, j });
				} else if (map[i][j] == 4) {
					fish[4].add(new int[] { i, j });
				} else if (map[i][j] == 5) {
					fish[5].add(new int[] { i, j });
				} else if (map[i][j] == 6) {
					fish[6].add(new int[] { i, j });
				}
			}
		}
		int res = bfs();
	}

	private static int bfs() {
		Queue<Shark> q = new LinkedList<>();
		q.offer(new Shark(babyPos[0], babyPos[1]));
		v[babyPos[0]][babyPos[1]] = true;
		int time = 0;
		while (!q.isEmpty()) {
			Shark cur = q.poll();
			int size = cur.size;
			for (int i = 1; i < size; i++) {
				for (int[] pos : fish[size]) {
					
				}
			}

		}
		return time;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
