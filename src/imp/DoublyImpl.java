package imp;

class Node {
	String data;
	Node prev;
	Node next;

}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	void add(int i, String data) {
		if (i < 0 || i > size) {
			System.out.println("outOfRange");
			return;
		}
		Node curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		Node newNode = new Node();
		newNode.next = curr.next;
		newNode.prev = curr;
		
		curr.next.prev= newNode;
		curr.next = newNode;
		size++;
	}
	void remove(int i) {
		if(i<0 || i>=size) {
			System.out.println("outOfRange");
			return;
		}
		Node rmNode= head.next;
		for (int j = 0; j < i; j++) {
			rmNode= rmNode.next;
		}
		rmNode.prev.next= rmNode.next;
		rmNode.next.prev = rmNode.prev;
		size--;
	}

}

public class DoublyImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
