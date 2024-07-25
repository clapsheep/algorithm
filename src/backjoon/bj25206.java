package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		double[] gs = new double[20];
		double[] ss = new double[20];
		double total = 0;
		
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String subject= st.nextToken();
			gs[i] = Double.parseDouble(st.nextToken());
			ss[i] = score(st.nextToken());
			if (ss[i] != 5) {
				total += gs[i];
			}
		}
		double res = 0;
		for (int i = 0; i < 20; i++) {
			if (ss[i] != 5) {
				res += gs[i] / total * ss[i];
			} else {
				continue;
			}

		}
		System.out.println(res);
	}

	static double score(String g) {
		switch (g) {
		case "A+":
			return 4.5;
		case "A0":
			return 4.0;
		case "B+":
			return 3.5;
		case "B0":
			return 3.0;
		case "C+":
			return 2.5;
		case "C0":
			return 2.0;
		case "D+":
			return 1.5;
		case "D0":
			return 1.0;
		case "F":
			return 0.0;
		}
		return 5;
	}

}
