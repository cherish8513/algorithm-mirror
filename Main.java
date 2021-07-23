package parenthesis;

import java.util.Scanner;

public class Main {
	static int T;
	static String pt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			pt = sc.nextLine();
			int count = 0;
			for (int j = 0; j < pt.length(); j++) {
				if (pt.charAt(j) == '(')
					count++;
				else
					count--;

				if (count < 0) {
					break;
				}
			}
			if (count == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

}
