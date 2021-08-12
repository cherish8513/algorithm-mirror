package backjoon_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<Character> list = new ArrayList<Character>();
	static int N;
	static long minResult = Long.MAX_VALUE;
	static long maxResult = Long.MIN_VALUE;
	static int[] oper = new int[4];
	private static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
//		int[] candidate = new int[N - 1];
		search(1, nums[0]);
		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void search(int idx, int result) {
		// TODO Auto-generated method stub
		if (idx == N) {
			maxResult = Math.max(maxResult, result);
			minResult = Math.min(minResult, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				oper[i]--;
				if (i == 0)
					search(idx+1, result + nums[idx]);
				if (i == 1)
					search(idx+1, result - nums[idx]);
				if (i == 2)
					search(idx+1, result * nums[idx]);
				if (i == 3)
					search(idx+1, result / nums[idx]);
				oper[i]++;
			}
		}

	}

//	private static void search(int depth, int[] candidate) {
//		// TODO Auto-generated method stub
//		if (depth == N - 1) {
//			Stack<Integer> stack = new Stack<>();
//			for (int i = N - 1; i >= 0; i--) {
//				stack.push(nums[i]);
//			}
//			for (int i = 0; i < N - 1; i++) {
//				int first = stack.pop();
//				int second = stack.pop();
//				if (candidate[i] == 0)
//					first += second;
//				if (candidate[i] == 1)
//					first -= second;
//				if (candidate[i] == 2)
//					first *= second;
//				if (candidate[i] == 3)
//					first /= second;
//				stack.push(first);
//			}
//			int curResult = stack.pop();
//			maxResult = Math.max(curResult, maxResult);
//			minResult = Math.min(curResult, minResult);
//			return;
//		}
//		for (int i = 0; i < 4; i++) {
//			if (oper[i] != 0) {
//				candidate[depth] = i;
//				oper[i]--;
//				search(depth + 1, candidate);
//				oper[i]++;
//			}
//		}
//	}
}
