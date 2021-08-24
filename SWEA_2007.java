package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2007{
	private static char[] c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) { // 테케반복
			String line = br.readLine(); // 문자열 읽어옴
			c = new char[line.length()]; // 문자 배열 생성
			for (int i = 0; i < line.length(); i++) { // 배열에 한글자씩 넣어줌
				c[i] = line.charAt(i);
			}
//			System.out.println(Arrays.toString(c));
			
			sb.append("#").append(testCase).append(" ");
ex:			for (int i = 1; i < line.length(); i++) {
				if(c[0] == c[i] && c[1] == c[i+1]) {
					sb.append(i).append("\n");
					break ex;
				}
			}
			
		} // end of TC
		System.out.println(sb.toString());
	} // end of main
} // end of class

// 한단어에 두글자 이상 반복되면 틀림