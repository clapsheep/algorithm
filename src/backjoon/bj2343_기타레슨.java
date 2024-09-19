package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2343_기타레슨 {
	static int N,M,sum;
	static int[] lec;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lec = new int[N];
		sum = 0;
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lec[i] = Integer.parseInt(st.nextToken());
			sum+=lec[i];
		}
		
		
	}

}
