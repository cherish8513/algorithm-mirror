package baekjoon.baekjoon_1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end of for input

        System.out.println(dfs(0, 0, new boolean[N][N]));
    }

    private static long dfs(int i, int j, boolean[][] visited) {

        if (i == N - 1 && j == N - 1)
            return 1;
        if (i >= N || i < 0 || j < 0 || j >= N || map[i][j] == 0 || visited[i][j])
            return 0;
        visited[i][j] = true;

        return dfs(i + map[i][j], j, visited)
                + dfs(i, j + map[i][j], visited)
                + dfs(i - map[i][j], j, visited)
                + dfs(i, j - map[i][j], visited);
    }
}