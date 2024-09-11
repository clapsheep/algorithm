import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8382_방향전환_BFS {
	static int T, r, c;
	static int N = 201;
	static boolean[][][] v;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static class Point{
		int r,c,dir,dist;
		public Point(int r, int c,int dir,int dist){
			this.r=r;
			this.c=c;
			this.dir=dir;
			this.dist=dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			r = Math.abs(x1 - x2);
			c = Math.abs(y1 - y2);
			v = new boolean[N][N][2];
			int res = bfs();
			sb.append(res);
			System.out.println(sb.toString());
		}

	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point( 0, 0, 0, 0 )); 
		q.offer(new Point ( 0, 0, 1, 0 ));
		v[0][0][0] = true;
		v[0][0][1] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.r == r && cur.c == c) {
				return cur.dist;
			}

			for (int d = cur.dir; d < 4; d += 2) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (!check(nr, nc))
					continue;
				if (v[nr][nc][cur.dir])
					continue;
				v[nr][nc][cur.dir] = true;
				q.offer(new Point ( nr, nc, 1-cur.dir, cur.dist+1));
			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
