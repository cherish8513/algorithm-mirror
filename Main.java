package escape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int y_pos = 0;
	static int x_pos = 1;
	static int dist = 2;
	static int who = 3;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int water = 1;
		int dochi = 0;
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		Integer[] d = { 0, 0, 0, dochi }; // 고슴도치
		int dest_y = 0;
		int dest_x = 0;
		char[][] map = new char[N + 2][M + 2]; // 테두리 막 1개 추가
		boolean[][] visited = new boolean[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = str.charAt(j - 1);
				if (map[i][j] == '*') {
					q.add(new Integer[] { i, j, 0, water }); // 물 정보 큐에 넣기
					visited[i][j] = true; // 물 시작 위치 방문
				}
				if (map[i][j] == 'S') {
					d[y_pos] = i;
					d[x_pos] = j;
					visited[i][j] = true; // 고슴도치 시작 위치 방문
				}
				if (map[i][j] == 'D') {
					dest_y = i;
					dest_x = j;
				}
			}
		} // end of for input

		q.add(d); // 고슴도치 큐에 넣기
		while (!q.isEmpty()) {
			Integer[] cur = q.poll();
			if (cur[who] == dochi) { // 고슴도치의 경우
				for (int i = 0; i < 4; i++) { // 4방향에 대해서 이동해보기
					int ny = cur[y_pos] + dy[i];
					int nx = cur[x_pos] + dx[i];
					int minute = cur[dist] + 1;
					if (ny == dest_y && nx == dest_x) { // 이동한 결과 값이 목적지면 출력하고 종료
						System.out.println(minute);
						System.exit(0);
					}
					if (map[ny][nx] != '.' || visited[ny][nx]) // 방문했거나 .이 아니면 컨티뉴
						continue;
					else {
						visited[ny][nx] = true; // 다음 시작점의 방문 정보를 미리 true 해둬야 됨(예약 같은 방식)
												// Queue특성상 미리 방문 정보를 true로 안 바꾸면 꺼내지기 전에 방문이 겹칠 수 있음
						q.add(new Integer[] { ny, nx, minute, dochi });
					}
				}
			} else if (cur[who] == water) { //물의 경우
				for (int i = 0; i < 4; i++) {
					int ny = cur[y_pos] + dy[i];
					int nx = cur[x_pos] + dx[i];

					if (map[ny][nx] != '.' || visited[ny][nx])
						continue;
					else {
						map[ny][nx] = '*';
						visited[ny][nx] = true;
						q.add(new Integer[] { ny, nx, 0, water });
					}
				}
			}
		} // end of while BFS
		System.out.println("KAKTUS"); // 큐를 다 돌렸는데도 못 가는 경우 fail
	} // end of main
} // end of class
