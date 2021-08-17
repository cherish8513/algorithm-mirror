package baekjoon_1174_줄어드는_숫자;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int[] candidate;
	private static ArrayList<Long> list;

	public static void main(String[] args) {
		candidate = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // 10개 조합
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<Long>();
		int n = sc.nextInt();
		if(n > 1023) { // 중복 제거하니 들어가는 사이즈가 1024개
			System.out.println(-1);
			System.exit(0);
		}
		search(0, 0);
		list.sort(null); // 자릿수 순서로 정렬
		System.out.println(list.get(n-1));
}
	

	private static void search(long digit, int idx) {
		// TODO Auto-generated method stub
		if(!list.contains(digit)) // 조합인데 중복이 왜 생겼지? 빡치네
			list.add(digit);
		if(idx >= 10) {
			return;
		}
		search((digit * 10) + candidate[idx], idx + 1);
		search(digit, idx + 1);
	}
}
