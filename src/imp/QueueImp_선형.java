package imp;

public class QueueImp_선형 {
	static int[] q = new int[100];
	static int front = -1;
	static int rear = -1;
	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(size());
		System.out.println(Qpeek());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		

	}
	static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return q[++front];
	}

	static void enQueue(int i) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		q[++rear] = i;
	}
	static boolean isEmpty() {
		return front == rear;
	}
	static boolean isFull() {
		return rear == q.length-1;
	}
	static int size() {
		return rear - front;
	}
	static int Qpeek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return q[front+1];
	}
}
