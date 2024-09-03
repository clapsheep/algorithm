import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2112_보호필름{

	static int T, D, W, K;
	static int[][] map;
	static int count;
	static int[] rows;
	static int[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			A = new int[W];
			B = new int[W];
			Arrays.fill(A, 0);
			Arrays.fill(B, 1);

			rows = new int[D];

			for (int i = 0; i < D; i++) {
				rows[i] = i;
			}

			count = D + 1;
			if (QC(map)) {
				sb.append(0);
			} else {
				subset(0);
				sb.append(count);
			}
			System.out.println(sb.toString());
		}

	}

	private static void subset(int cnt) {
		
		if (cnt == D) {
			int temp = 0;
			for (int i = 0; i < D; i++) {
				if (rows[i] != 0)
					temp++;
			}
			if ( count <= temp)return;
//			System.out.println(Arrays.toString(rows));

			int[][] tmpArr = new int[D][W];
			for (int i = 0; i < D; i++) {
				if (rows[i] == 1) {
					tmpArr[i] = A;
				} else if (rows[i] == 2) {
					tmpArr[i] = B;
				} else {
					for (int j = 0; j < W; j++) {
						tmpArr[i][j] = map[i][j];
					}
				}
			}

			if (QC(tmpArr))
				count = Math.min(count, temp);
			return;
		}
		rows[cnt] = 0;
		subset(cnt + 1);
		rows[cnt] = 1;
		subset(cnt + 1);
		rows[cnt] = 2;
		subset(cnt + 1);

	}

	static boolean QC(int[][] arr) {
		int cnt = 0;
		for (int c = 0; c < W; c++) {
			int temp = 0;
			for (int r = 1; r < D; r++) {
				if(arr[r][c]==arr[r-1][c]) {
					temp++;
					if(temp==K-1) break;
				}else {
					temp = 0;
				}
			}
			if(temp==K-1)cnt++;
		}
		return cnt==W;
	}

}