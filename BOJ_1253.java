package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int ans = 0;
//		System.out.println(Arrays.toString(arr));
		
		for (int i = N-1; i >= 0; i--) { // 큰 수부터 찾음
			boolean flag = false;
			for (int j = N-1; j >= 0; j--) { // 큰 수 전의 수
				int start = 0;
				int end = j-1;
				if(i == j) continue;
				while(start <= end) {
					int mid = (start+end) / 2;
					int find = arr[i] - arr[j]; // 배열에서 찾을 값
					if(arr[mid] > find) { // 중간값이 찾을값보다 크면
						end = mid - 1; // end 변경
					} else if(arr[mid]==find && mid!=i && mid!=j) { // 값을 찾았을때 중복 선택안됨.
						flag = true; // 
						break;
					} else { // 중간값이 찾을 값보다 작으면
						start = mid + 1;
					}
				}
			}
			if(flag) ans++;
		}
		System.out.println(ans);
		
	} // end of main
} // end of class
