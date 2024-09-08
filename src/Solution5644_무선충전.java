import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {
	static int T, M, C, sum;
	static int N = 10;
	static List<Integer> A, B;
	static int[][] map = new int[N][N];
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static List<int[]>[] batteries;
	static int[] power;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동할 시간
			C = Integer.parseInt(st.nextToken()); // 배터리 개수
			A = new ArrayList<>();
			B = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A.add(Integer.parseInt(st.nextToken())); // A의 이동 경로
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B.add(Integer.parseInt(st.nextToken())); // B의 이동 경로
			}
			batteries = new ArrayList[C];
			for (int i = 0; i < C; i++) {
				batteries[i] = new ArrayList<>();
			}
			power = new int[C];
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()) - 1; // 현재 입력받은 배터리의 r
				int c = Integer.parseInt(st.nextToken()) - 1; // 현재 입력받은 배터리의 c
				int range = Integer.parseInt(st.nextToken()); // 현재 입력받은 배터리의 범위
				power[i] = Integer.parseInt(st.nextToken()); // 현재 입력받은 배터리의 파워
				for (int j = 0; j < N; j++) { // 배터리 범위 좌표 추가
					for (int l = 0; l < N; l++) {
						int distr = Math.abs(r - j);
						int distc = Math.abs(c - l);
						if (distr + distc <= range) {
							batteries[i].add(new int[] { l, j });
						}
					}
				}
			}
			int rA = 0;
			int cA = 0;
			int rB = 9;
			int cB = 9;
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += calc(rA, cA, rB, cB);

				int dirA = A.get(i);
				int dirB = B.get(i);

				rA = rA + dr[dirA];
				cA = cA + dc[dirA];
				rB = rB + dr[dirB];
				cB = cB + dc[dirB];
			}
			sum += calc(rA, cA, rB, cB);
			System.out.println(sum);
		}
	}

	private static int calc(int rA, int cA, int rB, int cB) {
		int sum = 0;
		PriorityQueue<Integer> chargeA = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> chargeB = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < C; i++) { // 각 배터리 조회
			int loop = batteries[i].size(); // 해당 배터리가 가진 모든 좌표
			for (int j = 0; j < loop; j++) {
				if (batteries[i].get(j)[0] == rA && batteries[i].get(j)[1] == cA) {
					chargeA.offer(power[i]);
				}
				if (batteries[i].get(j)[0] == rB && batteries[i].get(j)[1] == cB) {
					chargeB.offer(power[i]);
				}
			}
		}

		int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
		if (!chargeA.isEmpty()) {
			a1 = chargeA.poll(); // A가 있는 곳 중 가장 큰 파워
		} 
		if (!chargeB.isEmpty()) {
			b1 = chargeB.poll();  // B가 있는 곳 중 가장 큰 파워
		}
		if (!chargeA.isEmpty()) {
			a2 = chargeA.poll(); // A가 있는 곳 중 두번째 큰 파워(겹친 곳이 없으면 0이겠지?)
		}
		if (!chargeB.isEmpty()) {
			b2 = chargeB.poll(); // B가 있는 곳 중 두번째 큰 파워(겹친 곳이 없으면 0이겠지?)
		}
		 
		if (a1 == b1) { // 가장 큰 파워가 같다는 것은 둘다 큰 파워 범주안에 들어있다.
			if (a2 > b2) { // 그러면 혹시 다른 배터리 구간과 겹친 곳이 있는지 체
				sum += (b1 + a2);
			} else if (a2 < b2) {
				sum += (a1 + b2);
			} else {
				sum += a1;
			}
		} else {
			sum += (a1 + b1);
		}
		return sum;
	}

}