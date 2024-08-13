package study0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution1928_useLib {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String code = br.readLine();
			String res = new String(Base64.getDecoder().decode(code));
			System.out.println("#"+t+" "+res);
		}

	}

}
