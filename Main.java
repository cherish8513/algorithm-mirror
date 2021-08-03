package virus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCom = sc.nextInt();
		int numbefOfEdge = sc.nextInt();
		map.add(null); // 0번 인덱스
		for(int i = 0; i < numberOfCom; i++) {
			map.add(new ArrayList<Integer>());
		} // ArrayList 초기화
		for(int i = 0; i < numbefOfEdge; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map.get(from).add(to);
			map.get(to).add(from); // 양방향
		} // end of input
		visited = new boolean[numberOfCom + 1];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		} // 방문정보 초기화
		dfs(1);
		System.out.println(result);
	}

	public static void dfs(int startPoint) {
		// TODO Auto-generated method stub
		if(!visited[startPoint]) {
			visited[startPoint] = true;
			result++;
			for(int nextPoint : map.get(startPoint)) {
				dfs(nextPoint);
			}
		}
	}
	
}
