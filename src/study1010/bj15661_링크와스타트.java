package study1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class bj15661_링크와스타트 {
	static int N, res;

	static List<Integer> Link;
	static List<Integer> Start;
	static boolean[] v;
	static Map<Integer,Integer>[] stat;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N];
		stat = new HashMap[N];
		for (int i = 0; i < N; i++) {
			stat[i] = new HashMap<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stat[i].put(j,Integer.parseInt(st.nextToken()));
			}
		}
		res = Integer.MAX_VALUE;
		subset(0);
		System.out.println(res);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			Link = new ArrayList<>();
			Start = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(v[i]) {
					Link.add(i);
				}else {
					Start.add(i);
				}
			}
			if(Link.size()==0 || Start.size()==0) {
				return;
			}
			int LinkSum = 0;
			int StartSum = 0;
			
			for (int s : Link) {
				for (int e : Link) {
					if(s==e) continue;
					LinkSum += stat[s].get(e);
				}
			}
			for (int s : Start) {
				for (int e : Start) {
					if(s==e) continue;
					StartSum += stat[s].get(e);
				}
			}
			res= Math.min(Math.abs(LinkSum-StartSum), res);
			return;
		}
		subset(cnt + 1);
		v[cnt] = true;
		subset(cnt + 1);
		v[cnt] = false;

	}

}
