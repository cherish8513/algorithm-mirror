package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 211026
 * 저울
 *
 */
public class BOJ_10159 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 물건의 개수
		int M = Integer.parseInt(br.readLine()); // 비교 횟수
		boolean[][] map = new boolean[N][N];
		
		for (int i = 0; i < M; i++) { // 앞의 수가 더 무거움
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = true; // > = true
		}
		for (boolean[] bs : map) {
			System.out.print(Arrays.toString(bs));
			System.out.println();
		}
		// 플로이드 워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == k || k == j) continue;
					if(map[i][k] && map[k][j]) map[i][j] = true; // 연결되서 알 수 있는 정보체크
				}
			}
		}
		System.out.println();
		for (boolean[] bs : map) {
			System.out.print(Arrays.toString(bs));
			System.out.println();
		}
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(!map[i][j] && !map[j][i]) cnt++;
			}
			System.out.println(cnt); // i번쨰 물건과 비교결과를 알 수 없는 것
		}
	} // end of main
} // end of class
