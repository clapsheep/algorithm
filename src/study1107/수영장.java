package study1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영장 {
	static int N, M;
	static long[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[N][M];
		map = new long[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long res=0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if(v[i][j])continue;
				res+=bfs(i, j);
			}
		}
		System.out.println(res);
	}

	// 1. 모든 칸을 탐색
	// 2. 해당 칸에서 bfs 실행
	// 	bfs-1.4방 탐색해서 자신보다 높으면 그중 가장 낮은 것을 level에 담음
	//  bfs-2.4밤 탐색해서 자신보다 낮으면 
	private static long bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] localV = new boolean[N][M]; 
		q.offer(new int[] { i, j });
		localV[i][j] = true;
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {i,j});
		long startHeight = map[i][j];
		long level = 100000;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (localV[nr][nc])
					continue;
				if (map[nr][nc] <= startHeight) { // 시작보다 작거나 같을 때,
					if (nr == 0 || nc == 0 || nr == N - 1 || nc == M - 1) { // 가장자리에 닿으면 물이 빠지므로 계산할 필요 없음
						return 0; 
					} // 가장자리가 아니라면
					list.add(new int[] {nr,nc});
					q.offer(new int[] {nr,nc});
					localV[nr][nc] = true;
				}else { // 현재보다 높을 때, 막힌 곳 중 가장 낮은 곳 찾기
					level = Math.min(level, map[nr][nc]);
				}
				
			}
		}
		int water =0;
		for (int[] l : list) {
			long temp =level-map[l[0]][l[1]];
			v[l[0]][l[1]] = true;
			if(temp > 0) {
			water += temp; 
			}
		}
		return water;

	}

}
