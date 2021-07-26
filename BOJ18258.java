import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int back = 0;								// back을 보는 메서드가 없기 때문에 표시해야 됨
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if(command.contains("push")) {
				String[] push = command.split(" ");		// push 들어오면 공백으로 나눠서 숫자 enqueue 하기
				int x = Integer.parseInt(push[1]);
				back = x;
				queue.offer(x);		// offer는 큐가 꽉 차면 false를 반환하고 add는 illegalStateException을 발생시킴
			} else if (command.equals("pop")) {
				if(queue.isEmpty()) bw.write(-1 + "\n");
				else {
					bw.write(queue.poll() + "\n");
				}
			} else if (command.equals("size")) {
				bw.write(queue.size() + "\n");
			} else if (command.equals("front")) {
				if(queue.isEmpty()) bw.write(-1 + "\n");
				else bw.write(queue.peek() + "\n");
			} else if (command.equals("back")) {
				if (queue.isEmpty()) bw.write(-1 + "\n");
				else bw.write(back + "\n");
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			}
		}
		bw.flush();		// flush 남발하면 시간초과로 이어짐
		br.close();
		bw.close();
	}
}
