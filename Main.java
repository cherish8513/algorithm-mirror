package big_number;

import java.util.Scanner;

public class Main {
	static int target;
	static int[] arr;
	static int N;
	static int result = 0;
	static int target_depth;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		target = Integer.parseInt(str[0]);
		target_depth = str[0].length();
		int input_max_value = (str[0].charAt(0) - '0');
		N = Integer.parseInt(str[1]);
		arr = new int[N];
		str = sc.nextLine().split(" ");
		boolean check = true;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
			if(arr[i] < (input_max_value))
				check = false;
		}
		if(check)
			target_depth--;
		dfs(0, new int[target_depth]);
		System.out.println(result);
		sc.close();
		
	}
	
	static void dfs(int depth, int[] candidate){
		if(depth == target_depth) {
			StringBuilder sb = new StringBuilder();
			for(int i : candidate)
				sb.append(i);
			String str = sb.substring(0);
			int value = Integer.parseInt(str);
			if(value <= target)
				result = Math.max(result, value);
			return;
		}
		for(int i = 0; i < N; i++) {
			candidate[depth] = arr[i];
			dfs(depth+1, candidate);
		}
			
	}
}
