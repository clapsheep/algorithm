package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17471_게리맨더링3 {
	static int N, min;
	static int[] people;
	static List<Integer>[] adj;
	static boolean[] team, check;

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
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int c = Integer.parseInt(st.nextToken()) - 1;
				adj[r].add(c);
				adj[c].add(r);
			}
		}
		min = 10000;
		team = new boolean[N];
		setTeam(0);
		System.out.println(min==10000?-1:min);
	}

	private static void setTeam(int cnt) {
		if (cnt == N) {
			int res = calc(team);
			min = Math.min(res, min);
			return;
		}
		team[cnt] = true;
		setTeam(cnt + 1);
		team[cnt] = false;
		setTeam(cnt + 1);
	}

	private static int calc(boolean[] t) {
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (t[i])
				teamA.add(i);
			else
				teamB.add(i);
		}
		check = new boolean[N];
		if (teamA.size() != 0) {
			bfsA(teamA.get(0),check);
		}
		if (teamB.size() != 0) {
			bfsB(teamB.get(0),check);
		}
		for (int i = 0; i < N; i++) {
			if(!check[i])return min; 
		}
		int sumA = 0, sumB=0;
		for (int i = 0; i < N; i++) {
			if(team[i])sumA+=people[i];
			else sumB+=people[i];
		}
		return Math.abs(sumA-sumB);
	}

	private static void bfsB(int s, boolean[] v) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(s);
		v[s] = true;
		while(!q.isEmpty()) {
			int cur= q.poll();
			for (int w : adj[cur]) {
				if(v[w])continue;
				if(team[w])continue;
				q.offer(w);
				v[w] = true;
			}	
		}
	}

	private static void bfsA(int s, boolean[] v) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(s);
		v[s] = true;
		while(!q.isEmpty()) {
			int cur= q.poll();
			for (int w : adj[cur]) {
				if(v[w])continue;
				if(!team[w])continue;
				q.offer(w);
				v[w] = true;
			}
		}
	}

}
