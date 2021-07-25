import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			Stack<Character> stack = new Stack<>();	// 한 줄 끝날때마다 스택이 초기화 되어야 하므로 while문 안에 선언
			bw.flush();								// 마지막에 해도 상관없으나 매 줄마다 결과 보려고 여기 둠
			String s = br.readLine();
			Boolean flag = true;					// 문제 있으면 false로 바꿔서 no 출력
			if (s.charAt(0) == '.') break;			// 처음에 . 나오면 바로 끝남
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '.') {			// . 나오면 이 문장 종료
					break;
				} else if (s.charAt(i) == '(') {	// ( 나오면 스택에 넣음
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ')') {	// ( 가 없으면 더 안봐도 얘는 안됨
					if(stack.empty()) {
						flag = false;
						break;
					}
					if(stack.peek() == '(') {		//	스택 맨 위에 ( 가 맞으면 pop 아니면 안되는 문장
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else if (s.charAt(i) == '[') {	// ( 인 경우랑 똑같으므로 생략
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ']') {
					if(stack.empty()) {
						flag = false;
						break;
					}
					if(stack.peek() == '[') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else if (s.charAt(i) == '.') {
					break;
				}
			}
			if (flag && stack.empty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
