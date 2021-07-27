package nge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int value = 1;
	static int valueOfIdx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer[]> stack = new Stack<>();
		int[] arr = new int[n];
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek()[value] < next) {
				arr[stack.peek()[valueOfIdx]] = next;
				stack.pop();
			}
			Integer[] val = {idx, next};
			stack.add(val);
			idx++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == 0)
				sb.append(-1).append(' ');
			else
				sb.append(arr[i]).append(' ');
		}
		sb.append(-1);
		bw.write(sb+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
