package snake;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int snake = 1;
	static int wall = 1;
	static int apple = 2;
	static int N;
	static int K;
	static int L;
	static int[] dy = { 0, 1, 0, -1 }; // 1칸 오른쪽, 3칸 왼쪽
	static int[] dx = { 1, 0, -1, 0 }; // 동, 남, 서, 북
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		board = new int[N + 2][N + 2];
		K = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < K; i++) {
			String[] apple_pos = sc.nextLine().split(" ");
			board[Integer.parseInt(apple_pos[0])][Integer.parseInt(apple_pos[1])] = apple;
		}
		for (int i = 0; i < N + 2; i++) {
			board[i][0] = wall;
			board[0][i] = wall;
			board[N + 1][i] = wall;
			board[i][N + 1] = wall;
		}

		L = Integer.parseInt(sc.nextLine());
		int[] time = new int[L];
		int[] dir = new int[L];
		for (int i = 0; i < L; i++) {
			String[] order = sc.nextLine().split(" ");
			time[i] = Integer.parseInt(order[0]);
			if (order[1].equals("D"))
				dir[i] = 1;
			else if (order[1].equals("L"))
				dir[i] = 3;
		}

		board[1][1] = snake;
		Queue<Pos> tale = new LinkedList<>();
		tale.add(new Pos(1, 1));
		Pos head = new Pos(1, 1);
		int direction = 0;
		int count = 0;
		int time_idx = 0;
		while (true) {
			count++;
			head.y = head.y + dy[direction];
			head.x = head.x + dx[direction];

			if (board[head.y][head.x] != apple) {
				Pos tale_left = tale.poll();
				board[tale_left.y][tale_left.x] = 0;
			}

			if (head.y < 1 | head.y > N | head.x < 1 | head.x > N | board[head.y][head.x] == wall) {
				System.out.println(count);
				break;
			}

			tale.add(new Pos(head.y, head.x));
			board[head.y][head.x] = snake;
			if (time_idx < L && time[time_idx] - count == 0) {
				direction = (direction + dir[time_idx]) % 4 ;
				time_idx++;
			}
		}
		sc.close();
	}
}

class Pos {
	public int x;
	public int y;

	public Pos(int y, int x) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
	}
}
