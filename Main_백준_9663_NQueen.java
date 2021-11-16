package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_9663_NQueen {
	static int N, res;
	static int[] col;	// col[i] = x	i 행의 x 열에 퀸 있음
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
		
		nQueen(1);
		System.out.println(res);
	}
	private static void nQueen(int r) {
		if (r == N + 1) {	// 다 놨으면 카운팅
			res++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			col[r] = i;
			if (checked(r)) {
				nQueen(r + 1);
			}
		}
	}
	private static boolean checked(int r) {
		for (int i = 1; i < r; i++) {		// 1행부터 r -1 행까지
			if(col[i] == col[r] || Math.abs(col[i] - col[r]) == r - i)	// 같은 열에 있거나 대각 관계
				return false;
		}
		return true;
	}
}
