package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1038_감소하는수_김동규 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 9) {		// 9 이하의 숫자는 그냥 출력하면 답임
			System.out.println(N);
			System.exit(0);
		}
		ArrayList<Long> decrease = new ArrayList<>();
		Queue<Long> Q = new LinkedList<>();
		
		for(int i = 1; i <= 9; i++) {	// 0 ~ 9 까지 한자리 수는 다 넣어둔다.
			decrease.add((long) i);
			Q.offer((long) i);
		}
		
		while(!Q.isEmpty()) {		// 큐가 빌 때까지 계속 반복
			if(decrease.size() == N) break;		// 원하는 순서의 값이 구해지면 중단
			long x = Q.poll();					// queue는 현재 오름차순으로 들어가있음. 
			for(int i = 0; i < x % 10; i++) {	// x의 1의자리수보다 크지 않은 숫자를 뒤에 붙여줌.
				long y = x * 10 + i;			// x의 값에 10을 곱해서 자리수를 올려주고 기존의 수보다 작은 수를 뒤에 붙여줌
				decrease.add(y);
				Q.offer(y);						// 이 값을 넣는 이유는 줄어드는 숫자가 완성 된 값에 1의 자리에 더 작은 숫자를 붙여주는 작업을 반복하기 위함
			}
		}
		if(N > decrease.size())					// 한자리수 숫자때매 같을때로 하면 안됨
			System.out.println(-1);
		else
			System.out.println(decrease.get(N - 1));
	}
}
