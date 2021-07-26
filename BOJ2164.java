import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {		
			queue.offer(i);
		}
		while(queue.size() > 1) {		// 큐에 하나 남을때까지 반복
			queue.poll();				// 맨 윗장 뺀다
			queue.offer(queue.peek());	// 위에 있는거 밑에 넣는다
			queue.poll();				
		}
		bw.write(queue.peek() + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
