package plus;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author jooheon
 * 1개를 고르는 경우는 모든 수에 대해서 1
 * 2개를 고르는 경우는 이전 1개를 고르는 경우의 수 + 이전 2개를 고르는 경우의 수 
 * n개를 고르는 경우는 이전 n-1개를 고르는 경우의 수 + 이전 n개를 고르는 경우의 수
 * 근데 왜 20을 2개로 뽑는 경우의 수가 21이지??? 2를 뽑는 경우의 수 1 -> 20은 19가 되야하는디
 * 아 0도 포함이구나 위의 공식은 1부터 인 경우로 폐기 시간만 날렸네
 * 1개를 고르는 경우는 모든 수에 대해서 1
 * 2개를 고르는 경우는 n+1
 * n개를 고르는 경우의 수는 현재 인덱스 n-1개를 고르는 경우의 수 + 이전 n개를 고르는 경우의 수
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[m+1][n+1];
		Arrays.fill(dp[1], 1);
		
		if(m == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i = 1; i <= m; i++) { // 0을 만드는 조합은 1개
			dp[i][0] = 1;
		}
		
		for(int i = 0; i <= n; i++) { // 2개로 뽑는 경우의 수는 n + 1
			dp[2][i] = i + 1;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
			}
		}
		System.out.println(dp[m][n]);
		sc.close();
	}
}
