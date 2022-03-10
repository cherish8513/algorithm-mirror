package com.company.baekjoon_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int result = 987654321;
    public static int N;
    public static int M;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split( " ")[1]);

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
                str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '0')
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }

        check(map);

        if(N == 1 && M == 1)
            System.out.println(1);
        else if(result == 987654321)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void check(boolean[][] map){
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][][] visited = new boolean[N][M][2];
        queue.add(new int[] {0, 0, 1, 1});

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int breakChance = pos[3];

            for (int i = 0; i < 4; i++) {
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(!map[nr][nc]){
                        if(breakChance == 1){
                            queue.add(new int[]{nr, nc, pos[2] + 1, 0});
                            visited[nr][nc][1] = true;
                        }
                        continue;
                    }
                    if(nr == N - 1 && nc == M - 1) {
                        result = Math.min(result, pos[2] + 1);
                        return;
                    }
                    if(breakChance == 1 && !visited[nr][nc][0]){
                        queue.add(new int[]{nr, nc, pos[2] + 1, 1});
                        visited[nr][nc][0] = true;
                    }
                    else if(breakChance == 0 && !visited[nr][nc][1]){
                        queue.add(new int[]{nr, nc, pos[2] + 1, 0});
                        visited[nr][nc][1] = true;
                    }
                }
            }
        }
    }
}
