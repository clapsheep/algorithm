import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1717_집합의표현 {
	static int N, M;
	static int[] p, r;

	static final String no = "NO";
	static final String yes = "YES";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 숫자의 갯수 1 ~ N 까지
		M = Integer.parseInt(st.nextToken()); // 명령어의 갯수
		p = new int[N + 1]; // 대표 배열;
		r = new int[N + 1]; // rank 배열
		for (int i = 0; i < N + 1; i++) { // make-set;
			p[i] = i;
			r[i] = 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cmd == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					System.out.println(yes);
				} else {
					System.out.println(no);
				}
				;
			}
		}
	}

	private static boolean union(int a, int b) {
		// 입력받은 두 숫자의 대표를 찾는다.
		a = find(a);
		b = find(b);
		if (a == b) { // 대표가 같으면 더이상 합칠 수 없다.
			return false;
		} else { // 대표가 다르면 둘 중 랭크가 더 큰 쪽에 흡수시킨다.
			if (r[a] > r[b]) {
				r[a] += r[b];
				p[b] = a;
			} else {
				r[b] += r[a];
				p[a] = b;
			}
			return true;
		}
	}

	private static int find(int v) {
		if (p[v] == v) { // 자기 자신이 대표면 대로 출력;
			return v;
		} else { // 자기 자신이 대표가 아니면 재귀로 대표의 대표의 대표의... 대표를 찾아 최종 대표를 출력;
			return p[v] = find(p[v]);
		}
	}

}
