package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_백준_9375_패션왕신해빈_김동규 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> cnt = new HashMap<String, Integer>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String item = st.nextToken();
				String classification = st.nextToken();
				// 분류 별로 숫자만 카운팅
				if(cnt.containsKey(classification))	// 이미 있던 경우
					cnt.put(classification, cnt.get(classification) + 1);
				else	// 처음 들어온 경우
					cnt.put(classification, 1);
				
			}	// end of input
			
			int ans = 1;
			
			for(int i : cnt.values()) {
				ans *= i + 1;	// 분류별 모든 옷 경우 다 + 1 해서 곱함. 옷의 수 + 안입는 경우
			}
			
			sb.append(ans - 1).append("\n");	// 알몸인 경우 빼줘야 하므로 - 1
		}	// end of for test
		System.out.print(sb);
	}
}
