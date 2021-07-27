import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		String[] split = input.split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		bw.write("<");
		while(!queue.isEmpty()) {	// 큐가 빌때까지 반복
			for (int i = 0; i < k - 1; i++) {	// 맨앞에 있는애 뒤로 n - 1번까지 옮겨줌
				int front = queue.peek();
				queue.offer(front);
				queue.poll();
			}
			if (queue.size() != 1) bw.write(queue.poll() + ", ");	// n번째 놈은 지우면서 출력
			else bw.write(queue.poll() + ">"); 		// 마지막에는 , 가 안들어감 do~while 쓰면 되지만 귀찮아서...
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
