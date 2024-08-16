package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11866_요세푸스문제0 {
	static int[] q;
	static int front = 0, rear = 0;
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new int[N];
		for (int i = 1; i < N; i++) {
			enQ(i);

			
		}

		for (int i = 0; i < N; i++) {
			System.out.println(deQ());

		}
	}
	static boolean isEmpty() {
		return front==rear;
	}
	static void enQ(int n) {
		rear = (rear+1)%N;
		q[rear] = n;
	}
	static int deQ() {
		if(isEmpty()){
			return -1;
		}
		front = (front+1)%N;
		return q[front];
	}
}
