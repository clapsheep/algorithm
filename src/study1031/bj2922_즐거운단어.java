package study1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj2922_즐거운단어 {
	static char[] words;
	static int underBarCnt, emptyLength;
	static int[] num;
	static boolean hasL;
	static List<Integer> underBarPosition;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		words = br.readLine().toCharArray();
		emptyLength= words.length;
		underBarCnt=0;
		underBarPosition = new ArrayList<>();
		for (int i = 0; i < emptyLength; i++) {
			if(words[i]=='_') {
				underBarCnt++;
				underBarPosition.add(i);
			}
			if(!hasL || words[i]=='L') {
				hasL=true;
			}
		}
		
		num = new int[emptyLength];
		combi(0);
		
	}

	private static void combi(int cnt) {
		if(cnt == underBarCnt) {
			for (int i = 0; i < emptyLength; i++) {
				
			}
		}
		for (int i = 0; i < 26; i++) {
			words[underBarPosition.get(cnt)] = (char)('A'+i);
			combi(cnt+1);
			words[underBarPosition.get(cnt)] = '_';
		}
		
	}
}
