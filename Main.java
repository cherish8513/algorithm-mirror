import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			
			if (s.contains("push")) {
				String[] split = s.split(" ");
				int x = Integer.parseInt(split[1]);
				stack.push(x);
			} else if (s.equals("pop")) {
				if (stack.isEmpty()) 
					bw.write(-1 + "\n");
				else {
					bw.write(stack.peek() + "\n");
					stack.pop();
				}
			} else if (s.equals("size")) {
				bw.write(stack.size() + "\n");
			} else if (s.equals("empty")) {
				if (stack.empty()) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			} else if (s.equals("top")) {
				if (stack.empty()) bw.write(-1 + "\n");
				else bw.write(stack.peek() + "\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
