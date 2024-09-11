package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16928_뱀과사다리게임 {
	static int N, M, res;
	static int[] map = new int[100];
	static boolean[] v = new boolean[100];
	static int[] ladder;
	static int[] snake;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ladder = new int[100];
		snake = new int[100];

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ladder[s - 1] = e - 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			snake[s - 1] = e - 1;
		}
		int res = 10100000;
		dfs(0,0);
		System.out.println(res);
		
	}

	private static void dfs(int cur, int sum) {
		if(sum>res)return;
		if(cur == 99) {
			res= Math.min(res, sum);
			return;
		}
		for (int i = 1; i <= 6; i++) {
			int next = cur+i;
			if (next > 99)
				continue;
			if (v[next])
				continue;
			if(ladder[next]!=0) {
				v[ladder[next]] = true;
				dfs(ladder[next], sum+1);
				v[ladder[next]] = false;
			}else if(snake[next]!=0){
				v[snake[next]] = true;
				dfs(snake[next], sum+1);
				v[snake[next]] = false;
			}else{
				v[next] = true;
				dfs(cur+1,sum+1);
				v[next] = false;
			}
			
		}
		
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		v[0] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 99)
				return cnt;
			cnt++;
			for (int i = 1; i <= 6; i++) {
				int next = cur + i;
				if (next > 99)
					continue;
				if (v[next])
					continue;
				if (ladder[next] != 0) {
					q.add(ladder[next]);
					v[ladder[next]] = true;
				} else if (snake[next] != 0) {
					q.add(snake[next]);
					v[snake[next]] = true;
				} else {
					q.add(next);
					v[next] = true;
				}
			}

		}
		return -1;
	}

}
