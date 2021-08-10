package tile;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n + 1];
		if(n <= 2) {
			if (n == 1)
				System.out.println(1);
			else
				System.out.println(3);
			System.exit(0);
		}
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[n]);
		sc.close();
	}
}
