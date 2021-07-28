package yosepus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * @author jooheon
 * Since 2021.07.28
 * 요세푸스 수열 출력
 *
 */
public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(); // PriorityQueue로 받으면 Stack과 거의 같다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i = 1 ; i <= N; i++) { // Queue에 1부터 N까지 넣는다.
			q.add(i);
		}
		StringBuilder sb = new StringBuilder(); // 출력 결과용 StringBuilder 준비
		sb.append("<"); // 첫 문자인 < 저장
		while(!q.isEmpty()) {
			for(int i = 0; i < K-1; i++) { // K-1 횟수만큼 빼고 맨 뒤로 넣는다.
				int num = q.poll();
				q.add(num);
			}
			sb.append(q.poll() + ", "); // K번째를 빼고 StringBuilder에 저장
		}
		sb.deleteCharAt(sb.lastIndexOf(",")); // 마지막 ,를 지운다.
		sb.deleteCharAt(sb.lastIndexOf(" ")); // 마지막 공백을 지운다.
		sb.append(">"); // 마지막 문자인 > 저장
		System.out.println(sb); // 출력
		sc.close();
	}
}
