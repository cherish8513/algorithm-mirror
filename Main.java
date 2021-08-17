package baekjoon_9465_스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			for(int i = 0; i< 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of for input
			
			int[][] dp = new int[2][n + 2]; // 알고리즘 일반화를 위해 2칸 추가
			for(int i = 2; i < n+2; i++) {
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + arr[0][i-2];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + arr[1][i-2];
			}
			sb.append(Math.max(dp[1][n+1], dp[0][n+1])).append("\n");
		} // end of testCases
		System.out.println(sb);
	} // end of main
} // end of class
