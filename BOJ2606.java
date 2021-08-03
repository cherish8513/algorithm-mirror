package 스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ2606 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean visited[] = new boolean[101];
	static int cnt;
	
	static void dfs(int x) {
		visited[x] = true;
		cnt++;
		for(int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y])
				dfs(y);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 101; i++) {				// 최대 컴퓨터가 100대까지 입력 된다 했으므로 인덱스 100까지 쓰기 위해 크기를 101로 잡음
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		dfs(1);
		bw.write(cnt - 1 + "\n");		// 처음 1번은 포함하지 말아야 하므로 1 빼줌
		bw.close();
		br.close();
	}
}
