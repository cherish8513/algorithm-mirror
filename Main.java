package backjoon_1890_jump_hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static long[][] dp;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of for input
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		} // 덧셈 해야하니 -1로 초기화
		System.out.println(dfs(0, 0));
	}

	private static long dfs(int i, int j) {
		// TODO Auto-generated method stub
		if (i == N - 1 && j == N - 1)
			return 1;
		if (i >= N || j >= N || map[i][j] == 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		return dp[i][j] = dfs(i + map[i][j], j) + dfs(i, j + map[i][j]);
	}

}
