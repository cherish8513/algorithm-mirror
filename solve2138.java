package com.java.day1;

import java.util.*;

public class solve2138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String before = sc.next();
		String after = sc.next();

		long cnt = 1 << n; // 조합
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < cnt; i++) {
			int[] arr = new int[n];
			String temp = "";
			int count = 0;
			
			// 전구를 누르는 조합을 만든다.
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					if (j > 0)
						arr[j - 1]++;	// 왼쪽 전구
					if (j < n - 1)
						arr[j + 1]++;	// 오른쪽 전구
					arr[j]++;			// 중앙 전구
					
					count ++;			// 전구를 누른 횟수
				}
			}

			// 조합을 적용한다.
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] % 2 == 1)
					temp += (before.charAt(j) == '0') ? '1' : '0';
				else
					temp += before.charAt(j);
			}
			if(temp.equals(after) && min > count) {
				min = count;
			}
		}
		
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}
}
