package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1929_소수구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean prime[] = new boolean[N + 1];		// 초기값이 false니까 true인 숫자를 지운다. 즉 false가 소수
		prime[1] = true;
		
		for (int i = 2; i <= N / 2; i++) {	// i는 체크 하지 말아야 됨 어차피 4부터는 배수에 걸러져서 다 사라짐
			for (int j = i * 2; j <= N; j += i) {	
				prime[j] = true;	// 배수에 걸리는 애들 true로 소수에서 빼버리기
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (prime[i]) continue;
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
}
