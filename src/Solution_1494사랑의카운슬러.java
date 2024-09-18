import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494사랑의카운슬러 {
	static class ZI{
		int r,c;
		public ZI(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static int T, N;
	static long res;
	static ZI[] list;
	static boolean[] v;
	


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			list = new ZI[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[i] = new ZI(r,c);
			}
			v= new boolean[N];
			res= Long.MAX_VALUE;
			npr(0,0);
			sb.append(res);
			System.out.println(sb.toString());
		}
	}

	private static void npr(int cnt,int start) {
		if(cnt == N/2) {
			calc();
			return;
		}
		for (int i = start; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			npr(cnt+1,i);
			v[i] = false;
		}
	}

	private static void calc() {
		long vecR = 0, vecC = 0;
		for (int i = 0; i < N; i++) {
			if(v[i]) {
				vecR+=list[i].r;
				vecC+=list[i].c;
			}else {
				vecR-=list[i].r;
				vecC-=list[i].c;
			}
		}
		long dist = vecR*vecR+vecC*vecC;
		res= Math.min(dist, res);
	}

}
