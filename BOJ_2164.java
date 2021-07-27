package com.ssafy.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 210727
 * 카드2
 */
public class BOJ_2164 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
			
		}
//		System.out.println(queue);

		while (queue.size() != 1) {
			queue.remove();
			queue.add(queue.peek());
			queue.remove();
		}
		System.out.printf("%d",queue.poll());
	}
}
