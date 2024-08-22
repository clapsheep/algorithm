package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class bj3085_사탕게임 {
	static int N;
	static char[][] candy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		for (int i = 0; i < N; i++) {
				candy[i]= br.readLine().toCharArray();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				char temp = candy[i][j];
				candy[i][j] = candy[i][j-1];
				candy[i][j-1] = temp;
				max = Math.max(max,check(candy));
				temp = candy[i][j];
				candy[i][j] = candy[i][j-1];
				candy[i][j-1] = temp;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				char temp = candy[j][i];
				candy[j][i] = candy[j-1][i];
				candy[j-1][i] = temp;
				max = Math.max(max,check(candy));
				temp = candy[j][i];
				candy[j][i] = candy[j-1][i];
				candy[j-1][i] = temp;
			}
		}
		
		System.out.println(max);
	}
	
	static int check(char[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			int index = 1;
			int tempMax = 0;
			while(index < N) {
				if(arr[i][index]==arr[i][index-1]) {
					cnt++;
					tempMax = Math.max(tempMax,cnt);
					index++;
				}else {
					cnt= 1;
					index++;
				}
			}
			max = Math.max(max, tempMax);
		}
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			int index = 1;
			int tempMax = 0;
			while(index < N) {
				if(arr[index][i]==arr[index-1][i]) {
					cnt++;
					tempMax = Math.max(tempMax,cnt);
					index++;
				}else {
					cnt= 1;
					index++;
				}
			}
			max = Math.max(max, tempMax);
		}
		return max;
	}
}
