package com.swea.study.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5356 {
	private static String line;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) { // 테케 반복
			char[][] arr = new char[5][15]; // 5줄로 이루어져 있고 1이상 15이하 문자열
			for (int i = 0; i < 5; i++) { // 각 테케틑 5줄로 이루어져 있다.
				line = br.readLine();
				for (int j = 0; j < line.length(); j++) { // 입력받은 글자 수 만큼만 반복 <<<<<<
					arr[i][j] = line.charAt(j);
				}
			} // 배열에 한줄 때려넣기
			
//			System.out.println(Arrays.deepToString(arr));
			
			sb.append("#").append(testCase).append(" ");
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if(arr[i][j] == 0) continue;	// <<<<<< 안써서 틀렸었다
					sb.append(arr[i][j]);
				}
			}
			
			sb.append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class

/*
2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx


#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x


#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D
*/