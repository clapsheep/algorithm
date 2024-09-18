import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution10966_물놀이를가자 {
	static int T, N, M ,res;
	static int[][] map;
	static boolean[][] v;
	static Queue<int[]> water;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	// 모든 물의 영역  확장되는 것을 동시에 처리해서 시간을 줄이는 것이 포인트
	// 가장 먼저 방문한 시점이 최단 거리인 것이 포인트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			water = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					if (input.charAt(j) == 'W') {
						water.offer(new int[] { i, j }); // 물의 좌표들을 Q에 넣고,
						v[i][j] = true; // 방문 표시 미리 해두기(물영역끼리 침범하지 않기 위함),
					}
				}
			}
			res = 0;
			bfs(water);

			sb.append(res);
			System.out.println(sb.toString());

		}
	}

	private static void bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] cur = q.poll(); // 물을 차례로 꺼내
			res+=map[cur[0]][cur[1]]; // 현재 좌표가 최단거리 
			for (int d = 0; d < 4; d++) { // 해당 물의 4방을 탐색
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc)) // 범위 밖인지 체크
					continue;
				if (v[nr][nc]) // 이미 방문했는지 체크
					continue;
				v[nr][nc] = true; // 방문 표시
				map[nr][nc] = map[cur[0]][cur[1]]+1; // 이전 칸보다 1증가
				q.offer(new int[] { nr, nc }); // 다음 칸으로 이동
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
