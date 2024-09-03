package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj11724_연결요소의개수 {
	static int N, M;
	static List<Integer>[] adj;
	static int count;
	static int[] ver;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ver = new int[N];
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj[a].add(b);
			adj[b].add(a);
		}

		count = 1;
		for (int i = 0; i < N; i++) {
			if (ver[i] == 0) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count-1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		ver[start] = count;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int w : adj[curr]) {
				if (ver[w] != 0)
					continue;
				q.offer(w);
				ver[w] = count;
			}
		}

	}

}
