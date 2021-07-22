package light_switch;

import java.util.Scanner;

public class Main {
	static int N = 3;
	static int[] to_light;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		int[] from_light = new int[N];
		int[] copy_light = new int[N];
		to_light = new int[N];
		String str = sc.nextLine();
		for (int i = 0; i < N; i++) {
			from_light[i] = str.charAt(i) - '0';
			copy_light[i] = str.charAt(i) - '0'; // 첫 전구 키는 상황
		} // end of input A lights
		str = sc.nextLine();
		for (int i = 0; i < N; i++) {
			to_light[i] = str.charAt(i) - '0';
		} // end of input B lights

		int count = calc(from_light);
		copy_light[0] = copy_light[0] == 0 ? 1 : 0;
		copy_light[1] = copy_light[1] == 0 ? 1 : 0;
		int copy_count = calc(copy_light); // count + 1

		if (count == -1 && copy_count == -1)
			System.out.println(-1);
		else if (count == -1 || copy_count == -1)
			System.out.println(Math.max(count, copy_count + 1));
		else
			System.out.println(Math.min(count, copy_count + 1));
		sc.close();
	}

	static int calc(int[] lights) {
		int count = 0;
		for (int i = 1; i < N; i++) {
			if (lights[i - 1] != to_light[i - 1]) {
				reverse(i, lights);
				count++;
			}
		}
		return lights[N - 1] == to_light[N - 1] ? count : -1;
	}

	static void reverse(int idx, int[] lights) {
		lights[idx] = lights[idx] == 0 ? 1 : 0;
		lights[idx - 1] = lights[idx - 1] == 0 ? 1 : 0;
		if (idx + 1 < N)
			lights[idx + 1] = lights[idx + 1] == 0 ? 1 : 0;
	}

}
