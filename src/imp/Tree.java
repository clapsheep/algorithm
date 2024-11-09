package imp;

public class Tree {

	static char[] tree = { 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 0, 0, 'h', 'i' };

	public static void main(String[] args) {
		pre(1);
		System.out.println();
		mid(1);
		System.out.println();
		post(1);
		System.out.println();
		

	}

	public static void pre(int root) {
		if(root>=tree.length || tree[root]== 0) {
			return;
		}
		System.out.print(tree[root]+" ");
		pre(root*2);
		pre(root*2+1);
	}
	public static void mid(int root) {
		if(root>=tree.length || tree[root]== 0) {
			return;
		}
		mid(root*2);
		System.out.print(tree[root]+" ");
		mid(root*2+1);
	}
	public static void post(int root) {
		if(root>=tree.length || tree[root]== 0) {
			return;
		}
		post(root*2);
		post(root*2+1);
		System.out.print(tree[root]+" ");
	}
}
