package com.company.baekjoon_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int MIN_KB;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);

        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            int from = Integer.parseInt(str.split(" ")[0]);
            int to = Integer.parseInt(str.split(" ")[1]);
            map.get(from).add(to);
            map.get(to).add(from);
        }

        int kb = 987654321;
        int answer = 987654321;
        for (int i = 1; i < N; i++) {
            MIN_KB = 0;
            visited = new boolean[N+1];
            bfs(map, i);
            if(kb == MIN_KB){
                answer = Math.min(answer, i);
            }
            else if(kb > MIN_KB){
                answer = i;
                kb = MIN_KB;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(List<List<Integer>> map, int start) {
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int size = map.get(cur[0]).size();
            for (int i = 0; i < size; i++) {
                Integer to = map.get(cur[0]).get(i);
                if(!visited[to]){
                    visited[to] = true;
                    MIN_KB += cur[1] + 1;
                    queue.add(new int[]{to, cur[1] + 1});
                }
            }
        }
    }
}
