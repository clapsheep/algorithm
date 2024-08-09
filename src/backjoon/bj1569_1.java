package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1569_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int [2001][2001];
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int yIdx = Integer.parseInt(st.nextToken()) + 1000;
			int xIdx = Integer.parseInt(st.nextToken()) + 1000;
			map[yIdx][xIdx] = 1;
			
			maxX = Math.max(maxX, xIdx);
			maxY = Math.max(maxY, yIdx);
			minX = Math.min(minX, xIdx);
			minY = Math.min(minY, yIdx);
		}
		if(maxX-minX != maxY-minY) {
			System.out.println(-1);
			return;
		}
		int position = maxX-minX;
		int cnt = 0;
		cnt += map[minY][minX];
		cnt += map[minY][maxX];
		cnt += map[maxY][minX];
		cnt += map[maxY][maxX];
		
		for (int y = minY+1; y < position+minY; y++) {
			cnt+= map[y][position+minX];
		}
		for (int y = minY+1; y < position+minY; y++) {
			cnt+= map[y][minX];
		}
		for (int x = minX+1; x < position+minX; x++) {
			cnt+= map[position+minY][x];
		}
		for (int x = minX+1; x < position+minX; x++) {
			cnt+= map[minY][x];
		}
		
		if(cnt == N) {
			System.out.println(position);
		}else {
			System.out.println(-1);
		}
	}

}
