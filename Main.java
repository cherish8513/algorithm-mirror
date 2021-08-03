package dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	static int numberOfPoint;
	static StringBuilder sb_bfs = new StringBuilder();
	static StringBuilder sb_dfs = new StringBuilder();
	static boolean[] visited_dfs;
	static boolean[] visited_bfs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numberOfPoint = Integer.parseInt(st.nextToken()); // 정점의 개수
		map.add(null); // 0번 인덱스
		for (int i = 1; i <= numberOfPoint; i++) {
			map.add(new ArrayList<Integer>());
		} // 1번 ~ N개의 빈공간 생성
		int numberOfEdge = Integer.parseInt(st.nextToken()); // 간선의 개수
		int startPoint = Integer.parseInt(st.nextToken()); // 시작 위치
		for (int i = 0; i < numberOfEdge; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.get(from).add(to);
			map.get(to).add(from); // 양방향
		} // end of input
		
		for(int i = 1; i <= numberOfPoint; i++) {
			Collections.sort(map.get(i));
		} // 정렬
		
		visited_dfs = new boolean[numberOfPoint + 1];
		visited_bfs = new boolean[numberOfPoint + 1];
		for (int i = 1; i <= numberOfPoint; i++) {
			visited_dfs[i] = visited_bfs[i] = false;
		} // 방문 정보 초기화
		
		dfs(startPoint);
		bfs(startPoint);
		System.out.println(sb_dfs);
		System.out.println(sb_bfs);
		br.close();
	}

	public static void dfs(int startPoint) {
		// TODO Auto-generated method stub
		if (!visited_dfs[startPoint]) { // 방문한 적이 없으면
			sb_dfs.append(startPoint + " ");
			visited_dfs[startPoint] = true;
			for (int nextPoint : map.get(startPoint)) { // 갈 수 있는 정점을 대상으로 dfs
				dfs(nextPoint);
			}
		}

	}

	public static void bfs(int startPoint) {
		// TODO Auto-generated method stub
		Queue<ArrayList<Integer>> q = new LinkedList<>();
		q.add(map.get(startPoint));
		sb_bfs.append(startPoint + " ");
		visited_bfs[startPoint] = true;
		
		while (!q.isEmpty()) {
			ArrayList<Integer> curPoint = q.poll();
			for (int nextPoint : curPoint) { // 갈 수 있는 정점들이
				if(!visited_bfs[nextPoint]) { // 방문한 적 없다면
					visited_bfs[nextPoint] = true;
					sb_bfs.append(nextPoint + " ");
					q.add(map.get(nextPoint));
				}
			}
		}
	}
}