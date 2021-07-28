package trafic;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author jooheon
 * Since 2021.07.28
 * 11116 교통량 문제
 * 입력값은 최대 20만개
 * 가능한 알고리즘은 O(N^2)
 * 첫 번째 배열 탐색 값 + 1500이 두 번째 배열 탐색 값에 없다면 종료 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int[] count = new int[T]; 
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			int[] left = new int[N];
			int[] right = new int[N];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int i = 0; i < N; i++) {
				left[i] = Integer.parseInt(st.nextToken());
			} // end of input of first array
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0; i < N; i++) {
				right[i] = Integer.parseInt(st.nextToken());
			} // end of input of second array
			boolean check = false;
			for(int i = 0; i < N; i++) {
				if(check)
					break;
				for(int j = 0; j < N; j++) {
					if(left[i] + 1500 == right[j]) {
						count[t]++;
						check = false;
						break;
					}
					check = true;
				}
			}
		}
		for(int c : count)
			System.out.println(c);
		sc.close();
	}
}
