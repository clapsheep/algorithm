import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj4195_친구네트워크 {
	static int N, T;
	static Map<String, Integer> name;
	static int[] p, r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			name = new HashMap<>();
			int cnt = 0;
			p = new int[200001];
			r = new int[200001];
			for (int i = 0; i < 200001; i++) {
				p[i] = i;
				r[i] = 1;  
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!name.containsKey(a)) {
					name.put(a, cnt++);
				}
				if(!name.containsKey(b)) {
					name.put(b, cnt++);
				}
				int idxA = name.get(a);
				int idxB = name.get(b);
				union(idxA, idxB);
				System.out.println(r[find(idxA)]);
			}
		}
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)return;
		if(r[a]>r[b]) {
			r[a] += r[b];
			p[b] = a;
		}else {
			r[b] += r[a];
			p[a] = b;
			return;
		}
		
		
	}
	private static int find(int v) {
		if(p[v]== v)return v;
		return p[v] = find(p[v]);
	}

}
