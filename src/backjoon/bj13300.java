package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] room = new int [2][6];
		int count = 0;
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			int gender= Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			room[gender][grade-1]++; 
			
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				count += (room[i][j]/K);
				if(room[i][j]%K!=0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
