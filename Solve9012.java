import java.util.Scanner;
import java.util.Stack;

public class Solve9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int test = 0; test < n; test ++) {
			String input = sc.next();
			boolean vps = true;					// 스택 비어있을때 탈출한거 표시용
			Stack<Integer> stack = new Stack<>();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') {	// ( 나오면 push
					stack.push(1);
				} else {						// ) 나왔을 경우
					if(stack.empty()) {			// 스택이 비어 있으면 탈출 하고 vps false로 표시
						vps = false;
						break;
					} else {					// 스택에 괄호가 있으면  pop
						stack.pop();
					}
				}
			}
			if(vps && stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
