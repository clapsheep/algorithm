package imp;

public class QueueImp_원형 {
	static int[] q = new int[5];
	static int N = q.length;
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {
		enQueue(0);
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
		deQueue();

	}

	static int deQueue() {
		if (isEmpty()) {
			System.out.println("Quque is empty");
			return Integer.MIN_VALUE;
		}
		front = (front + 1) % N;
		return q[front];
	}

	static void enQueue(int i) {
		if (isFull()) {
			System.out.println("Quque is full");
		}
		rear = (rear + 1) % N;
		q[rear] = i;
	}

	static boolean isEmpty() {
		return front == rear;
	}

	static boolean isFull() {
		return (N+front-rear)%N == 1;
	}

	static int Qpeek() {
		if (isEmpty()) {
			System.out.println("Quque is empty");
			return Integer.MIN_VALUE;
		}
		return q[(front+1)%N];
	}

	static int size() {
		return (N+front-rear)%N;
	}

}
