package fibonacci;

import java.util.Scanner;

public class Main {
	static int[] dp = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fibo(Integer.parseInt(sc.nextLine())));
		sc.close();
	}
	
	static int fibo(int target) {
		if(target == 0)
			return 0;
		if(target <= 2)
			return 1;
		if(dp[target] != 0)
			return dp[target];
		else {
			dp[target] = fibo(target-1) + fibo(target-2);
			return dp[target];
		}
	}
}
