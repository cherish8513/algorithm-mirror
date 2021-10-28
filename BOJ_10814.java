package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 나이순 정렬
 *
 */

public class BOJ_10814 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회원의 수
		String[][] arr = new String[N][2]; 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = st.nextToken();
			}
		}
//		for (String[] strings : arr) {
//			System.out.print(Arrays.toString(strings));
//			System.out.println();
//		}
		
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); // 나이별 오름차순 정렬
			}

		});
		
//		for (String[] strings : arr) {
//			System.out.print(Arrays.toString(strings));
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	} // end of main
} // end of class

