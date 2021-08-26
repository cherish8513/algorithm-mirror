package swea;
/**
 * 210826
 * 영준이의 카드 카운팅
 * D3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테케 입력
		for (int testCase = 1; testCase <= TC; testCase++) { // 테케 반복
			// S D H C
			boolean[] s = new boolean[14]; // 각 카드 모양별로 배열 생성. 1~13 인덱스 사용하여 중복 체크
			boolean[] d = new boolean[14];
			boolean[] h = new boolean[14];
			boolean[] c = new boolean[14];
			boolean duplicate = false; // 중복 체크
			int s_cnt = 13, d_cnt = 13, h_cnt = 13, c_cnt = 13; // 필요한 카드 개수 체크하기 위해 기본값 13으로 선언
			String str = br.readLine(); // 한 줄 읽어오기
			for (int i = 0; i < str.length(); i+=3) { // 3글자씩 자르기 위해 i+=3
//				s_cnt = 13; d_cnt = 13; h_cnt = 13; c_cnt = 13;
				String shape = str.substring(i, i+1); // 카드 모양  <<<<<<<<<<< 문자열 자르기!!
				int num = Integer.parseInt(str.substring(i+1,i+3)); // 카드 숫자
				if(shape.equals("S")) {
					if(s[num]) { // 이미 true이면 중복
//						System.out.println("ERROR");
						duplicate = true;
						break;
					}else {
						s[num] = true; // 모양과 숫자에 해당하는 자리 체크
						s_cnt--;
					}
				}else if(shape.equals("D")) {
					if(d[num]) { // 이미 true이면 중복
						duplicate = true;
						break;
					}else {
						d[num] = true; // 모양과 숫자에 해당하는 자리 체크
						d_cnt--;
					}
				}else if(shape.equals("H")) {
					if(h[num]) { // 이미 true이면 중복
						duplicate = true;
						break;
					}else {
						h[num] = true; // 모양과 숫자에 해당하는 자리 체크
						h_cnt--;
					}
				}else if(shape.equals("C")) {
					if(c[num]) { // 이미 true이면 중복
						duplicate = true;
						break;
					}else {
						c[num] = true; // 모양과 숫자에 해당하는 자리 체크
						c_cnt--;
					}
				}
			} // data input / duplicate check
			if(duplicate) { // 중복
				sb.append("#").append(testCase).append(" ").append("ERROR").append("\n");
			} else { // 필요한 카드 개수 
				sb.append("#").append(testCase).append(" ").append(s_cnt+" ").append(d_cnt+" ").append(h_cnt+" ").append(c_cnt+"\n");
			}
		
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class


/*
3
S01D02H03H04
H02H10S11H02
S10D10H10C01

*/