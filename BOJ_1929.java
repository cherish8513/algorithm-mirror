package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 211110
 * 소수 구하기
 */
public class BOJ_1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken()); //1 ≤ M ≤ N ≤ 1,000,000
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		boolean[] num = new boolean[1000001];
		for (int i = 2; i <= 1000; i++) {
			if(!num[i]) {
				for (int j = i+1; j < 1000001; j++) {
					if(!num[j] && j%i==0) num[j] = true;
				}
			}
		}
		num[1] = true;
		for (int i = M; i <= N; i++) {
			if(!num[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
