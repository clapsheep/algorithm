package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16987_계란으로계란치기 {
	static int N, res;

	static class Egg {
		int s, w;
		boolean broken;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
			this.broken = false;
		}

	}

	static Egg[] E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		E = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			E[i] = new Egg(s, w);
		}

		res = 0;
		hit(0);
		System.out.println(res);

	}

	private static void hit(int cnt) {

		if (cnt == N) {
			int howMany = 0;
			for (int i = 0; i < N; i++) {
				if (E[i].broken) {
					howMany++;
				}
			}
			res = Math.max(res, howMany);
			return;
		}

		if (E[cnt].broken) {
			hit(cnt + 1);
			return;
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (E[i].broken)
				continue;
			if (cnt == i)
				continue; // 본인이 본인을 깰 수 없으므로 건너뜀
			flag = true;
			int a = E[cnt].s; // 백트래킹을 위한 저장
			boolean stateA = E[cnt].broken;
			int b = E[i].s; // 백트래킹을 위한 저장
			boolean stateB = E[i].broken;

			E[cnt].s -= E[i].w; // 들고있는 계란 상태변경
			if (E[cnt].s <= 0) {
				E[cnt].broken = true;
			}
			E[i].s -= E[cnt].w; // 맞은 계란 상태변경
			if (E[i].s <= 0) {
				E[i].broken = true;
			}
			hit(cnt + 1); // 재귀
			E[cnt].s = a;
			E[cnt].broken = stateA;
			E[i].s = b;
			E[i].broken = stateB;
		}
		if (!flag) {
			hit(cnt + 1);
		}
	}

}
