package decend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp_max_map = new int[3];
		int[] dp_min_map = new int[3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if (i == 0) {
				dp_min_map[0] = dp_max_map[0] = Integer.parseInt(st.nextToken());
				dp_min_map[1] = dp_max_map[1] = Integer.parseInt(st.nextToken());
				dp_min_map[2] = dp_max_map[2] = Integer.parseInt(st.nextToken());
			} else {
				int before_max_0 = dp_max_map[0];
				int before_max_1 = dp_max_map[1];
				int next_0 = Integer.parseInt(st.nextToken());
				int next_1 = Integer.parseInt(st.nextToken());
				int next_2 = Integer.parseInt(st.nextToken());
				dp_max_map[0] = Math.max(dp_max_map[0], dp_max_map[1]) + next_0;
				dp_max_map[1] = Math.max(Math.max(before_max_0, dp_max_map[1]), dp_max_map[2]) + next_1;
				dp_max_map[2] = Math.max(dp_max_map[2], before_max_1) + next_2;
				int before_min_0 = dp_min_map[0];
				int before_min_1 = dp_min_map[1];
				dp_min_map[0] = Math.min(dp_min_map[0], dp_min_map[1]) + next_0;
				dp_min_map[1] = Math.min(Math.min(before_min_0, dp_min_map[1]), dp_min_map[2]) + next_1;
				dp_min_map[2] = Math.min(dp_min_map[2], before_min_1) + next_2;
			}
		}
		System.out.println(Math.max(Math.max(dp_max_map[0], dp_max_map[1])
				, dp_max_map[2]));
		System.out.println(Math.min(Math.min(dp_min_map[0], dp_min_map[1])
				, dp_min_map[2]));
	}
}

//	static void bfs() {
//		Queue<int[]> q = new LinkedList<>();
//		q.add(new int[] { 0, 0, map[0][0] });
//		q.add(new int[] { 0, 1, map[0][1] });
//		q.add(new int[] { 0, 2, map[0][2] });
//		while (!q.isEmpty()) {
//			int[] pos = q.poll();
//			int y = pos[0];
//			int x = pos[1];
//			int cur_val = pos[2];
//			for (int i = 0; i < 3; i++) {
//				int nx = x + dx[i];
//				if (nx >= 0 && nx < 3)
//					if (y + 1 == n - 1) {
//						max_result = cur_val + map[y + 1][nx];
//						min_result = Math.min(cur_val + map[y + 1][nx], min_result);
//					} else if (cur_val + map[y + 1][nx] > dp_map[y+1][nx]) {
//						q.add(new int[] { y + 1, nx, cur_val + map[y + 1][nx]});
//						dp_map[y+1][nx] = cur_val + map[y+1][nx];
//					}
//					
//			}
//
//		}
//	}
//}

//	static void search(int depth, int start, int result) {
//		if(depth == n) {
//			max_result = Math.max(result, max_result);
//			min_result = Math.min(result, min_result);
//			return;
//		}
//		
//		for(int i = 0; i < 3; i++) {
//			int nx = start + dx[i];
//			if(nx >= 0 && nx < 3) {
//				search(depth+1, nx, map[depth][nx] + result);
//			}
//		}
//	}
