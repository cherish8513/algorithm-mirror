package lie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<ArrayList<Integer>> map = new ArrayList<>();
	static int numberOfPerson;
	static int numberOfParty;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numberOfPerson = Integer.parseInt(st.nextToken());
		numberOfParty = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] numberOfStartPos = new int[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < numberOfStartPos.length; i++)
			numberOfStartPos[i] = Integer.parseInt(st.nextToken()); // dfs 위치들 입력받음
		map.add(null); // 0번 인덱스
		for (int i = 0; i < numberOfPerson + numberOfParty; i++) {
			map.add(new ArrayList<Integer>());
		} // map 초기화

		for (int i = 1; i <= numberOfParty; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			while (st.hasMoreTokens()) {
				int person = Integer.parseInt(st.nextToken());
				map.get(person).add(i + numberOfPerson);
				map.get(i + numberOfPerson).add(person);
			}
		} // end of input
		visited = new boolean[numberOfPerson + numberOfParty + 1];
		for (int i = 0; i < numberOfParty + numberOfPerson + 1; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < numberOfStartPos.length; i++) {
			dfs(numberOfStartPos[i]);
		}
		int result = 0;
		for (int i = numberOfPerson + 1; i < numberOfParty + numberOfPerson + 1; i++) {
			if(visited[i] == false)
				result++;
		}
		System.out.println(result);
	}

	public static void dfs(int startPoint) {
		// TODO Auto-generated method stub
		if (!visited[startPoint]) {
			visited[startPoint] = true;
			for (int nextPoint : map.get(startPoint)) {
				dfs(nextPoint);
			}
		}
	}
}