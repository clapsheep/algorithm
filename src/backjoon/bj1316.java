package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class bj1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = N;
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			
			int prev = 0;
			int[] alphabet = new int[26];
			
			
			for (int j = 0; j < word.length(); j++) {
				int now = word.charAt(j);
				
				if (prev != now) {
					if(alphabet[now-97]==0) {
						alphabet[now-97]++;
						prev=now;
				}else {
					count --;
					break;
				}
				
				}
			}
		}
		System.out.println(count);
	}

}
