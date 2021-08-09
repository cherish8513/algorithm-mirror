package sumbaggokjil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX_SIZE = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // end of input

		if (N >= K) { // 동생보다 크거나 같은 경우
			System.out.println(N - K);
			System.exit(0);
		}
		
		int[] dp = new int[MAX_SIZE + 3]; // 최대 값 + 1 인덱스의 공간 + 1
		
		for(int i = N, j = 0; i >= 0; i--, j++) { // N 이하 값들 뒤로 1칸씩
			dp[i] = j;
		}

		
		for (int i = N; i <= K + 1; i++) {
			dp[i + 1] = dp[i] + 1; // 다음 위치에 일단 + 1 더한 값을 저장

			if ((i + 1) % 2 == 0 && dp[(i + 1) / 2] != -1) // 다음 위치 / 2 부분에 값이 있다면
				dp[i + 1] = Math.min(dp[(i + 1) / 2] + 1, dp[i + 1]); // / 2 한 부분의 값 + 1과 현재 위치 값 + 1을 비교
			
			if (dp[i + 1] < dp[i]) // 다음 위치 값보다 현재 위치 값이 크다면 (뒤로 1칸)
				dp[i] = dp[i + 1] + 1;
		}
		System.out.println(dp[K]);
		br.close();
	}
}
