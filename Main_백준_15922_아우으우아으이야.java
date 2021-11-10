package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_15922_아우으우아으이야 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Pos> line = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			line.add(new Pos(x, y));
		}
		
		Collections.sort(line);
		int ans = 0;
		int start = line.get(0).x;
		int end = line.get(0).y;
		
		for (int i = 1; i < N; i++) {
			int nowStart = line.get(i).x;
			int nowEnd = line.get(i).y;
			if (end > nowStart) {	// 이전 선분의 끝이 지금 선분의 시작보다 뒤에 있으면 겹침
				end = nowEnd > end ? nowEnd : end;	// 선이 연장됐다는 개념으로 끝부분 늘려줌
			}
			else {	// 겹치지 않은 경우
				ans += end - start;		// 지금까지 잡고 있던 선분 길이 저장
				start = nowStart;		// 비교할 선분을 현재 선분으로 바꿔줌
				end = nowEnd;
			}
		}
		ans += end - start;
		System.out.println(ans);
	}
}

class Pos implements Comparable<Pos> {
	int x, y;
	public Pos() {
	}
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pos o) {
		if(this.x > o.x)
			return 1;
		else 
			return -1;
	}
	
}
