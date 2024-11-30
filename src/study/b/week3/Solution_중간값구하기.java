package study.b.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_중간값구하기 {
	static int T, N, A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			TreeSet<Integer> ts = new TreeSet<>();
			ts.add(A);
			

			Long sum = 0L;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ts.add(Integer.parseInt(st.nextToken()));
				ts.add(Integer.parseInt(st.nextToken()));
				
				int centerIdx = (ts.size())/2;
				int cnt = 0;
				int center =0;
				for (Integer n : ts) {
					if(cnt == centerIdx) {
						center = n;
						break;
					}
					cnt++;
				}
				sum = (sum+center)% 20171109;

			}
			sb.append(sum );
			System.out.println(sb.toString());
		}

	}

}
