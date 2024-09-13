import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9012_괄호 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Queue<Character> q = new LinkedList<>();
			char[] cs = br.readLine().toCharArray();

			boolean pos = true;
			for (int j = 0; j < cs.length; j++) {
				char c = cs[j];
				if (c == '(') {
					q.add('(');
				} else {
					if (!q.isEmpty()) {
						q.remove();
					} else {
						pos = false;
						break;
					}
				}
			}
			if (!q.isEmpty()) {
				pos = false;
			}
			System.out.println(pos ? "YES" : "NO");
		}

	}

}
