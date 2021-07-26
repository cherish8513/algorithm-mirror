package zero;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int [n];
		for (int i = 0; i < n; i++) {
			int input_num = sc.nextInt();
			if(input_num == 0) {
				count--;
				arr[count] = 0;
			}
			else {
				arr[count] = input_num;
				count++;
			}
		}
		int result = 0;
		for (int i : arr) {
			result += i;
		}
		
		System.out.println(result);
		sc.close();
	}
}
