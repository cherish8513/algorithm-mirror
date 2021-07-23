/**
 * Stack
 * Last In First Out 구조
 * 인터럽트처리, 수식의계산, 서브루틴의 복귀 번지 저장에 쓰임
 * 그래프의 깊이 우선탐색(DFS)에서 사용
 * 재귀적(Recursion) 함수 호출 시 사용
 */
package study;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10828_Stack {
	public static void main(String[] args) {
//		정수 저장 스택 구현
//		push
//		pop : 스택 가장 위의 정수 빼고 출력 if (정수 없음) -> -1 출력
//		size : 스택안의 정수개수
//		empty : 비어있으면 1 아니면 0
//		top : 스택 가장 위의 정수 출력 if(정수 없음) -> -1 출력

		Stack<Integer> stack = new Stack<>(); // int형 스택 선언
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 명령의 수
		
		for (int i = 0; i < N; i++) {
			String command = sc.next();
			
			// nextLine();
			switch (command) {
			case "push":
				int num = sc.nextInt();
				stack.push(num); // 스택에 값 추가
				N++;
				break;

			case "pop":
				if (stack.empty() != true) { // 스택 비어있는지 check
					System.out.println(stack.peek()); // 빼기 전 상단 값 출력
					stack.pop(); // 가장 위쪽의 값 제거
				} else {
					System.out.println(-1);
				}
				break;

			case "size":
				System.out.println(stack.size());
				break;

			case "empty":
				int empty = (stack.empty()==true)?1:0;
				System.out.println(empty);
				break;

			case "top":
				if (stack.empty() != true) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				break;
			}

		}

	} // end of main
} // end of class


