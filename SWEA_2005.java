package com.ssafy.study;

import java.util.Scanner;

public class SWEA_2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt(); // 테케
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // 파스칼 삼각형의 크기. 1이상 10 이하
			int[][] pascal = new int[N][N];
			
			sb.append("#").append(testCase).append("\n");
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i+1; j++) {
					if(i==j || j==0) {	 
						pascal[i][j] = 1;  // 삼각형 왼쪽 오른쪽 가장자리부분은 전부 1
						sb.append(pascal[i][j]+" ");
					}else {
						if(i-1>=0 && j-1>=0) { // 범위 안에서
							pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]; // 위쪽의 값들을 더한 값
							sb.append(pascal[i][j]+" ");
						}
					}
				}
				sb.append("\n");
			}
			
		} // end of testCase
		System.out.println(sb.toString());
	} // end of main
} // end of class
 