package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468_안전영역 {
	static int N, mark;
	static int[][] map, temp;
	static int low, high, rain, res;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		temp = new int[N][N];
		low = 101;
		high = -1;
		res = -1;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				temp[i][j] = input; // 원복을 위한 임시 맵
				low = Math.min(low, input); // 제일 낮은 건물을 찾아
				high = Math.max(high, input); // 제일 높은 건물을 찾아
			}
		}
		

		for (int rain = low-1; rain < high; rain++) {// 제일 낮은 높이 -1부터 (비오지 않는 경우)
			// 비가 오는걸 건물을 한칸씩 낮추는 것으로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] -= rain; // bfs끝나고 map 다시 원복할거
					if(map[i][j]<0)map[i][j] = 0;
				}
			}

			

			mark = 100;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						if (map[i][j] < 101) {
							++mark;
							bfs(i, j);
						}
					}
				}
			}

			
			
			res = Math.max(res,mark-100);
			
			for (int i = 0; i < N; i++) { // 맵 초기화
				System.arraycopy(temp[i], 0, map[i], 0, N);
			}
		}
		System.out.println(res);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		map[sr][sc] = mark;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if(map[nr][nc]==0)continue;
				if(map[nr][nc]<=100) {
					q.offer(new int[] { nr, nc });
					map[nr][nc] = mark;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
