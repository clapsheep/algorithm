package backjoon;

import java.util.HashSet;
import java.util.Set;

public class bj4673 {

	public static void main(String[] args) {
		Set<Integer> no = new HashSet<>();
		int count = 1;
		while(true) {
			int num = notSelf(count++);
			if(num >=10000) break;
			no.add(num);
		}
		
		for (int i = 1; i <9995; i++) {
			if(!no.contains(i)) {
				System.out.println(i);
			}
		}

	}
	static int notSelf(int n) {
		char[] convert =Integer.toString(n).toCharArray();
		int sum = 0;
		for (int i = 0; i < convert.length; i++) {
			sum += convert[i]-'0';
		}
		return sum+n;
	}
}
