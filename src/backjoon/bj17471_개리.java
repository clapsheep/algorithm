package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17471_개리 {
	static int N;
	static int[] people;
	static int[][] map;
	static boolean[] team;
	static boolean[] bfsv;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		map = new int[N][N];
		team = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				int c = Integer.parseInt(st.nextToken());
				map[r][c - 1] = 1;
				map[c - 1][r] = 1;
			}
		}
		min = 100000;
		subset(0);
		System.out.println(min==100000?-1:min);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			int res = confirm(team);
			min = Math.min(min, res);
			return;
		}
		team[cnt] = true;
		subset(cnt + 1);
		team[cnt] = false;
		subset(cnt + 1);

	}

	private static int confirm(boolean[] t) {
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (t[i])
				teamA.add(i);
			else
				teamB.add(i);
		}
		bfsv = new boolean[N];
		if(teamA.size()!=0) {
			bfsA(teamA.get(0), t);
		}
		if(teamB.size()!=0) {			
			bfsB(teamB.get(0), t);
		}
		for (int i = 0; i < N; i++) {
			if(!bfsv[i]) return min;
		}
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N; i++) {
			if(t[i]) sumA += people[i];
			else sumB += people[i];
		}

		return Math.abs(sumA-sumB);

	}

	static void bfsB(int num, boolean[] t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		bfsv[num] = true;
		while (!q.isEmpty()) {
			int start = q.poll();
			for (int end = 0; end < N; end++) {
				if (t[end])
					continue;
				if (bfsv[end])
					continue;
				if (map[start][end] == 1) {
					q.offer(end);
					bfsv[end] = true;
				}
			}
		}

	}

	private static void bfsA(int num, boolean[] t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		bfsv[num] = true;
		while (!q.isEmpty()) {
			int start = q.poll();
			for (int end = 0; end < N; end++) {
				if (!t[end])
					continue;
				if (bfsv[end])
					continue;
				if (map[start][end] == 1) {
					q.offer(end);
					bfsv[end] = true;
				}
			}
		}

	}

}
