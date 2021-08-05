package tree_diameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static int longest_node_idx = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfPoint = Integer.parseInt(br.readLine());
		List<ArrayList<Info>> map = new ArrayList<>();
		map.add(null); // 0번째 버림
		for (int i = 0; i < numberOfPoint; i++) {
			map.add(new ArrayList<>());
		} // map 초기화
		StringTokenizer st;
		for (int i = 1; i <= numberOfPoint; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to != -1) {
					int distance = Integer.parseInt(st.nextToken());
					map.get(from).add(new Info(to, distance));
					map.get(to).add(new Info(from, distance));
				}
			}
		} // end of input
		boolean[] visited = new boolean[numberOfPoint + 1];
		for (int i = 0; i < numberOfPoint + 1; i++) {
			visited[i] = false;
		}
		dfs(map, 1, 0, Arrays.copyOfRange(visited, 0, numberOfPoint + 1));
		dfs(map, longest_node_idx, 0, Arrays.copyOfRange(visited, 0, numberOfPoint + 1));

		System.out.println(result);
		br.close();
	}

	private static void dfs(List<ArrayList<Info>> map, int startPoint, int cur_dist, boolean[] visited) {
		// TODO Auto-generated method stub
		if (visited[startPoint]) {
			return;
		} else {
			visited[startPoint] = true;
			if(result < cur_dist) {
				result = cur_dist;
				longest_node_idx = startPoint;
			}
			for (Info linkedNode : map.get(startPoint))
				dfs(map, linkedNode.to, cur_dist + linkedNode.distance, visited);
		}
	}
}

class Info {
	public int to;
	public int distance;

	/**
	 * @param to
	 * @param distance
	 */
	public Info(int to, int distance) {
		this.to = to;
		this.distance = distance;
	}
}