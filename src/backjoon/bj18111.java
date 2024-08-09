package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111 {
	static int N, M, B;
	static int[][] map;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		B = Integer.parseInt(st.nextToken());
		int sum = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				sum += map[n][m];
			}
		}
		int avg = sum / (N * M);

		time = 0;
		// 추가로직을 쓸 때 B가 부족한지 테스트
		int testB = B;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				testB -= (avg + 1 - map[i][j]);
			}
		}

		// 만약 인벤토리 블럭수가 충분해? 그럼 avg+1만큼에 맞춰 // 부족해?? 그럼 avg에 맞춰
		if (testB >= 0) {
			int case1 = 0;	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > avg) {
						int removeBlock = map[i][j] - avg;
						case1 += (removeBlock * 2);
					} else if (map[i][j] < avg) {
						int addBlock = avg - map[i][j];
						case1 += addBlock;
					}
				}
			}
			int case2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > (avg+1)) {
						int removeBlock = map[i][j] - (avg+1);
						case2 += (removeBlock * 2);
					} else if (map[i][j] < (avg+1)) {
						int addBlock = (avg+1) - map[i][j];
						case2 += addBlock;
					}
				}
			}
			time = Math.min(case1, case2);
			if(time == case2) {
				avg+=1;
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > avg) {
						int removeBlock = map[i][j] - avg;
						time += (removeBlock * 2);
					} else if (map[i][j] < avg) {
						int addBlock = avg - map[i][j];
						time += addBlock;
					}
				}
			}
			
		}
		
		System.out.println(time + " " + avg);
	}

}
