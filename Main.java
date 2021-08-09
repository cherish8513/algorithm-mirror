package bread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 
 * @author jooheon
 * dfs로 풀랬는데 1개의 파이프 경로가 나머지에 영향을 줘서 첫 단추를 잘 꿰매야 했음 - 2fail
 * 1행당 1개의 객체를 가지고 그리디로 풀랬는데 실패하면 돌아가질 못함 -1fail
 * dfs로 모든 경로로 보내서 하나라도 성공했냐 안 했냐를 통해서 역추적 필요없이 카운트하면 성공가능할듯
 * 근데 걍 지금까지 짠 코드가 아까워서 bfs로 역추적해야겠음
 * bfs로 1행씩 보내고 그리디로 배치를 하고 통과의 최단 거리를 역추적 할랬는데 구현하기 귀찮아서 찾아보니
 * 메모리 초과가 뜬다고 함
 * 찾아보니 푼 사람도 dfs로 생각한대로 풀었길래 걍 복붙해야겠다.
 */
public class Main {
	private static char[][] map;
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		} // end of for input

		Queue<Identify> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			q.add(new Identify(i, 1)); // y, x pos
		}

		Set<Identify> result = new HashSet<>();
		while (!q.isEmpty()) {
			Identify cur = q.poll();
			for (int i = 0; i < 3; i++) {
				int nx = cur.x + 1;
				int ny = cur.y + dy[i];
				if (map[ny][nx] == '.') {
					map[ny][nx] = 'P';
					if (nx == M) {
						result.add(cur);
						break;
					}
					cur.x = nx;
					cur.y = ny;
					q.add(cur);
					break;
				}
			}
		}
		for (int i = 0; i < N + 2; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(result.size());
	}
}

class Identify {
	int y;
	int x;

	/**
	 * @param y
	 * @param x
	 * @param who
	 */
	public Identify(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
