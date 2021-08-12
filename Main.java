package backjoon_1520_decend;

import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int[][] map;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 2][M + 2];
		dp = new int[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				map[i][j] = 10001;
			}
		} // 테두리 10001로 초기화
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		} // end of for input
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(1, 1, 10001));
	}// end of main

	private static int dfs(int i, int j, int height) {
		// TODO Auto-generated method stub
		
		if(i == N && j == M && height > map[i][j]) {
			return 1;
		}
		
		if(map[i][j] >= height)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];
		
		return dp[i][j] = dfs(i - 1, j, map[i][j]) + dfs(i + 1, j, map[i][j]) + 
				dfs(i, j - 1, map[i][j]) + dfs(i, j + 1, map[i][j]);
	}
} // end of class
