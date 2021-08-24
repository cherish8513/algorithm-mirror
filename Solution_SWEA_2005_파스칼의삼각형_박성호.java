package SWEA;

import java.util.Scanner;

public class Solution_SWEA_2005_파스칼의삼각형_박성호 {
	static int[][] tri;
	static int T;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			tri = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if(i == j || j == 0) tri[i][j] = 1;
					else tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
				}
			}
			System.out.println("#"+test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(tri[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
