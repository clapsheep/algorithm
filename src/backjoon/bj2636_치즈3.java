package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636_치즈3 {

	static int N, M; // 세로, 가로 넓이
	static int[][] map; // 
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cheeseCount = 0; // 치즈의 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 맵생

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeseCount++; // 치즈의 총 갯수 파
			}
		}

		System.out.println(meltCheese());
	}

	static int meltCheese() {
		int time = 0; // 시
		while (cheeseCount > 0) { // 치즈가 0개가 될 때까 bfs 돌림
			time++; // 1루프당 시간 1씩 증가
			boolean[][] visited = new boolean[N][M]; // 방문 배열
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { 0, 0 }); // 0,0부터 시작
			visited[0][0] = true;

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = current[0] + dr[d];
					int nc = current[1] + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
						continue; // 맵밖을 나갔거나, 방문했으면 건너뜀

					if (map[nr][nc] == 0) { // 공기이면 bfs 계속 진
						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					} else { // 아니면 (치즈면 각 칸의 카운트 증가)
						map[nr][nc]++; 
					}
				}
			}

			for (int i = 0; i < N; i++) { 
				for (int j = 0; j < M; j++) {
					if (map[i][j] >= 3) { // 공기를 기준으로 delta에 의해 치즈 카운트가 올라갔다면?
						// 본인칸 1 + 델타에 의한 값 2를 더한 3이상이면 녹을 치
						map[i][j] = 0; // 녹았으니 치즈는 이제 0
						cheeseCount--; // 전체 치즈 카운트 -1
					} else if (map[i][j] == 2) { // 녹을 치즈가 아니었다
						map[i][j] = 1; // 다시 치즈카운트 원상 복구
					}
				}
			}
		}
		return time;
	}
}