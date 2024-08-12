package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2578 {
	static int[][] bingo;	
	static int callCnt;
	static int res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		bingo = new int[5][5];
		callCnt = 0;
		
		// 빙고 작성
		for (int i = 0; i < 5; i++) {
		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자 콜
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int call = Integer.parseInt(st.nextToken());
				
				callout : for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if(bingo[k][l] == call) {
							bingo[k][l] = 0;
							callCnt++;
							break callout;
						};
					}
				}
				res = 0;
				checkrow();
				checkcol();
				checkcross1();
				checkcross2();
				if(res >=3) {
					System.out.println(callCnt);
					return;
				}
			}
		}
	}
	static void checkrow() {
		for (int r = 0; r < 5; r++) {
			int rowtmp = 0;
			for (int c = 0; c < 5; c++) {
				rowtmp += bingo[r][c];
			}
			if (rowtmp ==0) res++;
			
		}
	}
	static void checkcol() {
		for (int c = 0; c < 5; c++) {
			int coltmp = 0;
			for (int r = 0; r < 5; r++) {
				coltmp += bingo[r][c];
			}
			if (coltmp ==0) res++;
		}
		
	}
	static void checkcross1() {
		int cross1tmp=0;
		for (int r = 0; r < 5; r++) {
			cross1tmp +=bingo[r][r];
		}
		if(cross1tmp == 0) res++;
		
	}
	static void checkcross2() {
		int cross2tmp=0;
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if(r+c==4) {
					cross2tmp +=bingo[r][c];
				}
			}
		}
		if(cross2tmp == 0) res++;
	}
}
