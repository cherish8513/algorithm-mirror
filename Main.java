package pizza_boxes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long result = 0;
		int row = sc.nextInt();
		int col = sc.nextInt();

		int[][] pizzas = new int[row][col];
		int[][] copy_pizzas = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				pizzas[i][j] = sc.nextInt();
				copy_pizzas[i][j] = pizzas[i][j];
				result += pizzas[i][j];
			}
		}

		// front view
		for (int i = 0; i < row; i++) {
			int max_height = 0;
			int x = 0;
			int y = 0;
			for (int j = 0; j < col; j++) {
				if (max_height < pizzas[i][j]) {
					max_height = pizzas[i][j];
					x = j;
					y = i;
				}
			}
			result -= copy_pizzas[y][x];
			copy_pizzas[y][x] = 0;
		}

		// side view
		for (int i = 0; i < col; i++) {
			int max_height = 0;
			int x = 0;
			int y = 0;
			for (int j = 0; j < row; j++) {
				if (max_height < pizzas[j][i]) {
					max_height = pizzas[j][i];
					x = i;
					y = j;
				}
			}
			result -= copy_pizzas[y][x];
			copy_pizzas[y][x] = 0;
		}

		System.out.println(result);
	}
}