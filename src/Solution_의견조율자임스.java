import java.util.*;
import java.io.*;

class Solution_의견조율자임스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int t = 1; t <= T; t++) {
        	bw.write("#"+t+" ");
//            StringBuilder sb = new StringBuilder();
//            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 마싸피 의견 개수
            int M = Integer.parseInt(st.nextToken()); // 삼싸피 의견 개수

            TreeSet<String> maSet = new TreeSet<>();
            TreeSet<String> samSet = new TreeSet<>();

            for (int n = 0; n < N; n++) {
                maSet.add(br.readLine());
            }
            for (int m = 0; m < M; m++) {
                samSet.add(br.readLine());
            }

            TreeSet<String> commonOpinions = new TreeSet<>(maSet);
            commonOpinions.retainAll(samSet);

            if (!commonOpinions.isEmpty()) {
                for (String opinion : commonOpinions) {
                    bw.write(opinion+" ");
                }
            } else {
            	bw.write("NO!!");
            }
            bw.write("\n");
//            System.out.println(sb.toString());
            bw.flush();
        }
        bw.close();
    }
}