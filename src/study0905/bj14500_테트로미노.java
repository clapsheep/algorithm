package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14500_테트로미노 {
	static int N, M;
	static int[][] map;
	static int max;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				searchFourDir(i, j, map[i][j], 1);
				v[i][j] = false;
				checkSpecialShape(i, j);
			}
		}
		System.out.println(max);

	}

	// 모양에 대한 케이스가 총 14가지인데 이거 다 빡구현하기에는 너무 말이 안된다고 생각.
	// 생각해보면 지금 있는 위치에서 4방 탐색 -> 내가 간 위치에서 또 4방탐색 이렇게 cnt가 4가 되면 max와 비교
	// 근데 여기서 확인할 수 없는 케이스가 ㅗ,ㅓ,ㅏ,ㅜ 모양.
	// 그래서 저 모양은 따로 확인하는 전략
	// 남은 칸에 대해 최대로 나올 수 있는 수를 더했는데도 max보다 작다면 가지치기를 하면 어떨까? 492ms->284ms 성
	static void searchFourDir(int r, int c, int sum, int cnt) {
		if(sum+(4-cnt)*1000<=max) return;
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc])
				continue;
			v[nr][nc] = true;
			searchFourDir(nr, nc, sum + map[nr][nc], cnt + 1);
			v[nr][nc] = false;
		}

	}
	// ㅗ,ㅓ,ㅏ,ㅜ 모양.
	// 현재위치를 기준으로 4방을 다 더한 후 4방중 최소값을 뺌.
	static void checkSpecialShape(int r, int c) {
	    int sum = map[r][c];
	    int count = 0;
	    int min = 100000;
	    
	    for (int i = 0; i < 4; i++) {
	        int nr = r + dr[i];
	        int nc = c + dc[i];
	        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
	            sum += map[nr][nc];
	            min = Math.min(min, map[nr][nc]);
	            count++;
	        }
	    }
	    
	    if (count == 3) { // 갈 수 있는 곳이 3방향 밖에 없으면?
	        max = Math.max(max, sum);
	    } else if (count == 4) { // 4방향 모두 가능하면?
	        max = Math.max(max, sum - min);
	    }
	}
}
