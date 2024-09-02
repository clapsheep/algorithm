import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {
	static int T ,M, BC , sumA, sumB, time;
	static int N = 10;
	static int[] A,B,BCP;
	static int[][] map = new int[N][N];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 시간
			BC = Integer.parseInt(st.nextToken()); // 충전기 갯수
			
			A= new int[M];
			B= new int[M];
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			BCP = new int[BC+1];
			
			for (int i = 1; i <= BC; i++) {
				st= new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				BCP[i] = P;
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < N; col++) {
						int rAbs = Math.abs(y-row);
						int cAbs = Math.abs(x-col);
						if(rAbs+cAbs<=C)map[row][col] = i;
					}
				}
			}
			time = 0;
			bfs(0,0,9,9);
			System.out.println(Arrays.toString(BCP));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

	private static void bfs(int ar, int ac, int br, int bc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {ar,ac,br,bc});
		sumA +=map[ar][ac];
		sumB +=map[ar][ac];
		while(time < M) {
			int[] s = q.poll();
			int nar = s[0]+dr[A[time]];
			int nac = s[1]+dc[A[time]];
			int nbr = s[2]+dr[B[time]];
			int nbc = s[3]+dc[B[time]];
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
