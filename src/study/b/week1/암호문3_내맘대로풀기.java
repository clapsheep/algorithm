package study.b.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호문3_내맘대로풀기 {
	static int N;

	static class Node {
		Node next;
		int code;

		public Node(int code) {
			this.code = code;
			this.next = null;
		}

	}

	static class LinkedList {
		Node head;
		Node tail;

		public LinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void init(int cnt, String code) {
			StringTokenizer initCode = new StringTokenizer(code);

			// 첫 번째 노드 생성
			head = new Node(Integer.parseInt(initCode.nextToken()));
			Node temp = head;

			// 나머지 노드들 연결
			for (int i = 1; i < cnt; i++) {
				Node newNode = new Node(Integer.parseInt(initCode.nextToken()));
				temp.next = newNode;
				temp = newNode;
			}
			tail = temp;
		}

		public void add(int count, String code) {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			StringTokenizer st = new StringTokenizer(code);
			for (int i = 0; i < count; i++) {
				Node node = new Node(Integer.parseInt(st.nextToken()));
				temp.next = node;
				temp = node;
			}

		}

		public void insert(int index, int count, String input) {
			Node temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < count; i++) {
				Node node = new Node(Integer.parseInt(st.nextToken()));
				node.next = temp.next;
				temp.next = node;
				temp = node;
			}

		}

		public void delete(int index, int count) {
			Node temp = head;
			// index-1번째 노드로 이동
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			
			Node nextNode = temp.next;
			// count만큼 다음 노드로 이동
			for (int i = 0; i < count; i++) {
				nextNode = nextNode.next;
			}
			
			temp.next = nextNode;
		}

		public String toString() {
			StringBuilder sbforNode = new StringBuilder();
			Node temp = head;
			int count = 0;
			while (temp != null && count < 10) {
				sbforNode.append(temp.code).append(" ");
				temp = temp.next;
				count++;
			}

			return sbforNode.toString();
		}
	}

	public static void main(String[] args) throws Exception {

		for (int t = 1; t <= 10; t++) {
			StringBuilder res = new StringBuilder();
			res.append("#").append(t).append(" ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine()); // 1번
			LinkedList list = new LinkedList(); // 연결리스트 생성
			list.init(N, br.readLine()); // 2번

			String trash = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String cmd = st.nextToken();
				switch (cmd) {
				case "I": {
					int idx = Integer.parseInt(st.nextToken());
					int cnt = Integer.parseInt(st.nextToken());
					StringBuilder code1 = new StringBuilder();
					for (int j = 0; j < cnt; j++) {
						code1.append(st.nextToken()).append(" ");
					}
					list.insert(idx, cnt, code1.toString());
					break;
				}

				case "D": {
					int idx = Integer.parseInt(st.nextToken());
					int cnt = Integer.parseInt(st.nextToken());
					list.delete(idx, cnt);
					break;
				}

				case "A": {
					int cnt = Integer.parseInt(st.nextToken());
					StringBuilder code2 = new StringBuilder();
					for (int j = 0; j < cnt; j++) {
						code2.append(st.nextToken()).append(" ");
					}
					list.add(cnt, code2.toString());
					break;
				}
				}
			}
			res.append(list.toString());
			System.out.println(res.toString());
		}
	}
}