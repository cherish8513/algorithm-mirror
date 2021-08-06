package miro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int y_pos = 0;
	static int x_pos = 1;
	static int distance = 2;
	static int[] dy = {0, 0, 1, -1}; 
	static int[] dx = {1, -1, 0, 0}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+2][M+2]; // char 맵 테두리 포함 생성
		for (int i = 1; i < N+1; i++) {
			String str = br.readLine();
			for (int j = 1; j < M+1; j++) {
				map[i][j] = str.charAt(j-1); // 입력값이 char
			}
		} // end of for input

		boolean[][] visited = new boolean[N+2][M+2]; // 방문정보 기본 값이 false
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] {1, 1, 1}); // y, x, distance
		visited[1][1] = true; // 처음 좌표 방문 true
		while(!q.isEmpty()) {
			Integer[] pos = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = pos[y_pos] + dy[i]; // 전역 변수로 y_pos = 0
				int nx = pos[x_pos] + dx[i]; // 전역 변수로 x_pos = 1
				int dist = pos[distance] + 1; // 전역 변수로 distance = 2
				if(ny == N && nx == M) { // 도착 지점이면
					System.out.println(dist); // 출력
					System.exit(0); // 0이 정상 종료 (main이 아니었으면 return)
				}
				else if(map[ny][nx] != '1' || visited[ny][nx]) {
					continue;
				}
				else {
					visited[ny][nx] = true;
					q.add(new Integer[] {ny, nx, dist});
				}
			}
			
		}
	}
}
