package study1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj1544_소수의연속합 {
	static int N;
	static boolean[] isPrime;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		setPrime();
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while(start <=end && end<list.size()) {
			if(sum < N) {
				sum += list.get(end++);
			}else {
				if(sum == N) {
					cnt++;
				}
				sum -= list.get(start++);
			}
		}
		System.out.println(cnt);
	
	}
	public static void setPrime() {
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i*i < N+1; i++) {
			if(isPrime[i]) {
				for (int j = i*i; j < N+1; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 1; i < N+1; i++) {
			if(isPrime[i]) {
				list.add(i);
			}
		}
		list.add(0);
	}

}
