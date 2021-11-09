package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 211109
 * @author me
 * 리모컨
 */
public class BOJ_1107 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 이동하려는 채녈 0<=N<=500000
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		boolean[] rc = new boolean[10];
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < M; i++) {
				int brokenNum = Integer.parseInt(st.nextToken());
				rc[brokenNum] = true;
			}
		}
		int cnt = Math.abs(N - 100);
		if(N == 100) {
			cnt = 0;
		}else if(M == 0) {
			cnt = Math.min(cnt, Integer.toString(N).length());
		}else {
			for (int i = 0; i <= 999999 ; i++) { // 눌릴 수 있는 버튼의 최대 수
				String str = String.valueOf(i);
				int len = str.length(); // 자릿수
				boolean bknBtn = false;
				for (int j = 0; j < len; j++) {
					if(rc[str.charAt(j)-'0']) { // 고장난 버튼 누른다면
						bknBtn = true;
						break;
					}
				}
				if(!bknBtn) { // 멀쩡한 버튼
					int min = Math.abs(N - i) + len;
					cnt = Math.min(min, cnt);
				}
			}
		}
		System.out.println(cnt);
	} // end of main
} // end of class
