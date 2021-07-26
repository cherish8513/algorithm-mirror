package balanced_world;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char c;
		while (!(str.equals("."))) {
			int check = 0;
			int count_so = 0;
			int count_dae = 0;

			char[] arr = new char[100];
			int idx = 0;
			while ((c = str.charAt(check)) != '.') {
				check++;
				if (c == '(') {
					count_so++;
					idx++;
					arr[idx] = c;
				} else if (c == ')') {
					count_so--;
					if (arr[idx] != '(')
						break;
					else
						idx--;
				} else if (c == '[') {
					count_dae++;
					idx++;
					arr[idx] = c;
				} else if (c == ']') {
					count_dae--;
					if (arr[idx] != '[')
						break;
					else
						idx--;
				}
				if (count_so < 0 || count_dae < 0)
					break;
			}
			if (count_so == 0 && count_dae == 0)
				System.out.println("yes");
			else
				System.out.println("no");
			str = sc.nextLine();
		}
		sc.close();
	}
}
