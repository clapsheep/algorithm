package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759_암호만들기 {
	static int L, C;
	static char[] alpha;
	static boolean[] v;
	static char[] fix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		v = new boolean[C];
		fix = new char[L];
		Arrays.sort(alpha);

		makeCode(0, 0, 0, 0);

	}

	private static void makeCode(int cnt,int start, int moum, int jaum) {
		if (cnt == L) {
			if (moum >= 1 && jaum >= 2) {
				String res = new String(fix);
				System.out.println(res);
			}
			return;
		}
		for (int i = start; i < C; i++) {
			if (v[i])
				continue;
			v[i] = true;
			fix[cnt] = alpha[i];

			if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')
				makeCode(cnt + 1,i, moum + 1, jaum);
			else
				makeCode(cnt + 1,i, moum, jaum + 1);

			v[i] = false;
		}

	}

}
