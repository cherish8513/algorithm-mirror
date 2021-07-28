package com.ssafy.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 210728
 * 요세푸스 문제0
 *
 */
public class BOJ_11866 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int K = sc.nextInt();
		System.out.print("<");
		while (queue.size() != 1) {
			for (int i = 0; i < K-1 ; i++) {
				queue.add(queue.poll());
			}
			
			System.out.printf("%d, ", queue.peek());
			queue.remove();
			
//			System.out.println(queue);
			
// K번째 빼고 > K-1 개 뒤로 보내고/// 아니지 K-1개 뒤로 보내고 빼. 
		}
		System.out.println(queue.peek() + ">");
		
	}
}
