package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 211026
 * 용돈 관리
 *
 */
public class BOJ_6236 {
	private static int N;
	private static int M;
	private static int[] days;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 날짜
		M = Integer.parseInt(st.nextToken()); // 인출 횟수
		days = new int[N]; // 하루에 쓰는 비용
		int min = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(br.readLine());
			min = min < days[i] ? days[i] : min; // 최대값이 K의 최소값
			max += days[i]; // 비용의 합 = K의 최대값 
		}
		
		while(min <= max) {
			int mid = (min + max) / 2;
			if(mcount(mid) > M) { // mid 일 때 인출 횟수가 M보다 크면 K값의 최소값을 올려줘야돼
				min = mid + 1;
			}else {
				K = mid;
				max = mid - 1;
			}
		}
		// K를 어떻게 구할?
		
		System.out.println(K);
	} // end of main

	private static int mcount(int mid) {
		int cnt = 1;
		K = mid;
		for (int i = 0; i < N; i++) {
			if(days[i] <= K) {
				K -= days[i];
			}else { // 돈 모자란 하루
				cnt++;
				K = mid; // 새로 인출
				K -= days[i];
			}
		}
		return cnt;
	}
	
	
} // end of class

// 처음에 mcount 개수 셀 생각말고 K를 구해올 생각을 했었다.
