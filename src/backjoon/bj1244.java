package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		int studentN = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentN; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int getNum = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int j = 1; j < N + 1; j++) {
					if ((j) % getNum == 0) {
						S[j] = switchButton(S[j]);
					}
				}
			}
			if (gender == 2) {

				for (int j = 0; j < (getNum >= N / 2 ? N + 1 - getNum : getNum); j++) {
					if (S[getNum + j] == S[getNum - j]) {
						if (getNum + j == getNum - j) {
							S[getNum + j] = switchButton(S[getNum + j]);
						} else {
							S[getNum + j] = switchButton(S[getNum + j]);
							S[getNum - j] = switchButton(S[getNum - j]);
						}
					} else {
						break;
					}
				}
			}

		}
		for (int i = 1; i < S.length; i++) {
			System.out.print(S[i]);
			if(i%20==0) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
		}
	}

	static int switchButton(int n) {
		if (n == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
