package study1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15922_아우으 {
	static int N;

	static class Line {
		int x;
		int y;

		public Line() {
		}

		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Line [x=" + x + ", y=" + y + "]";
		}

	}

	static List<Line> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (list.size() == 0) { //최초 입력
				list.add(new Line(x, y));
				continue;
			}
			
			Line now = list.get(list.size()-1);
			if(x >= now.x && x <=now.y) {
				if(y >=now.x && y<=now.y) {
					continue;
				}
				list.get(list.size()-1).y = y;
			}else {
				list.add(new Line(x, y));
			}

		}
		int res = 0;
		for (Line l : list) {
			res += Math.abs(l.y-l.x);
		}
		System.out.println(res);
	}

}
