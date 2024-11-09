package imp;

public class QueueImp_원형2 {
	static int[] queue = new int[4];
	static int N = queue.length;
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {
		enQ(0);
		System.out.println(rear);
		
		enQ(1);
		
		enQ(2);
		
		enQ(3);
		
		System.out.println(Qpeek());
		System.out.println(deQ());
		System.out.println(deQ());
		System.out.println(deQ());

	}

	private static int deQ() {
		if (isEmpty()) {
			System.out.println("empty");
			return -1;
		}
		front = (front+1)%N;
		return queue[front];
	}

	private static int Qpeek() {
		if (isEmpty()) {
			System.out.println("empty");
			return -1;
		}
		return queue[(front+1)%N];
	}

	private static void enQ(int i) {
		if (isFull()) {
			System.out.println("full");
			return;
		}
		rear = (rear+1)%N;
		queue[rear] = i;

	}

	private static boolean isFull() {
		return (N+front-rear)%N == 1;
	}

	private static boolean isEmpty() {
		return rear == front;
	}
}
