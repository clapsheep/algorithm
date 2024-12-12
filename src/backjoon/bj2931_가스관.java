package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2931_가스관 {
	static int R, C;
	static char[][] map;
	static int userDir;
	static int[] now;
	static int[] end;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static char nextPipe;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String input = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == 'M') {
					now = new int[] { r, c };
				} else if (map[r][c] == 'Z') {
					end = new int[] { r, c };
				}
			}
		}

		setFirstDir();
		bfs(now[0], now[1]);
		sb.append(now[0] + 1).append(" ").append(now[1] + 1).append(" ");
		setNextPipe();
		sb.append(nextPipe);
		System.out.println(sb.toString());

	}

	private static void setNextPipe() {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			if (Math.abs(d - userDir) == 2)
				continue; // 자신이 온 방향 빼고 생각하기
			int nr = now[0] + dr[d];
			int nc = now[1] + dc[d];
			if (!check(nr, nc))
				continue;
			char pipe = map[nr][nc];
			if (pipe != '.') {
				if (d == 0) {
					if (pipe == '-' || pipe == '+' || pipe == '3' || pipe == '4') {
						if(userDir == 0) {
							nextPipe = '-';
						}else if(userDir ==1) {
							nextPipe = '2';
						}else if(userDir == 3) {
							nextPipe = '1';
						}
					}else continue;
				} else if (d == 1) {
					if (pipe == '|' || pipe == '+' || pipe == '2' || pipe == '3') {
						if(userDir == 0) {
							nextPipe = '4';
						}else if(userDir ==1) {
							nextPipe = '|';
						}else if(userDir == 2) {
							nextPipe = '1';
						}
					}else continue;

				} else if (d == 2) {
					if(pipe== '-' || pipe == '+'  || pipe == '1' || pipe == '2') {
						if(userDir == 1) {
							nextPipe = '3';
						}else if(userDir ==2) {
							nextPipe = '-';
						}else if(userDir == 3) {
							nextPipe = '4';
						}
					}else continue;
				} else { // d== 3
					if(pipe== '|' || pipe == '+'  || pipe == '1' || pipe == '4') {
						if(userDir == 0) {
							nextPipe = '3';
						}else if(userDir ==2) {
							nextPipe = '2';
						}else if(userDir == 3) {
							nextPipe = '|';
						}
					}else continue;
				}
				cnt++;
			}

		}
		if (cnt == 3) {
			nextPipe = '+';
		}

	}

	private static void setFirstDir() {
		for (int d = 0; d < 4; d++) {
			int nr = now[0] + dr[d];
			int nc = now[1] + dc[d];
			if (!check(nr, nc))
				continue;
			char pipe = map[nr][nc];
			if (pipe != '.') {
				now = new int[] { nr, nc };
				switch (d) {
				case 0: {
					if (pipe == '-' || pipe == '+' || pipe == '3' || pipe == '4') {
						if (pipe == '-' || pipe == '+') {
							userDir = 0;
						} else if (pipe == '3') {
							userDir = 3;
						} else {
							userDir = 1;
						}

					}
					return;
				}
				case 1: {
					if (pipe == '|' || pipe == '+' || pipe == '2' || pipe == '3') {
						if (pipe == '|' || pipe == '+') {
							userDir = 1;
						} else if (pipe == '2') {
							userDir = 0;
						} else {
							userDir = 2;
						}

					}
					return;
				}
				case 2: {
					if (pipe == '-' || pipe == '+' || pipe == '1' || pipe == '2') {
						if (pipe == '-' || pipe == '+') {
							userDir = 2;
						} else if (pipe == '1') {
							userDir = 1;
						} else {
							userDir = 3;
						}

					}
					return;
				}
				case 3: {
					if (pipe == '|' || pipe == '+' || pipe == '1' || pipe == '4') {
						if (pipe == '|' || pipe == '+') {
							userDir = 3;
						} else if (pipe == '1') {
							userDir = 0;
						} else {
							userDir = 2;
						}

					}
					return;
				}

				}
			}
		}

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (map[cur[0]][cur[1]] == '.') {
				now = new int[] { cur[0], cur[1] };
				return;
			}

			int nr = cur[0] + dr[userDir];
			int nc = cur[1] + dc[userDir];

			char np = map[nr][nc];
			if (np == '1') {
				if (userDir == 2) {
					userDir = 1;
				} else {// 3
					userDir = 0;
				}
			} else if (np == '2') {
				if (userDir == 1) {
					userDir = 0;
				} else {// 2
					userDir = 3;
				}
			} else if (np == '3') {
				if (userDir == 0) {
					userDir = 3;
				} else {// 1
					userDir = 2;
				}
			} else if (np == '4') {
				if (userDir == 0) {
					userDir = 1;
				} else {// 3
					userDir = 2;
				}
			}
			q.offer(new int[] { nr, nc });
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
