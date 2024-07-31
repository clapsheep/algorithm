package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			int n = 1;
			while(true) {
				if(str.substring(0,n).equals(str.substring(n,2*n))) {
					break;
				}else {
					n++;
				}
			}
			System.out.println("#"+t+" "+n);
		}
	}

}
