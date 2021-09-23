package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 회의실배정
 * 그리디
 */
public class BOJ_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회의의 개수
		int[][] time = new int[N][2]; // 각 회의의 시작시간 끝시간 저장할 배열
		int cnt = 0;
		int endTime = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
		} // data input
		// 끝나는 시간 기준으로 정렬 <<<<<<<<<<<<<<<<<<<<<<<<
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같으면 시작시간이 빠른순으로 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		for (int i = 0; i < N; i++) {
			// 전의 회의 종료시간이 다음 회의 시작시간보다 작거나 같으면 회의++
			if(endTime <= time[i][0]) {
				endTime = time[i][1]; // 회의의 종료시간
				cnt++; // 진행할수있는 회의
			}
		}
		System.out.println(cnt);
	} // end of main
} // end of class
