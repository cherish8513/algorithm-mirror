import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		int sum = 0;								// 값을 출력할 변수
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {	// 0 인 경우 pop을 하고 sum에서 가장 최근에 부른 숫자를 빼줌
				sum -= stack.peek();
				stack.pop();
			} else {	// 0 이외의 숫자가 들어왔을 경우 sum에 값을 더하고 stack에 push
				sum += x;
				stack.push(x);
			}
		}
		bw.write(sum + "\n");
		bw.flush();				// flush 안하면 출력 안됨
		bw.close();
		br.close();
	}
}
