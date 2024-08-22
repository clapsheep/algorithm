package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1748_수이어쓰기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 1;
		int jari = 10;
		for (int i = 1; i <= n; i++) {
			if (i % jari == 0) {
				jari *= 10;
				num++;
			}
			cnt += num;
		}
		System.out.println(cnt);
	}

}
