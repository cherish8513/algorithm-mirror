package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1107_리모컨 {
	static int N, M;
	static boolean button[] = { true,true,true,true,true,true,true,true,true,true };
	static int len;	// 길이 계속 반환해주는 방법 사용
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M != 0) {
			String x = br.readLine();
			for(int i = 0; i < 2 * M; i++, i++) {
				button[x.charAt(i) - '0'] = false;
			}
		}
		int ans = Math.abs(100 - N);
		for (int i = 0; i <= 1000000; i++) {		// 일단 버튼 시작위치 다 찍어보기. 이거 더 큰 숫자 찍고 내려오는 경우때문에 1000000 잡아야 됨. 더 큰 숫자는 밑에서 오는게 더 빠르므로 의미 없음
			if (checked(i)) {	// i 가 버튼 눌리는지 확인
				int x = Math.abs(N - i) + len;
				ans = x < ans ? x : ans;
			}
		}
		System.out.println(ans);
		
	}
	private static boolean checked(int x) {
		String check = Integer.toString(x);
		len = check.length();
		for (int i = 0; i < check.length(); i++) {
			if (!button[check.charAt(i) - '0']) return false;	// 하나라도 안눌리면 의미 없음
		}
		return true;
	}
}
