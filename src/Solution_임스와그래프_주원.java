import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_임스와그래프_주원{

    static class point{ //노드와 가중치를 저장할 클래스
        
        char node; //노드
        int weight; //가중치
        
        
        public point(char node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
    }
    
    
    static final int INF = 100000000;  // 무한대 값
    static Map<Character, List<point>> graph;  // point를 표현하는 Map 입력받은 node 저장
    

    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= TC; tc++) {
            
          
          int N = Integer.parseInt(br.readLine());
        
          graph = new HashMap<>();
          
          for (char i = 'a'; i <= 'z'; i++) {    // a~z까지 노드 초기화
              graph.put(i, new ArrayList<>());  
          }
          
          for (char i = 'A'; i <= 'Z'; i++) {    // A~Z까지 노드 초기화
              graph.put(i, new ArrayList<>());  
          }
                 
          for (int i = 0; i < N; i++) {
            
              StringTokenizer st = new StringTokenizer(br.readLine());
                        
              char start = st.nextToken().charAt(0); // 출발 노드
              char end = st.nextToken().charAt(0); // 도착 노드
              int weight = Integer.parseInt(st.nextToken()); // 가중치
              

              graph.get(start).add(new point(end,weight)); // 출발 노드에 add를 통해 도착 지점들을 추가
              
          }
          
          int im = search('a','Z');
          int ban = search('Z','a'); 
          //양방향 그래프가 아니였다..

                
          if (im==INF) {
              System.out.println("#"+tc+" "+"NO");
          } else if (im <= ban) {
              System.out.println("#"+tc+" "+"YES"+" "+im);
          } else {
              System.out.println("#"+tc+" "+"NO");
          }
          
      }      
    }


    private static int search(char start, char end) {

        
        PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {
         @Override
        public int compare(point o1, point o2) { // 가중치 오름차순으로 정렬
            return o1.weight-o2.weight;
        }
        });
    
        Map<Character, Integer> dijk = new HashMap<>();
        
        
         for (char i = 'a'; i <= 'z'; i++) {    //탐색 맵 초기화
             dijk.put(i, INF);  
              }
                  
         for (char i = 'A'; i <= 'Z'; i++) {    
             dijk.put(i, INF);  
         }
        
        
         dijk.put(start, 0); // 출발 출발 가중치 0 
         pq.add(new point(start,0)); // queue에 넣는다.
         
         while(!pq.isEmpty()) { // 큐가 비면 탐색 끝
             
            point p = pq.poll();
             
            char node = p.node; // 현재 노드
            int weight = p.weight; // 현재 가중치
            
            if (weight>dijk.get(node))continue; // 현재 노드에 도착한 경로가 이미 기록된 것보다 클떄
            
            
            for(point next : graph.get(node)) { // graph.get을 통해서 도착 노드를 순회하며
        
                int newweight = weight+next.weight; // 가중치를 더해서
                
                if (newweight<dijk.get(next.node)) { // 최단 경로가 갱신되었을때
                    
                    dijk.put(next.node, newweight);
                    pq.add(new point(next.node,newweight));        
                    
                }            
            }             
         }
    
        return dijk.get(end); // Z에 도착했을때 비용을 리턴
    }

}
