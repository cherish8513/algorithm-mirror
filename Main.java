package lie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 
 * @author jooheon
 * 사람과 파티를 같은 노드로 보고 진실을 아는 사람 -> 파티 -> 파티에 참석한 사람들 -> 파티 -> ... 방식으로 DFS 탐색
 * 진실된 자들끼리 연결시켜서 1명만 DFS 탐색 하면 되게 변경 (유니온 파인드)
 *
 */
public class Main {
	static List<ArrayList<Integer>> map = new ArrayList<>();
	static int numberOfPerson;
	static int numberOfParty;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numberOfPerson = Integer.parseInt(st.nextToken());
		numberOfParty = Integer.parseInt(st.nextToken()); // 사람의 수 N과 파티의 수 M
		st = new StringTokenizer(br.readLine(), " ");
		int[] numberOfStartPos = new int[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < numberOfStartPos.length; i++)
			numberOfStartPos[i] = Integer.parseInt(st.nextToken()); // 이야기의 진실을 아는 사람의 수와 번호
		map.add(null); // 0번 인덱스
		for (int i = 0; i < numberOfPerson + numberOfParty; i++) {
			map.add(new ArrayList<Integer>());
		} // map 초기화

		for (int party_idx = 1; party_idx <= numberOfParty; party_idx++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			while (st.hasMoreTokens()) { // 1차원 배열에 사람들 순서대로 들어가고 그 다음에 파티가 들어감
				int person = Integer.parseInt(st.nextToken());
				map.get(person).add(party_idx + numberOfPerson); // 사람에서 파티로
				map.get(party_idx + numberOfPerson).add(person); // 파티에서 사람으로 연결
			}
		} // end of input
		visited = new boolean[numberOfPerson + numberOfParty + 1]; //사람과 파티의 방문정보 입력 (1번 인덱스부터라서 + 1 해줌)
		for (int i = 0; i < numberOfParty + numberOfPerson + 1; i++) {
			visited[i] = false;
		}
		
		if(numberOfStartPos.length > 0) { // 진실을 아는 자 1명에 나머지 진실을 아는 자 연결
			for (int i = 1; i < numberOfStartPos.length; i++) {
				map.get(numberOfStartPos[0]).add(numberOfStartPos[i]);
			}
			dfs(numberOfStartPos[0]);
		}
//		for (int i = 0; i < numberOfStartPos.length; i++) {
//			dfs(numberOfStartPos[i]);
//		}
		
		int result = 0;
		for (int i = numberOfPerson + 1; i < numberOfParty + numberOfPerson + 1; i++) { // 진실을 아는 자가 없는 파티의 수 출력
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