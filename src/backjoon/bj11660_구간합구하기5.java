package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11660_구간합구하기5 {
    static int N, M;
    static int[][] map;
    static int[][] prefixSum;    // 누적 합 배열 추가
    
    static class Problem {
        int x1,y1,x2,y2;
        public Problem(int x1, int y1,int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static Problem[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();    // 출력을 모아서 한 번에 하기 위해 추가
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        prefixSum = new int[N+1][N+1];    // 1부터 시작하는 인덱스 사용
        list = new Problem[M];
        
        // 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 2차원 누적 합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = map[i][j] + prefixSum[i-1][j] + 
                                 prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
        
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int result = prefixSum[x2][y2] - prefixSum[x2][y1-1] - 
                        prefixSum[x1-1][y2] + prefixSum[x1-1][y1-1];
            
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
}