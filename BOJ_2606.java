package com.ssafy.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 바이러스 
 * @author me
 * BFS DFS
 * 210804
 */
public class BOJ_2606 {
	public static boolean[] visited;
    public static int node[][]; // 인접행렬 배열
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		
		node = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		bfs(1);
		
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.offer(start);
		int cnt = 0; // 감염 된 컴퓨터
		
		while(!queue.isEmpty()) {
			// 큐에서 하나의 원소를 뽑아 출력
			int x = queue.poll();
//			System.out.print(x + " ");
			// 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
			for(int i=1;i<node.length;i++) { 
				if(node[x][i]==1 && visited[i]!=true) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt); 
	}
}
