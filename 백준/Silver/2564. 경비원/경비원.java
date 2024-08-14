import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static int N;
	static int user;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		int[] stores = new int[N];
		for (int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int tmp = 0;
			if (d == 1) { // 북
				tmp = l;
			} else if (d == 2) { // 남
				tmp = W+H+W-l;
			} else if (d == 3) { // 서
				tmp = W+H+W+H - l;
			} else { // 동
				tmp = W + l;
			}
			if(i<N) {
				stores[i] = tmp;
			}else {
				user = tmp;
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
		    int dis1 = Math.abs(user - stores[i]);
		    int dis2 = 2*W + 2*H - dis1;
		    sum += Math.min(dis1, dis2);
		    }
		System.out.println(sum);
	}

}
