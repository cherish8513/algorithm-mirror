import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ18511 {
	static int n, k, result;		// 재귀로 돌리기 위해 전역변수 선언
	static Integer[] kArray;		// 미리 크기 선언하면 정렬이 안됨. 이유는 모르겠음. 내림차순 하기 위해 Integer로 선언
	
	static void recursive(int x) {
		if(x > n) return;		// x 가 n 보다 크다면 조건에 맞지 않으므로 탈출
		result = x > result ? x : result;	// result보다 확인 하려는 x값이 크면 x값을 넣어줌. 결국 n이하의 숫자 중 최대값이 남는다
		for(int i = 0; i < k; i++) {
			recursive(x * 10 + kArray[i]);	// x에 10을 곱해서 한자리씩 올리고 k의 원소를 하나씩 붙여서 확인하는 방식
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		
		n = Integer.parseInt(input.split(" ")[0]);
		k = Integer.parseInt(input.split(" ")[1]);
		input = br.readLine();
		kArray = new Integer[k];
		for(int i = 0; i < k; i++) {
			kArray[i] = Integer.parseInt(input.split(" ")[i]);
		}
		Arrays.sort(kArray, Collections.reverseOrder());	// 내림차순 정렬
		recursive(0);
		bw.write(result + "\n");
		bw.close();
		br.close();
	}
}
