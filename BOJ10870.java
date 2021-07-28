import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write(fibo(n) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	static int fibo(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fibo(n-1) + fibo(n - 2);
		
	}
}
