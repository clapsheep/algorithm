package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17471_게리맨더링 {
	static int N, res;
	static List<Integer>[] adj;
	static boolean[] v, visitedTeam;
	static int[] people;

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

		for (int i = 0; i <N; i++) { // 0-5구역 순서대로 연결 구역입력
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken()); // 몇개가 연결 되었는가
			for (int j = 0; j < e; j++) { // 연결된 구역들 입력
				int a = Integer.parseInt(st.nextToken()) - 1;
				adj[i].add(a);
				adj[a].add(i);
			}
		}

		res = 10000;
		v = new boolean[N];

		divide(0);
		System.out.println(res == 10000 ? -1 : res);
	}

	private static void divide(int cnt) {
		if (cnt == N) {
			int r = check(v);
			res = Math.min(res, r);
			return;
		}
		v[cnt] = true;
		divide(cnt + 1);
		v[cnt] = false;
		divide(cnt + 1);

	}

	private static int check(boolean[] team) {

		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (team[i]) { // A= true
				teamA.add(i);
			} else { // B = false
				teamB.add(i);
			}
		}
		visitedTeam = new boolean[N];
		if (teamA.size() != 0) { // 나눈 팀을 가지고 이어지는지 체크를 하자;
			bfsA(teamA.get(0),team);
		}
		if (teamB.size() != 0) {
			bfsB(teamB.get(0),team);
		}
		for (int i = 0; i < N; i++) {
			if (!visitedTeam[i])
				return res;
		}
		int A = 0, B = 0;
		for (int i = 0; i < N; i++) {
			if (v[i]) {
				A += people[i];
			} else {
				B += people[i];
			}
		}
		return Math.abs(A - B);
	}

	private static void bfsB(int start, boolean[] vis) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visitedTeam[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
		
			for (int end : adj[cur]) {
				if (vis[end])
					continue;
				if (visitedTeam[end])
					continue;
				q.offer(end);
				visitedTeam[end] = true;
			}
		}

	}

	private static void bfsA(int start, boolean[] vis) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(start);
		visitedTeam[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
	
			for (int end : adj[cur]) {
				if (!vis[end])
					continue;
				if (visitedTeam[end])
					continue;
				q.offer(end);
				visitedTeam[end] = true;
			}
		}

	}
}
