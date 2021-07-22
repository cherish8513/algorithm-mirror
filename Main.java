package matrix;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] from_matrix;
	static int[][] to_matrix;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		from_matrix = new int[N][M];
		to_matrix = new int[N][M];

		for (int i = 0; i < N; i++) { // A 매트릭스 입력
			String sl = sc.nextLine();
			for (int j = 0; j < M; j++)
				from_matrix[i][j] = sl.charAt(j) - '0';
		}
		for (int i = 0; i < N; i++) { // B 매트릭스 입력
			String sl = sc.nextLine();
			for (int j = 0; j < M; j++)
				to_matrix[i][j] = sl.charAt(j) - '0';
		}
		calc();
		System.out.println(count);
		sc.close();
		
	}

	static void calc() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (from_matrix[i][j] != to_matrix[i][j]) {
					if (reverse(i, j)) { // 3 x 3으로 뒤집기가 가능하면 뒤집기
						count++;
					} else { // 뒤집지 못 한다면 A -> B 불가능
						count = -1;
						return;
					}
				}
			}
		}
	}

	static boolean reverse(int x, int y) {

		if (x + 3 > N || y + 3 > M) // 최소가 3 X 3
			return false;

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				from_matrix[i][j] = from_matrix[i][j] == 0 ? 1 : 0;
			}
		}
		return true;
	}

}