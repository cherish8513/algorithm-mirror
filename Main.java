package iland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			int[][] map = new int[h + 2][w + 2];
			boolean[][] visited = new boolean[h + 2][w + 2];
			for (int i = 1; i < h + 1; i++) {
				String str = br.readLine();
				for (int j = 1, idx = 0; j < w + 1; j++, idx+=2) {
					map[i][j] = str.charAt(idx)-'0';
					visited[i][j] = false;
				}
			} // end of for input
			int output = 0;
			for (int i = 1; i < h + 1; i++) {
				for (int j = 1; j < w + 1; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(map, visited, i, j);
						output++;
					}
				}
			}
			sb.append(output).append("\n");
		} // end of while testCases
		System.out.println(sb);
	} // end of main

	private static void dfs(int[][] map, boolean[][] visited, int y, int x) {
		// TODO Auto-generated method stub
		if(visited[y][x] || map[y][x] == 0)
			return;
		else {
		visited[y][x] = true;
		dfs(map, visited, y + 1, x);
		dfs(map, visited, y + 1, x + 1);
		dfs(map, visited, y + 1, x - 1);
		dfs(map, visited, y, x + 1);
		dfs(map, visited, y, x - 1);
		dfs(map, visited, y - 1, x);
		dfs(map, visited, y - 1, x + 1);
		dfs(map, visited, y - 1, x - 1);
		}
	}
} // end of class
