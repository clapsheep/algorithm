package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10157_자리배정 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];

		int num = Integer.parseInt(br.readLine());
		int cnt = 0, r = 0, c = 0, d = 0;
		
		if(R*C < num) {
			System.out.println("0");
			return;
		}
		
		while (true) {
			arr[r][c] = ++cnt;
			if(cnt == num) {
				break;
			}
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] != 0) {
				d = (d + 1) % 4;
			}
			
			r += dr[d];
			c += dc[d];
		}
		System.out.printf("%d %d", r+1, c+1);

	}
}
