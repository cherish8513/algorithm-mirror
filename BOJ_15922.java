package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 211110
 * 아우으 우아으이야!!
 */
public class BOJ_15922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 선분의 개수
		int sum = 0;
//		int[][] line = new int[N][2];
		int tx=0, ty=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			line[i][0] = x;
//			line[i][1] = y;
			sum += (y-x);
			if(i!=0 && tx<=x && x<ty && ty<=y) { // 가운데 걸칠때
				sum -= (ty-x);
			}else if(i!=0 && tx<x && y<ty) { // 포함될때
				sum -= (y-x);
			}
			tx = x;
			ty = y;
			
		}
		
		

		System.out.println(sum);
	} // end of main
} // end of class
