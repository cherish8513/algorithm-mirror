package stack_example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.contains("push")) {
				String[] push = str.split(" ");
				count++;
				stack[count] = Integer.parseInt(push[1]);
			} else if (str.contains("top")) {
				if (stack[count] == 0)
					bw.write("-1\n");
				else
					bw.write(stack[count] + "\n");
			} else if (str.contains("pop")) {
				if (stack[count] == 0)
					bw.write("-1\n");
				else {
					bw.write(stack[count] + "\n");
					count--;
				}
			} else if (str.contains("empty")) {
				bw.write((count == 0 ? 1 : 0) + "\n");
			}

			else if (str.contains("size")) {
				bw.write(count + "\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
