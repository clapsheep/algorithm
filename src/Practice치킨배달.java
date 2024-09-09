import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Practice치킨배달 {
	static int N, M, StoreSize, res;
	static int[][] map;
	static List<int[]> Home;
	static List<int[]> Stores;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		M = Integer.parseInt(st.nextToken());
		Home = new ArrayList<>();
		Stores = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					Home.add(new int[] { i, j });
				}
				if (map[i][j] == 2) {
					Stores.add(new int[] { i, j });
				}
			}
		}
		StoreSize = Stores.size();
		v = new boolean[StoreSize];
		res = 100000000;
		
			ncr(0, M, 0);

		System.out.println(res);
	}

	private static void ncr(int cnt, int max, int start) {
		if (cnt == max) {
			int tmp = 0;
			for (int[] h : Home) {
				tmp += calc(h, v);
			}
			res = Math.min(res, tmp);
			return;
		}
		for (int i = start; i < StoreSize; i++) {
			if (v[i])
				continue;
			v[i] = true;
			ncr(cnt + 1, max, i);
			v[i] = false;
		}
	}

	private static int calc(int[] h, boolean[] chicken) {
		int temp = 100000000;
		for (int i = 0; i < chicken.length; i++) {
			if (chicken[i]) {
				int[] s = Stores.get(i);
				temp = Math.min(temp,Math.abs(h[0]-s[0])+Math.abs(h[1]-s[1])) ;
			}
		}
		return temp;
	}

}
