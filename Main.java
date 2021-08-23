package baekjoon_11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int MAP_SIZE;
	private static int[][] map;
	private static int[][] dpMemoization;
	private static int outOfRange = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		MAP_SIZE = Integer.parseInt(st.nextToken());
		map = new int[MAP_SIZE+2][MAP_SIZE+2];
		int T = Integer.parseInt(st.nextToken());
		for(int i = 1; i < MAP_SIZE+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < MAP_SIZE+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dpMemoization = new int[MAP_SIZE+2][MAP_SIZE+2];
		saveMemoization(MAP_SIZE, MAP_SIZE); // 끝 지점부터 시작지점까지 순회
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int srcX = Integer.parseInt(st.nextToken());
			int srcY = Integer.parseInt(st.nextToken());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			int resultOfSum = dpMemoization[destX][destY] 
							- dpMemoization[srcX-1][destY]
							- dpMemoization[destX][srcY-1]
							+ dpMemoization[srcX-1][srcY-1];
			sb.append(resultOfSum).append("\n");
		}
		System.out.println(sb);
	}

	private static int saveMemoization(int srcX, int srcY) {
		// TODO Auto-generated method stub
		if(srcX == outOfRange || srcY == outOfRange)
			return 0;
		if(dpMemoization[srcY][srcX] != 0)
			return dpMemoization[srcY][srcX];
		
		return dpMemoization[srcY][srcX] = map[srcY][srcX] + saveMemoization(srcX-1, srcY)
										 + saveMemoization(srcX, srcY-1) - saveMemoization(srcX-1, srcY-1);
	}
}
