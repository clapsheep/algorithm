import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10845_큐 {
	static int[] arr;
	static int N, front, rear;

	public static void main(String[] args) throws Exception {
		arr = new int[10000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		front = -1;
		rear = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			int num = 0;
			if (command.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				arr[++rear] = num;
			}
			if (command.equals("pop")) {
				if(front!=rear) {
				System.out.println(arr[++front]);
				}else {
					System.out.println(-1);
				}
			}
			if (command.equals("size")) {
				System.out.println(rear-front);
			}
			if (command.equals("empty")) {
				if(front==rear) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
			if (command.equals("front")) {
				if (front==rear) {
					System.out.println(-1);
				} else {
					System.out.println(arr[front+1]);
				}
			}
			if (command.equals("back")) {
				if(front==rear) {
					System.out.println(-1);
				}else {
					System.out.println(arr[rear]);
				}
			}
		}

	}

}
