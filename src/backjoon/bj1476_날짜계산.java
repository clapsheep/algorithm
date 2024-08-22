package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1476_날짜계산 {
	static int E, S, M;
	static int year;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken()); // 15까지
		S = Integer.parseInt(st.nextToken()); // 28까지
		M = Integer.parseInt(st.nextToken()); // 19까지

		year = 0;
		int e = 0, s = 0, m = 0;
		while (e != E || s != S || m != M) {
			
			year++;
			e = year % 15;
			s = year % 28;
			m = year % 19;
			if(year>=15) {
				if(e==0) e=15;
				if(s==0) s=28;
				if(m==0) m=19;
				
			}
			
		}
		System.out.println(year);

	}

}
