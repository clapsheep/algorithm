import java.util.*;
import java.io.*;

class Solution_의견조율자임스_투포인터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 마싸피 의견 개수
            int M = Integer.parseInt(st.nextToken());  // 삼싸피 의견 개수
            
            String[] ma = new String[N];
            String[] sam = new String[M];
            
            for (int n = 0; n < N; n++) {
                ma[n] = br.readLine();
            }
            for (int m = 0; m < M; m++) {
                sam[m] = br.readLine();
            }
            
            Arrays.sort(ma);  // 마싸피 의견 정렬
            Arrays.sort(sam);  // 삼싸피 의견 정렬
            
            int i = 0, j = 0;
            boolean found = false;
            while (i < N && j < M) {
                int cmp = ma[i].compareTo(sam[j]);
                if (cmp == 0) {  // 같은 의견 발견
                    sb.append(ma[i]).append(" ");
                    i++;
                    j++;
                    found = true;
                } else if (cmp < 0) {
                    i++;
                } else {
                    j++;
                }
            }
            
            if (!found) {
                sb.append("NO!!");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
