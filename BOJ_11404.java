package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 플로이드
 *
 */
public class BOJ_11404 {
	private static int N, M;
	public static int[][] D;
	public static final int INF = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		D = new int[N+1][N+1]; // 인덱스 = 도시번호
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j) D[i][j] = INF; // 연결되지 않은것을 무한으로 설정해서 비용많게할라구
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken()); // 시작도시
			int end = Integer.parseInt(st.nextToken()); // 도착도시
			int cost = Integer.parseInt(st.nextToken()); // 비용
			
			D[start][end] = Math.min(D[start][end], cost); // 비용이 적게 드는걸로 인접행렬을 만듦
		}
		// i시작 > k거쳐서 > j도착 
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
//			for (int[] a : D) {
//				System.out.println(Arrays.toString(a));
//			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(D[i][j]==INF) D[i][j] = 0;
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
	} // end of main
} // end of class
