package cabbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] visited;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N + 2][M + 2];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[y + 1][x + 1] =  1;
			} // end of for input
			visited = new boolean[N+2][M+2];
			int count = 0;
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < M+1; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		} // end of for testCases
		
	} // end of main

	private static void dfs(int y, int x) {
		// TODO Auto-generated method stub
		if(visited[y][x] || map[y][x] == 0)
			return;
		visited[y][x] = true;
		dfs(y-1, x);
		dfs(y+1, x);
		dfs(y, x-1);
		dfs(y, x+1);
	}
} // end of class
