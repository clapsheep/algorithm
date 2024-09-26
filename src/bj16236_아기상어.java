import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	};

	static class Fish {
		int r, c;
		int size;

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + "]";
		}

		public Fish(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

	static int N, remain;
	static int[][] map;
	static Shark bs;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static List<Fish> fishes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fishes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bs = new Shark(i, j);
					map[i][j] = 0;
				} else if (map[i][j] != 0) {
					fishes.add(new Fish(i, j, map[i][j]));
				}
			}
		}

		int res = 0;

		while (true) {
			Fish nearestFish = null;
			int minDist = Integer.MAX_VALUE;

			for (int j = 0; j < fishes.size(); j++) {
				Fish cur = fishes.get(j);
				if (cur.size >= bs.size)
					continue;
				int temp = bfs(new int[] { cur.r, cur.c });
				if (temp == 1000) {
					continue;
				}

				if (temp < minDist) {
					minDist = temp;
					nearestFish = cur;
				} else if (temp == minDist) {
					if (cur.r < nearestFish.r) {
						nearestFish = cur;
					} else if (cur.r == nearestFish.r) {
						if (cur.c < nearestFish.c) {
							nearestFish = cur;
						}
					}
				}
			}

			if (nearestFish == null)
				break;

			fishes.remove(nearestFish);
			map[nearestFish.r][nearestFish.c] = 0;
			bs.r = nearestFish.r;
			bs.c = nearestFish.c;
			bs.eat++;
			if (bs.eat == bs.size) {
				bs.size++;
				bs.eat = 0;
			}

			res += minDist;
		}
		System.out.println(res);
	}

	private static int bfs(int[] pos) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		q.offer(new int[] { bs.r, bs.c, 0 }); // r, c, distance
		v[bs.r][bs.c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1], dist = cur[2];

			if (r == pos[0] && c == pos[1]) {
				return dist; // 목표 지점에 도달하면 즉시 거리 반환
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc) || v[nr][nc] || map[nr][nc] > bs.size)
					continue;
				v[nr][nc] = true;
				q.offer(new int[] { nr, nc, dist + 1 });
			}
		}
		return 1000; // 도달할 수 없는 경우
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
