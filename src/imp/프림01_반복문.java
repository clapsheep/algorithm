package imp;
import java.util.Arrays;
import java.util.Scanner;

public class 프림01_반복문 {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();
		// 인접 행렬 방식
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a][b] = adj[b][a] = w;

		}

		boolean[] v = new boolean[V]; // 방문 췍~!
		int[] p = new int[V]; // 필요하지 않다면 하지 않아도 됌
		int[] dist = new int[V];
		int res = 0;

		// 프림 제 1장 : 초기화
		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
		// 프림 제 2장 : 시작 정점 결정
		dist[0] = 0;
		// 프림 제 3장 : 가중치 배열을 돌면서 가장 값이 낮은 것을 골라 방문췍 / 갱신
		for (int i = 0; i < V; i++) { // V번 돌아도 괜찮음
			// 방문하지 않았으면서 가장 작은 값 가져와
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!v[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
					
				}
			} // idx는 가장 작은 값을 가지고 있는 정점\
			v[idx] = true;
			
			
			// 방문하지 않았고 갱신할 수 있으면 갱신해
			for (int j = 0; j < V; j++) {
				if (!v[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
					// if문 조건 설명 : 방문한 적 없고 선택한 정점과 연결된 것을 찾는다. 그리고 갱신이 필요한 녀석을 선택한다.
					dist[j] = adj[idx][j];
					p[j] = idx;
				}
			}
		}
		for (int j = 0; j < V; j++) {
			res += dist[j];
		}
		System.out.println(res);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
