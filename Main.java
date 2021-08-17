package baekjoon_19236_청소년상어;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int n;
	private static int died = -1;
	private static int shark = 0;
	private static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	private static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int max_cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 4;
		int[][] map = new int[n + 2][n + 2];
		List<Integer[]> fishs = new ArrayList<Integer[]>();
		for (int i = 0; i <= 16; i++) {
			fishs.add(new Integer[] { 0, 0, 0, 0 });
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = sc.nextInt();
				Integer[] fish = fishs.get(map[i][j]);
				fish[0] = i;
				fish[1] = j;
				fish[2] = sc.nextInt() - 1;
			}
		}
		start(1, 1, 0, map, fishs);
		System.out.println(max_cnt);
		sc.close();
	}

	private static void start(int y, int x, int cnt, int[][] map, List<Integer[]> fishs) {
		cnt += map[y][x]; // 현재 위치의 물고기 먹음
		max_cnt = Math.max(cnt, max_cnt); // 카운트 갱신
		int sharkDir = fishs.get(map[y][x])[2]; // 먹은 물고기의 방향 가짐
		fishs.get(map[y][x])[3] = died; // 먹은 물고기의 상태를 쥬금으로 바꿈
		map[y][x] = shark; // 먹은 물고기 위치를 상어로 바꿈
		for (int i = 1; i <= 16; i++) { // 1번 부터 16번 물고기 이동
			Integer[] fish = fishs.get(i);
			int fish_y = fish[0];
			int fish_x = fish[1];
			int fish_dir = fish[2];
			int fish_status = fish[3];
			if (fish_status != died) { //죽은 물고기가 아니라면
				for (int j = fish_dir; j < fish_dir + 8; j++) { // 현재 물고기 방향에서 45씩 8회전
					int ny = fish_y + dy[j % 8];
					int nx = fish_x + dx[j % 8];
					if (map[ny][nx] != shark) { // 상어 없으면 이동
						fish[0] = ny; // 물고기의 위치와 방향 재설정
						fish[1] = nx;
						fish[2] = j % 8;
						if (map[ny][nx] != died) { // 죽은 애가 아니면
							Integer[] swap_fish = fishs.get(map[ny][nx]); // 있던 물고기 데리고옴
							swap_fish[0] = fish_y; // 있던 물고기의 좌표 변경해서 저장
							swap_fish[1] = fish_x;
						}
						int temp = map[ny][nx]; // map의 물고기 위치 변경
						map[ny][nx] = map[fish_y][fish_x];
						map[fish_y][fish_x] = temp;
						break;
					}
				}
			}
		}
		
		map[y][x] = died; // map의 상어가 떠난 자리는 쥬금으로 변경
		int sy = y + dy[sharkDir];
		int sx = x + dx[sharkDir];
		while (sy < n + 1 && sy > 0 && sx < n + 1 && sx > 0) {
			if (map[sy][sx] != died)
				start(sy, sx, cnt, copy_map(map), copy_fishs(fishs));
			sy += dy[sharkDir];
			sx += dx[sharkDir];
		}
		return;
	}

	private static List<Integer[]> copy_fishs(List<Integer[]> fishs) { // addAll로 카피할랬다가 2시간 날림
		List<Integer[]> list = new ArrayList<Integer[]>();
		for(int i = 0; i < fishs.size(); i++) {
			list.add(new Integer[] {fishs.get(i)[0], 
					fishs.get(i)[1], fishs.get(i)[2], fishs.get(i)[3]});
		}
		return list;
	}

	private static int[][] copy_map(int[][] map) {
		int[][] cp_map = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				cp_map[i][j] = map[i][j];
			}
		}
		return cp_map;
	}
}
