package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int[] dr = {-1,-1,-1, 0, 1, 1, 1, 0}; // 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
	static int[] dc = {-1, 0, 1, 1, 1, 0,-1,-1};
	static int w; // 너비
	static int h; // 높이
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt = 0; // 섬의 개수
			
			if(w==0 && h==0) break; // 0 0 입력받으면 while 끝
			
			map = new int[h+1][w+1]; // 높이가 행, 너비가 열
			visited = new boolean[h+1][w+1]; // 방문 여부 확인
			
			// map 초기화
			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) { // 현재 위치가 땅이고 방문하지 않았다면
						cnt += dfs(i, j);
					}
				} // end of j
			} // end of i
			System.out.println(cnt);
		} // end of while
	} // end of main

	private static int dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int d = 0; d < 8; d++) { // delta
			int di = i + dr[d];
			int dj = j + dc[d];
			if (di>0 && di<=h && dj>0 && dj<=w) {
				if(map[di][dj] == 1 && !visited[di][dj])
					dfs(di,dj);
			}
		}
		return 1;
	}
} // end of class


/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

*/