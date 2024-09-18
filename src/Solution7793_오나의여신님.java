import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7793_오나의여신님 {
	static int T, N, M;
	static int[] SY, GOD;
	static List<int[]> devil ;
	static int[][] map;
	static boolean[][] DevilV;
	static boolean[][] SYV;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			devil = new ArrayList<>();
			map = new int[N][M];
			SYV = new boolean[N][M];
			DevilV = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					int n = 0;
					if (input.charAt(j) == 'D') {
						n = 2; // 여신
						GOD = new int[] { i, j };
					} else if (input.charAt(j) == 'S') {
						n = 1; // 수연
						SY = new int[] { i, j };
					} else if (input.charAt(j) == '*') {
						n = -1; // 악마의 손;
						devil.add(new int[] { i, j });
					} else if (input.charAt(j) == 'X') {
						n = 3; // 돌
					}
					map[i][j] = n;
				}
			}

			int res = bfs();
			if (res == -1) {
				sb.append("GAME OVER");
			} else {
				sb.append(res);
			}
			System.out.println(sb.toString());
		}

	}

	private static int bfs() {
		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> move = new LinkedList<>();

		int time = 0;
		for (int i = 0; i < devil.size(); i++) {
			int[] dev = devil.get(i);
			
			fire.offer(new int[] {dev[0],dev[1]});
			DevilV[dev[0]][dev[1]] = true;
		}

		move.offer(SY);
		SYV[SY[0]][SY[1]] = true;

		while (!fire.isEmpty() || !move.isEmpty()) {

			int fireSize = fire.size();
			int moveSize = move.size();
			
			for (int i = 0; i < fireSize; i++) {
				int[] cur = fire.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (DevilV[nr][nc])
						continue;
					if(map[nr][nc]== 3 || map[nr][nc]== 2)continue;
					if (map[nr][nc] == 0 || map[nr][nc] == 1) {
						map[nr][nc] = -1;
						fire.offer(new int[] { nr, nc });
						DevilV[nr][nc] = true;
					}
				}
			}
			for (int i = 0; i < moveSize; i++) {
				int[] cur = move.poll();
				if (map[cur[0]][cur[1]] == 2) {
					return time;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr, nc))
						continue;
					if (SYV[nr][nc])
						continue;
					if(map[nr][nc]== 3)continue;
					if (map[nr][nc] == 0 || map[nr][nc] == 2) {
						move.offer(new int[] { nr, nc });
						SYV[nr][nc] = true;
					}
				}
			}
			
			time++;
//			System.out.println("-------------"+time+"-------------");
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("----------------------");
		}
		return -1;
	}

	private static boolean check(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
