package study0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1989 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			char[] strArr = str.toCharArray();
			int index = strArr.length-1;
			char[] arr = new char[index+1];
			for (int i = 0; i <= index; i++) {
				arr[i] = strArr[index--];
			}
			int cnt=0;
			for (int i = 0; i <= index; i++) {
				if(arr[i]==strArr[i]) {
					cnt++;
				}
			}
			int res = 0;
			if(cnt==index+1) res = 1; 
			System.out.println("#" + t + " " + res);
		}

	}

}
