package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_2007_패턴마다의길이_박성호 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			String s = br.readLine();
			for (int i = 1; i <= s.length(); i++) {
				String b = s.substring(0, i);
				String c = s.substring(i,i + i);
				if (b.equals(c)) {
					System.out.println("#" + test_case + " " + b.length());
					break;
				}
			}
		}
	}
}
