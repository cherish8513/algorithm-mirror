package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_11724_연결요소의개수_김동규 {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int V, E;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[V + 1];
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < E; i++) {	// x에서 y, y에서 x 둘다 넣기. 방향성 없음
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}	// end of input
		
		int cnt = 0;
		for(int i = 1; i <= V; i++) {
			if(dfs(i)) cnt++;		// dfs 가능하면 카운팅
		}
		System.out.println(cnt);
		
	}
	private static boolean dfs(int x) {
		if (visited[x]) return false;	// 방문한적 있으면 이미 했으므로 false
		visited[x] = true;
		for(int i = 0; i < graph.get(x).size(); i++) {	// x에 연결된 애들 다 방문
			dfs(graph.get(x).get(i));
		}
		return true;
	}
}
