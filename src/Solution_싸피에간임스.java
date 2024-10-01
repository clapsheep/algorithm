import java.util.*;


class Solution_싸피에간임스 {
    static int T, N;
    static PriorityQueue<Node> pq;
    static class Node{
        int rank;
        String title;
        public Node(String title,int rank){
            this.title = title;
            this.rank = rank;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t= 1; t<=T; t++){
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            N = sc.nextInt();
            pq = new PriorityQueue<>((o1,o2)->{
                int res= 0;
               if (o1.rank == o2.rank) {
                    res = o1.title.compareTo(o2.title); // 타이틀이 같은 경우 사전순으로 비교
                } else {
                    res = Integer.compare(o1.rank, o2.rank); // 랭크를 비교
                }
                return res;
                    });
            for(int i = 0; i < N; i++){
                String title = sc.next();
                int rank = sc.nextInt();
                pq.offer(new Node(title,rank));
            }
              for(int i = 0; i < N; i++){
                Node n =pq.poll();
                sb.append(n.title).append(" ");
            }
            
            System.out.println(sb.toString());
        }
    }
}