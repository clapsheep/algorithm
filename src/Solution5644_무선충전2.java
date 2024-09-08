import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5644_무선충전2 {
	static int T, M, C, sum;
	static int N = 10;
	static Queue<Integer> A, B;
	static int[] dr = { 0, -1, 0, 1, 0 }; // 0:이동x , 1:up, 2:right, 3:down, 4:left;
	static int[] dc = { 0, 0, 1, 0, -1 };
	static List<Battery> BS;

	static class Battery {
		int r, c, w, p;
		List<int[]> range;

		public Battery(int r, int c, int w, int p) {
			this.r = r;
			this.c = c;
			this.w = w;
			this.p = p;
			this.range = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동할 시간
			C = Integer.parseInt(st.nextToken()); // 배터리 개수
			A = new LinkedList<>();
			B = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A.offer(Integer.parseInt(st.nextToken())); // A의 이동 경로
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B.offer(Integer.parseInt(st.nextToken())); // B의 이동 경로
			}
			BS = new ArrayList<>();

			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()) - 1; // 현재 입력받은 배터리의 r
				int c = Integer.parseInt(st.nextToken()) - 1; // 현재 입력받은 배터리의 c
				int w = Integer.parseInt(st.nextToken()); // 현재 입력받은 배터리의 범위
				int p = Integer.parseInt(st.nextToken()); // 현재 입력받은 배터리의 파워
				BS.add(new Battery(r, c, w, p)); // 현재 좌표 추가
				for (int j = 0; j < N; j++) {
					for (int l = 0; l < N; l++) {
						if ((Math.abs(j - r) + Math.abs(l - c)) <= w) {
							BS.get(i).range.add(new int[] { l, j });
						}
					}
				}
			}
			int rA = 0;
			int cA = 0;
			int rB = 9;
			int cB = 9;
			int sum = 0;
			while (!A.isEmpty()) {

				sum += calc(rA, cA, rB, cB);
				int dirA = A.poll();
				int dirB = B.poll();

				rA = rA + dr[dirA];
				cA = cA + dc[dirA];
				rB = rB + dr[dirB];
				cB = cB + dc[dirB];
			}
			sum += calc(rA, cA, rB, cB);
			sb.append(sum);
			System.out.println(sb.toString());
		}
	}

	private static int calc(int rA, int cA, int rB, int cB) {
		int sum = 0;

		List<Integer> As = new ArrayList<>(); // 배터리의 인덱스
		List<Integer> Bs = new ArrayList<>();

		for (int i = 0; i < C; i++) { // 각 배터리 조회
			Battery bt = BS.get(i);
			List<int[]> Brange = bt.range;

			for (int j = 0; j < Brange.size(); j++) {
				if (Brange.get(j)[0] == rA && Brange.get(j)[1] == cA) {
					As.add(i); // 어느 배터리에 있니?
				}
				if (Brange.get(j)[0] == rB && Brange.get(j)[1] == cB) {
					Bs.add(i);
				}
			}
		}
		int pA = 0, pB = 0;
		if (As.size() == 0 && Bs.size() == 0) { // 둘다 아무 충전기에 안올라가 있는 경우
			return 0;
		} else if (As.size() == 0) {// B만 어딘가 올라간 경우
			for (int i = 0; i < Bs.size(); i++) { 
				pB = Math.max(BS.get(Bs.get(i)).p, pB);
			}
		} else if (Bs.size() == 0) {// A만 어딘가 올라간 경우
			for (int i = 0; i < As.size(); i++) { 
				pA = Math.max(BS.get(As.get(i)).p, pA);
			}
		} else { // 둘 다 어딘가 올라간 경우
			int temp = 0;
			for (int i = 0; i < As.size(); i++) {
				for (int j = 0; j < Bs.size(); j++) {
					
					if(BS.get(As.get(i))== BS.get(Bs.get(j))){ // 둘다 같은 충전기에 올라가 있는 경우
						temp = Math.max(temp, BS.get(As.get(i)).p);
					}else { // 둘다 다른 충전기에 올라가 있는 경우
						pA = BS.get(As.get(i)).p;
						pB = BS.get(Bs.get(j)).p;
						temp = Math.max(temp, pA+pB);
					}
				}
			}
			return temp;
		}
		return pA+pB;
	}

}