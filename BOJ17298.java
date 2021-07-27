import java.io.*;
import java.util.*;
public class BOJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> input = new Stack<>();
		String num = br.readLine();				// br을 이용하여 string 형태로 입력 받아옴
		String[] split = num.split(" ");		// 띄어쓰기로 구분해서 한글자씩 배열에 저장
		for(int i = 0; i < split.length; i++) {
			input.push(Integer.parseInt(split[i]));	// int로 형변환 하여 스택에 push
		}
		Stack<Integer> ngr = new Stack<>();		// 숫자 비교하기 위한 스택
		Stack<Integer> result = new Stack<>();	// 결과값 저장하기 위한 스택
		ngr.push(input.peek());					// 마지막에 받은 숫자는 가장 오른쪽 값이기 때문에 무조건 -1이 나옴
		input.pop();
		result.push(-1);
		while(!input.empty()) {					// input을 하나씩 빼면서 비교할 것이므로 input이 빌때까지 무한 반복
			while(!ngr.empty()) {
				if(input.peek() < ngr.peek()) {	// ngr top에 있는 값이 가장 크면 오큰수 result로 push
					result.push(ngr.peek());
					ngr.push(input.peek());
					input.pop();
					break;
				} else {
					ngr.pop();					// 오큰수가 아니므로 다음 ngr 스택의 값과 비교하기 위해 pop
				}
			}
			if (ngr.empty()) {					// ngr 스택에 모든 값이 오큰수가 아닌 경우 -1 출력 해야됨
				result.push(-1);
				ngr.push(input.peek());			// 오큰수는 없지만 이 숫자가 다음 숫자의 오큰수가 될수도 있으므로 ngr에 push
				input.pop();
			}
		}
		while(!result.empty()) {
			bw.write(result.peek() + " ");
			result.pop();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
