package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 역사
 *
 */
public class BOJ_1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 사건의 개수
		int K = Integer.parseInt(st.nextToken()); // 관계 개수
		boolean[][] check = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()); // 전
			int b = Integer.parseInt(st.nextToken()); // 후
			check[a-1][b-1] = true;
		}
//		for (boolean[] bs : check) {
//			System.out.print(Arrays.toString(bs));
//			System.out.println();
//		}
//		System.out.println();
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==k || j==k) continue;
					if(check[i][k] && check[k][j]) check[i][j] = true;
				}
			}
		}
		
//		for (boolean[] bs : check) {
//			System.out.print(Arrays.toString(bs));
//			System.out.println();
//		}
		int S = Integer.parseInt(br.readLine()); // 알고싶은 관계 개수
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(check[a-1][b-1])	// a > b
				System.out.println(-1);
			else if(check[b-1][a-1]) { // b > a
				System.out.println(1);
			}else
				System.out.println(0);
		}
	} // end of main
} // end of class


/*
5 5
1 2
1 3
2 3
3 4
2 4
3
1 5
2 4
3 1

*/