package imp;

public class StackImp {
	static int[] st = new int[50];
	static int top = -1;
	public static void main(String[] args) {
		push(0);
		push(1);
		System.out.println(pop());
		System.out.println(pop());

	}
	static boolean isEmpty() {
		return top == -1;
	}
	static boolean isFull() {
			return top==st.length-1;
	}
	static int size() {
		
		return top+1;
	}
	static int peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		return st[top];
	}
	static int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		return st[top--];
		
	}
	static void push(int i) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		st[++top] = i;
		
	}
	
}
