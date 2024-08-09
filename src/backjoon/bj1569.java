package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1569 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[2001];
		int[] y = new int[2001];
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int yIdx = Integer.parseInt(st.nextToken()) + 2000;
			int xIdx = Integer.parseInt(st.nextToken()) + 2000;
			y[yIdx] = 1;
			x[xIdx] = 1;
			
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
		for (int i = 0; i < 2001; i++) {
			if(x[i] == 1) {
				
			}
		}
		for (int j = 0; j < 2001; j++) {
			
		}
		
	}

}
