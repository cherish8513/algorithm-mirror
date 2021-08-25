package com.swea.study.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) { // 테케 반복
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[10]; // 입력된 10개의 수를 저장할 배열
			for (int i = 0; i < 10; i++) { // 입력된 수 배열에 저장
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); // 오름차순 정렬
			
//			sb.append("#").append(testCase).append(" ");
			int avg = 0 ; // 평균값 구할 변수
			for (int i = 1; i < 9; i++) { // 최소값, 최대값 제외한 배열 범위
				avg += arr[i];
			}
			double result  = avg / 8.0;
//			sb.append(avg/8).append("\n");
			System.out.printf("#%d %.0f\n",testCase,result);
		} // end of testCase
//		System.out.println(sb);
	} // end of main
}// end of class

/*
3
3 17 1 39 8 41 2 32 99 2 
22 8 5 123 7 2 63 7 3 46 
6 63 2 3 58 76 21 33 8 1 

*/