package star;

import java.util.Scanner;

public class Main {
	static String[] part = {"****", "* *", "**", "*"};
	static char[][] map;
	static int N; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int n = 1 << N;
		map = new char[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = ' ';
			}
		}
		star(n, 0, 0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			System.out.println(sb.substring(0, sb.lastIndexOf("*")+1));
			sb = new StringBuilder();
		}
		sc.close();
		
	}
	
	static void star(int n, int y, int x) {
		if(n == 1) {
			map[y][x] = '*';
			return;
		}
		n /= 2;
		star(n, y, x);
		star(n, y+n, x);
		star(n, y, x+n);
	}
}
