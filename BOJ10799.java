import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10799 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stick = new Stack<>();
		String input = br.readLine();
		stick.push(input.charAt(0));		// 처음은 무조건 들어가야됨
		int sum = 0;
		for (int i = 1; i < input.length(); i++) {
			if(input.charAt(i) == '(') stick.push('(');		// ( 나오면 무조건 push
			else {
				stick.pop();								// ) 나오면 무조건 pop
				if(input.charAt(i - 1) == '(') {			// 바로 전이 ( 였으면 스틱 개수 만큼 더해줌
					sum += stick.size();
				} else {									// 잘린 부분은 더해줬으나 원래 있던 막대기는 더해주지 못했기 때문에
					sum++;									// 레이저가 아니라면 막대기이므로 1씩 더해준다
				}
			}
		}
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
