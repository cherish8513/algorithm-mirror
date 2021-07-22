package com.java.day1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long answer = 0;
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] arr = new int[row][col];
		boolean[][] check = new boolean[row][col]; 
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < row; i++) {
			int max = 0;
			int x = 0;
			int y = 0;
			for(int j = 0; j < col; j++) {
				// 가장 큰값 을 체크
				if(max < arr[i][j]) {
					max = arr[i][j];
					x = j;
					y = i;
				}
			}
			check[y][x] = true;
		}
		
		for (int i = 0; i < col; i++) {
			int max = 0;
			int x = 0;
			int y = 0;
			for(int j = 0; j < row; j++) {
				// 가장 큰값 을 체크
				if(max < arr[j][i]) {
					max = arr[j][i];
					x = i;
					y = j;
				}
			}
			check[y][x] = true;
		}
		
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if(!check[i][j]) 
					answer += arr[i][j];
			}
		}
		System.out.println(answer);
	}
}
