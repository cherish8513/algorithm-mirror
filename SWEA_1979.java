package swea;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 210825 어디에 단어가 들어갈 수 있을까 D2
 * 
 * @author me
 *
 */
public class SWEA_1979 {
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt(); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // 배열의 크기
			int K = sc.nextInt(); // 단어의 길이
			int[][] m = new int[N][N]; // 퍼즐 배열 생성
			visited = new boolean[N][N]; // 방문여부 체크
			for (int i = 0; i < N; i++) { // 퍼즐 상태 input
				for (int j = 0; j < N; j++) {
					m[i][j] = sc.nextInt();
				}
			} // input data
			int result = 0;
			int count = 0;
			
			sb.append("#").append(testCase).append(" ");
			// 가로
			for (int i = 0; i < N; i++) {
				count = 0;
				for (int j = 0; j < N; j++) {
					if(m[i][j] == 0) { // 검은색일때  count 체크
						if(count == K) // 흰 칸 수와 단어 길이 비교
							result++;
						count = 0; // count 세던거 초기화
					} else // 흰색
						count++;
				} 
				if(count == K) // 한 행이 끝나고 count 체크
					result++;
			}
			// 세로
			for (int j = 0; j < N; j++) {
				count = 0;
				for (int i = 0; i < N; i++) {
					if(m[i][j] == 0) {
						if(count == K)
							result++;
						count = 0;
					} else
						count++;
				}
				if(count == K)
					result++;
			}
			
			// 중간 값부터 세면 칸 수가 중복된다.

//			System.out.println(result);
			sb.append(result).append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class

/*
1
5 3
0 0 1 1 1
1 1 1 1 0
0 0 1 0 0
0 1 1 1 1
1 1 1 0 1

1
5 3
1 0 0 1 0
1 1 0 1 1
1 0 1 1 1
0 1 1 0 1
0 1 1 1 0 

 */