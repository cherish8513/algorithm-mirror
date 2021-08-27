package 한번더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 210827
 * 원재의 메모리 복구하기
 * D3
 * @author me
 *
 */
public class SWEA_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) {
			String str = br.readLine();
			int[] m =new int[str.length()]; // 
			for (int i = 0; i < str.length(); i++) {
				m[i] = str.charAt(i) - '0';
			} // input data
			int count = 0;
			int init = 0; // 초기값 0 
			int N = str.length();
			for (int i = 0; i < N; i++) { 
				if(init != m[i]) {	// 초기값과 입력된 값이 다르면 <<<<<<<<<<<<<< 생각이 안나
					count++;	// 변경 카운트 증가
					init = m[i]; // 초기값을 입력값으로 변경
				}
			}
			System.out.println("#"+testCase+" "+(count));
//			System.out.println(Arrays.toString(memory));
		}
	} // end of main
} // end of class

/*
2
0011
100

*/
