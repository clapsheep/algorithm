package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj12927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str =  br.readLine();
		char[] strArr = str.toCharArray();
		int N = strArr.length;
		char[] ss = new char[N + 1];
		ss[0] = 'N';
		for (int i = 1; i < ss.length; i++) {
			ss[i] = strArr[i - 1];
		}
		
		int count = 0;


		// 스위치 번
		for (int i = 1; i < ss.length; i++) {

			// 전구 전체상태 확인로직
			str = "";
			for (int j = 1; j < ss.length; j++) {
				str += (Character.toString(ss[j]));
			}
			if(str.contains("Y")) {
				if(ss[i]=='Y') {
					for (int j = 1; j < ss.length; j++) {
						if(j%i==0) {
							ss[j] = switchBtn(ss[j]);
						}
					}
					count++;
				}
			}else {
				System.out.println(count);
				return;
			}
		}
		
		System.out.println(-1);
	}

	static char switchBtn(char s) {
		if (s == 'N') {
			return 'Y';
		} else {
			return 'N';
		}
	}
	
}
