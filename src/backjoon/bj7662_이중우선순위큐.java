package backjoon;
import java.io.*;
import java.util.*;
public class bj7662_이중우선순위큐 {
	static int T;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer,Integer> tm = new TreeMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if(cmd.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					tm.put(num, tm.getOrDefault(num, 0)+1);
				}else {
					if(tm.size()==0) continue;
					int type = Integer.parseInt(st.nextToken());
					int num;
					if(type == 1) {
						num  = tm.lastKey();
					}else {
						num = tm.firstKey();
					}
					if(tm.put(num, tm.get(num)-1)==1) {
						tm.remove(num);
					}
				}
			}
			if(tm.size()==0) {
				sb.append("EMPTY\n");
			}else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
