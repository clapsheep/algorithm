package study1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2022_사다리 {
	static double x, y, c, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		double shorter = Math.min(x, y);

		double start = 0;
		double end = shorter;

		while (end - start >= 0.001) {
			double mid = (start + end) / 2;
			double nowC = calcC(mid);
			
			if (nowC > c) {
				start = mid;
			} else {
				end = mid;
			}
		}
		System.out.println(String.format("%.3f", end));
	}

	private static double calcC(double mid) {
		double a = Math.sqrt(x * x - mid * mid);
		double b = Math.sqrt(y * y - mid * mid);
		return (a * b) / (a + b);
	}

}
