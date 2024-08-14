package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int initX = Integer.parseInt(st.nextToken());
		int initY = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());

		int endX = x-Math.abs(x-(initX+T)%(2*x));
		int endY = y-Math.abs(y-(initY+T)%(2*y));
		
		System.out.printf("%d %d" ,endX,endY);

	}

}
