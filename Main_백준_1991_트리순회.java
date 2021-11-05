package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1991_트리순회 {
	static int N;
	static char[][] tree = new char[26][2];
	static String pre = "", in = "", post = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
			String input = br.readLine();
			char root = input.charAt(0);
			char left = input.charAt(2);
			char right = input.charAt(4);
			tree[root - 'A'][0] = left; // input[root][왼쪽 or 오른쪽 자식] 형태로 저장
			tree[root - 'A'][1] = right;
		} // end of input

		preOrder('A');
		inOrder('A');
		postOrder('A');
		System.out.println(pre + "\n" + in + "\n" + post);
	}

	private static void preOrder(char x) {
		if (x == '.')
			return;
		pre += x; // root가 처음이므로 자기 자신 출력 후 왼쪽 자식 오른쪽 자식 재귀로 들어가기
		preOrder(tree[x - 'A'][0]);
		preOrder(tree[x - 'A'][1]);
	}

	private static void inOrder(char x) {
		if (x == '.')
			return;
		inOrder(tree[x - 'A'][0]); // root를 중간에 보기 때문에 왼쪽 자식으로 들어가 후 자신을 출력하고 오른쪽 자식 재귀로 들어가기
		in += x;
		inOrder(tree[x - 'A'][1]);
	}

	private static void postOrder(char x) {
		if (x == '.')
			return;
		postOrder(tree[x - 'A'][0]); // root를 마지막에 보기 때문에 왼쪽 자식 오른쪽 자식을 재귀로 다 보고 자신 출력
		postOrder(tree[x - 'A'][1]);
		post += x;
	}
}
