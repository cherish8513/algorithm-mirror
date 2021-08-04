package danji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<Integer> result = new ArrayList<>();
	static int count;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];

		for (int i = 1; i < N+1; i++) {
			String str = br.readLine();
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j-1) + "");
				visited[i][j] = false;
			}
		} // end of input
		
		for(int i = 0; i < N+2; i++) {
			for(int j = 0; j < N+2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(i, j);
					result.add(count);
				}
			}
		} // end of calculate
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i : result) {
			System.out.println(i);
		}
	} // end of main

	public static void dfs(int y, int x) {
		// TODO Auto-generated method stub
		if (map[y][x] == 0 || visited[y][x])
			return;
		count++;
		visited[y][x] = true;
		dfs(y+1, x);
		dfs(y-1, x);
		dfs(y, x-1);
		dfs(y, x+1);

	}
} // end of class
