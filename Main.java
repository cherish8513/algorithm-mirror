package iron_stick;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		int result = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') count++;
			else {
				count--;
				
				if(str.charAt(i-1) == '(')
					result += count;
				else
					result++;
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
