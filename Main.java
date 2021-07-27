package queue_two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] queue = new int[2000000];
		int front = 0;
		int rear = 1;
		for (int i = 0; i < n; i++) {
			String order = br.readLine();
			if (order.contains("push")) {
				front++;
				String[] push = order.split(" ");
				queue[front] = Integer.parseInt(push[1]);
			} else if (order.contains("pop")) {
				if (front < rear)
					bw.write(-1 + "\n");
				else {
					bw.write(queue[rear] + "\n");
					rear++;
				}
			} else if (order.contains("size")) {
				bw.write(front-rear+1 + "\n");
			} else if (order.contains("empty")) {
				if (front < rear)
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			} else if (order.contains("front")) {
				if (front < rear)
					bw.write(-1 + "\n");
				else {
					bw.write(queue[rear] + "\n");
				}
			} else if (order.contains("back")) {
				if (front < rear)
					bw.write(-1 + "\n");
				else {
					bw.write(queue[front] + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
