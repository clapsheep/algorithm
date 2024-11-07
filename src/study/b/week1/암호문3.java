package study.b.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 암호문3 {
	static final int MAX_SIZE = 5000;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class LinkedList {
		Node head; // 맨 앞 노드
		Node tail; // 맨 뒷 노드
		Node[] arr;
		int cnt;

		public LinkedList() {
			head = null;
			arr = new Node[MAX_SIZE];
			cnt = 0;
		}

		// 새로운 노드를 만들건데
		// list의 arr에 담기 위해 메서드로 만듬
		Node getNewNode(int data) {
			arr[cnt] = new Node(data);
			return arr[cnt++];
		}

		// idx 바로 뒤의 노드에 입력받은 nums를 노드화 해서 연결
		void insert(int idx, int[] nums) {
			int st = 0; // 새로 넣은 노드의 인

			if (idx == 0) { // 맨앞에 붙는 경우
				if (head != null) { // 헤드가 있으면 새로운 첫번째 노드의 next를 헤드
					Node newNode = getNewNode(nums[0]);
					newNode.next = head;
					head = newNode;
				} else { // 헤드가 없으면 첫번째 인풋이 헤드
					head = getNewNode(nums[0]);
				}
				idx = 1;
				st = 1;
			}
			Node cur = head; // idx에 맞는 노드 탐색
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			for (int i = st; i < nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				newNode.next = cur.next;
				cur.next = newNode;
				cur = newNode;
			}
			if (cur.next == null) {
				tail = cur;
			}
		}

		void delete(int idx, int cnt) {
			Node cur = head;
			if (idx == 0) {
				for (int i = 0; i < cnt; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			Node anchor = cur;
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
			anchor.next = cur.next;
			if (anchor.next == null) {
				tail = anchor;
			}
		}

		void add(int data) {
			Node cur = tail;
			Node newNode = getNewNode(data);
			cur.next = newNode;
			tail = newNode;
		}

		void print() throws Exception {
			int cnt = 10;
			Node cur = head;
			while (--cnt >= 0) {
				bw.write(cur.data + " ");
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		int T = 10;
		for (int t = 1; t <= T; t++) {
			LinkedList list = new LinkedList();
			bw.write("#");
			bw.write(t + " ");
			int N = Integer.parseInt(br.readLine());
			int[] initArr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				initArr[i] = Integer.parseInt(st.nextToken());
			}
			list.insert(0, initArr);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char cmd = st.nextToken().charAt(0);
				int x, y;
				switch (cmd) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					int[] temp = new int[y];
					for (int j = 0; j < y; j++) {
						temp[j] = Integer.parseInt(st.nextToken());
					}
					list.insert(x, temp);
					break;
				case 'D' :
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					list.delete(x, y);
					break;
				case 'A' :
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			list.print();
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
