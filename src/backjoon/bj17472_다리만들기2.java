package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<int[]>[] island;

	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;

		}
	}

	static int[] p, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		island = new ArrayList[8];
		for (int i = 0; i < 8; i++) {
			island[i] = new ArrayList<>();
		}

		int mark = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					floodFill(i, j, ++mark);
				}
			}
		}
		p = new int[mark + 1];
		r = new int[mark + 1];

		for (int i = 2; i <= mark; i++) {
			p[i] = i;
			r[i] = 1;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

		for (int start = 2; start <= mark - 1; start++) {
			for (int end = start + 1; end <= mark; end++) {
				for (int[] pos : island[start]) {
					int dist = bridge(pos[0], pos[1], end);
					if (dist != Integer.MAX_VALUE) {
						pq.offer(new Edge(start, end, dist));
					}
				}
			}
		}
		int cnt = 1;
		int res = 0;
		while (!pq.isEmpty() && cnt != mark - 1) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				cnt++;
				res += cur.w;
			}

		}
		if(cnt == mark-1) {
		System.out.println(res);
		}else {
			System.out.println(-1);
		}
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}
		if (r[a] > r[b]) {
			r[a] += r[b];
			p[b] = a;
		} else {
			r[b] += r[a];
			p[a] = b;
		}
		return true;
	}

	private static int find(int v) {
		if (p[v] == v) {
			return v;
		} else {

			return p[v] = find(p[v]);
		}
	}

	private static int bridge(int r, int c, int end) {
		int res = Integer.MAX_VALUE;

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			int cnt = 0;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!check(nr, nc) || (map[nr][nc] != end && map[nr][nc] > 0)) {
					break;
				}
				if (map[nr][nc] == 0) {
					cnt++;
					continue;
				}
				if (map[nr][nc] == end) {
					if (cnt >= 2) {
						res = Math.min(res, cnt);
					}
					break;
				}
			}
		}
		return res;
	}

	private static void floodFill(int i, int j, int k) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		v[i][j] = true;
		map[i][j] = k;
		q.offer(new int[] { i, j });
		island[k].add(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc) || v[nr][nc])
					continue;
				if (map[nr][nc] == 1) {
					v[nr][nc] = true;
					map[nr][nc] = k;
					q.offer(new int[] { nr, nc });
					island[k].add(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean check(int r, int c) {

		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
