package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18111_마인크래프트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// end of input
		
		int resHeight = 9999;
		int resTime =  (int)1e9;
		for(int height = 0; height <= 256; height++) {
			int inven = B;							// B를 건드리면 다음 연산에서 문제가 생길 수 있음
			int time = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					// 원하는 높이보다 높은 경우
					if (map[i][j] > height) {			// 높이 차이 * 2 만큼의 시간이 소요됨
						int x = map[i][j] - height;
						inven += x;
						time += 2 * x;
					}
					else if(map[i][j] < height){		// 높이 차이 만큼의 시간이 소요됨
						int x =  height - map[i][j];
						inven -= height - map[i][j];
						time += x;
					}
				}	// end of for j
			}	// end of for i
			if (inven >= 0 && resTime >= time) {	// 높이는 점점 높아지니까 시간 같을때 포함하면 같은 시간일때 높은 높이가 나옴
				resTime = time;
				resHeight = height;
			}
		}	// end of height
		
		System.out.println(resTime + " " + resHeight);
	}
}
