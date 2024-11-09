package imp;

class Nodee {
	public Nodee() {

	}
	String data;
	Nodee link;
}

class SinglyLinkedList{
	Nodee head;
	int size;
	SinglyLinkedList(){
		head = new Nodee();
	}
	
	void add(int i, String data) {
		if(i<0 || i>size) {
			System.out.println("outOfRange");
			return;
		}
		size++;
		
		Nodee newNode = new Nodee();
		newNode.data = data;
		
		Nodee curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.link;
		}
		newNode.link = curr.link;
		curr.link = newNode;
	}
	void remove(int i) {
		if(i<0 || i>=size) {
			System.out.println("outOfRange");
			return;
		}
		size--;
		Nodee curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.link; 
		}
		curr.link = curr.link.link;
	}
}

public class Singly2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
