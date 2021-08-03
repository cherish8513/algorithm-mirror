package com.ssafy.study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 정점(Vertex)과 간선(Edge)으로 이루어진 자료구조
 * G = (V, E)
 * 방향 그래프, 무방향 그래프로 나뉘어진다.
 * 방향 그래프 - 방향이 있는 곳으로만 간다.   
 * 무방향 그래프 - 양쪽 모두 갈 수 있다.
 * 
 * DFS(깊이 우선 탐색) : 재귀 or 스택
 * BFS(너비 우선 탐색) : 큐
 */
// DFS와 BFS
public class BOJ_1260 {

    static int node[][]; // 인접행렬 배열
    static boolean check[]; // 노드의 방문여부 표시 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
        
        // 인접행렬로 그래프를 구현
        node = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) { 

            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(V);
        Arrays.fill(check, false); // DFS 이후 동일한 방문 여부 배열을 사용하기 때문에 다시 false으로 초기화 해준다.
        System.out.println();
        bfs(V);
    }

    // 재귀, 인접행렬
    public static void dfs(int v) {
        int n = node.length - 1;

        check[v] = true; // 방문하지 않은 노드라면 방문여부를 표시
        System.out.print(v + " "); // 출력
        
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 1; i <= n; i++) {
            if (node[v][i] == 1 && !check[i]) { // 방문하지 않은 노드일 경우
                dfs(i); // 해당 노드로 이동
            }
        }
        
    }

    // 큐, 인접행렬
    public static void bfs(int v) {
    	Queue<Integer> q = new LinkedList<>(); // BFS를 위한 큐
    	int n = node.length - 1;

        q.offer(v); // 큐에 시작노드 삽입
        check[v] = true; // 시작 노드에 방문 표시

        while (!q.isEmpty()) { // 공백 큐가 될 때까지 반복
            v = q.poll(); // 큐에서 하나 꺼내기
            System.out.print(v + " "); // 출력

            for (int i = 1; i <= n; i++) { // 큐에서 꺼낸 노드와 연결된 노드를 탐색

                if (node[v][i] == 1 && !check[i]) { // 큐에서 꺼낸 노드와 연결된 노드가 방문하지 않았던 노드이면 
                    q.offer(i); // 큐에 삽입
                    check[i] = true; // 방문 표시
                }
            }
            
        }
    }
}


/*
4 5 1
1 2
1 3
1 4
2 4
3 4

5 5 3
5 4
5 2
1 2
3 4
3 1

1000 1 1000
999 1000

*/