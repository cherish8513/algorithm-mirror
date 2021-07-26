package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * 제로 재민 재현 - 장부관리 재현 - 잘못된 수를 부르면 0을 외쳐서 최근에 임력한 수를 지움 모든 수의 합
 */
public class BOJ_10773 {
	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<>();
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(BR.readLine()); // throws Exception을 해줘야한다.

		for (int i = 0; i < K; i++) { // 처음 입력받은 값. 개수만큼
			int data = Integer.parseInt(BR.readLine());
			if (data != 0) {
				stack.push(data);
			} else {
				stack.pop();
			}
		}
		
		//System.out.println(stack);
		
		int sum = 0;
		if (stack.size() == 0) {
			System.out.println(sum);
		} else {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
//				System.out.println("for문" + stack);
//				System.out.println(stack.peek());
				sum += stack.peek();
				stack.pop();
			}
			System.out.println(sum);
		}
		
		


	} // end of main
} // end of class
