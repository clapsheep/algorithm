package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17471_게리맨더링2 {
	static int N, min;
	static int[][] map;
	static int[] people;
	static List<Integer>[] adj;
	static boolean[] team, isConnect;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int a = 0; a < N; a++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			for (int i = 0; i < c; i++) {
				int b = Integer.parseInt(st.nextToken()) - 1;
				adj[a].add(b);
				adj[b].add(a);
			}
		}

		team = new boolean[N];
		min = 10000;
		setTeam(0);
		System.out.println(min == 10000 ? -1 : min);
	}

	private static void setTeam(int cnt) {
		if (cnt == N) {
			int res = checkAndCalc(team);
			min = Math.min(res, min);
			return;
		}
		team[cnt] = true;
		setTeam(cnt + 1);
		team[cnt] = false;
		setTeam(cnt + 1);
	}

	private static int checkAndCalc(boolean[] t) {
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (t[i])
				A.add(i);
			else
				B.add(i);
		}
		isConnect = new boolean[N];
		if (A.size() != 0) {
			checkA(A.get(0),t);
		}
		if (B.size() != 0) {
			checkB(B.get(0),t);
		}
		for (int i = 0; i < N; i++) {
			if(!isConnect[i])return min;
		}
		int sumA = 0, sumB = 0;
		for (int i = 0; i < N; i++) {
			if(t[i])sumA+=people[i];
			else sumB+=people[i];
		}
		return Math.abs(sumA-sumB);
	}

	private static void checkB(int s, boolean[] t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		isConnect[s] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int e: adj[cur]) {
				if(team[e])continue;
				if(isConnect[e])continue;
				q.offer(e);
				isConnect[e] = true;
			}
		}
	}

	private static void checkA(int s, boolean[] t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		isConnect[s] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int e: adj[cur]) {
				if(!team[e])continue;
				if(isConnect[e])continue;
				q.offer(e);
				isConnect[e] = true;
			}
		}
		
	}

}
