package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	private static boolean[] visited;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 1<= N <=1000
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수 0<= M <= Nx(N-1)/2
		map = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u-1][v-1] = 1;	
			map[v-1][u-1] = 1;
		}
		
		int ans = 0;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				bfs(i);
				ans++;
			}
		}
//		for (int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		System.out.println(ans);
		
		
	} // end of main

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < N; j++) {
				if(!visited[j] && map[cur][j] == 1) {
					visited[j] = true;
					q.offer(j);
				}
			}
		}
	}
} // end of class
