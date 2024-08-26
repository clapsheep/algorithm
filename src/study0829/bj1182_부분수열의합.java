package study0829;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class bj1182_부분수열의합 {
		static int N, S;
		static int[] p;
		static int count;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			p = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			subSet(0, 0);
			if(S == 0) count--;
			System.out.println(count);
			
		}

		private static void subSet(int cnt, int sum) {
			if (cnt == N) {
				if (sum == S) count++;
				return;
			}
			subSet(cnt + 1, sum + p[cnt]);
			subSet(cnt + 1, sum);
		}
	}
