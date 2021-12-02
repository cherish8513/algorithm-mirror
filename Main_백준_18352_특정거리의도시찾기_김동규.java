package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_18352_특정거리의도시찾기_김동규 {
	
	static int V, E, K, X;
	static ArrayList<ArrayList<Integer>> graph;		// 특정 번호에서 갈 수 있는 애들을 저장하므로 graph[현위치][갈수있는정점] 형태
	static ArrayList<Integer> result;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		visited = new boolean[V + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		result = new ArrayList<Integer>();
		for(int i = 0; i <= V; i++) {				// graph 형태의 bfs에서 꼭 알아야 되는 기본 세팅
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);				// 방향이 있는 그래프이기 때문에 하나만 씀. 방향이 없다면 graph.get(y).add(x)도 추가해야 됨
		}	// end of input
		
		bfs(X);
		if(result.isEmpty()) {
			System.out.println(-1);
			System.exit(0);
		}
		Collections.sort(result);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static void bfs(int start) {
		Queue<Info> Q = new LinkedList<Info>();
		Q.add(new Info(start, 0));
		visited[start] = true;
		
		while(!Q.isEmpty()) {
			Info I = Q.poll();
			int x = I.x;
			int dis = I.dis;
			
			if (dis == K) result.add(x);
			for(int i = 0; i < graph.get(x).size(); i++) {	// x에서 뻗어나갈 수 있는 애들 만큼 조회
				if(!visited[graph.get(x).get(i)]) {			// 방문한적 없으면 가보기
					Q.add(new Info(graph.get(x).get(i), dis + 1));
					visited[graph.get(x).get(i)] = true;	// 현재 dis 저장된 값이 최단거리이므로 재확인 방지용
				}
			}
		}
	}
	
}
class Info {
	int x, dis;

	public Info(int x, int dis) {
		super();
		this.x = x;
		this.dis = dis;
	}
	
}
