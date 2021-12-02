package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1365_꼬인전깃줄_김동규 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] lis = new int[N + 1];						// lis가 되는 조건 그 자체를 배열로 만듬
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = 0;
		
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if (size == 0 || lis[size - 1] < x) {		// 0이면 무조건 넣어야 되고 마지막 숫자보다 크면 그 다음에 넣기
				lis[size++] = x;						// 뒤에다 숫자 넣고 size 1 늘려주기
			} else {
				int idx = lower_bound(lis, x, size);			// 새로 들어온 값이 들어갈 인덱스 위치 찾기. 기존의 값 보다 같거나 큰 숫자중 최소값을 대체
				lis[idx] = x;
			}

		}
		System.out.println(N - size);
	}

	private static int lower_bound(int[] lis, int target, int size) {	// 바이너리 서치를 이용한 lower_bound
		int start = 0;
		int end = size;		// size 안보내면 0이랑 섞여서 결과 꼬임

		int idx = 0;
		int min = (int) 1e9;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (lis[mid] < target) {
				start = mid + 1;
			} else {					// target 보다 큰 값들 중 가장 작은 값 리턴
				end = mid - 1;
				min = lis[mid] < min ? lis[mid] : min;
				idx = mid;
			}
		}

		return idx;
	}
}
