package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1764_듣보잡 {
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String[] np = new String[N];
		List<String> res = new ArrayList<>();
		
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			np[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
//			mp[i] = br.readLine();
		}		

	}

}
