package baekjoon_10819_차이를_최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	private static int[] arr;
	private static int maxResult = Integer.MIN_VALUE;
	private static boolean[] isSelected;
	private static int[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		selected = new int[N];
		search(0, selected);
		System.out.println(maxResult);
	}
	
	public static void search(int idx, int[] selected){
		if(idx == N) {
			int result = 0;
			for(int i = 0; i < N-1; i++)
				result += Math.abs(selected[i] - selected[i+1]);
			maxResult = Math.max(result, maxResult);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i])
				continue;
			isSelected[i] = true;
			selected[idx] = arr[i];
			search(idx + 1, selected);
			isSelected[i] = false;
		}
	}
}
