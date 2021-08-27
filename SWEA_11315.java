package 한번더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 210826
 * 오목판정
 * D3
 * 돌이 다섯개 이상 연속하는 부분이 있으면 YES 아님 NO
 */
public class SWEA_11315 {
	private static int[] dr = {-1,-1,0,1,1,1,0,-1}; // 상 우상 우 우하 하 좌하 좌 좌상
	private static int[] dc = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) { // 테케 반복
			int N = Integer.parseInt(br.readLine()); // 5<=N<=20
			int[][] omok = new int[N][N]; // 오목판
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					omok[i][j] = str.charAt(j);
				}
			} // data input o는 돌있음 .은 돌없음
			boolean result = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(omok[i][j] == 'o') { // 현재 칸이 돌멩이여야 팔방탐색을 함
						for (int dir = 0; dir < 8; dir++) { // 팔방 탐색을 위한 for문
							for (int count = 1; count < 5; count++) { // 5칸 연속 돌멩인지 확인하는 for
								int nr = i + dr[dir] * count; // *count 해서 건너건너 칸 확인
								int nc = j + dc[dir] * count;
								if(nr<0 || nr>=N || nc<0 || nc>=N || omok[nr][nc]!='o') break;
								else if(count == 4) { // 현재칸에서 네칸 더 가면 다섯칸 돌멩이
									result = true;
								}
							}
						}
					}
				}
			}
//			String res = ;
			System.out.println("#"+testCase+" "+ (result==true?"YES":"NO"));
//			System.out.println(Arrays.deepToString(omok));
		} // end of testCase
	} // end of main
} // end of class

/*
1
5
....o
...o.
..o..
.o...
o....

*/