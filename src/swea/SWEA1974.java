package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
	static int T;
	static int[][] sdoku = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] res = new int [27];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					res[i] += sdoku[i][j];
					res[9+j] += sdoku[i][j];
				}
			}
			int r=26;
			
			for (int i = 0; i < 9; i=i+3) {
				for (int j = 0; j < 9; j=j+3) {
					res[r--]=sambysam(sdoku,i,j);
				}
			}
			int result= 1;
			for (int i = 0; i < res.length; i++) {
				if(res[i]!=45) {
					result = 0;
					break;
				}
			}
			System.out.println("#"+t+" "+result);
		}

		
		
		
	}
	
	static int sambysam (int[][] arr, int r, int c) {
		int sum = 0;
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

}
