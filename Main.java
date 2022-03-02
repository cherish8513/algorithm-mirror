package com.company.baekjoon_20055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] belt = new int[N * 2];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = sc.nextInt();
        }

        int cur_pos = 0;
        int time = 0;
        boolean[] robots = new boolean[N * 2];
        while(K > 0){
            time++;
            cur_pos = (cur_pos - 1 + (2 * N)) % (2 * N);

            // 벨트 돌리기
            for(int i = N-2; i >= 0; i--) {
                if(robots[i]) {
                    robots[i] = false;
                    if(i+1 < N-1)
                        robots[i+1] = true;
                }
            }

            //로봇 이동
            for(int i = N-2; i >= 0; i--) {
                if(robots[i]) {
                    int next = cur_pos+i+1;
                    if(next >= 2*N)
                        next -= 2*N;
                    if(!robots[i+1] && belt[next] >= 1) {
                        robots[i] = false;
                        if(i+1 < N-1)
                            robots[i + 1] = true;
                        belt[next]--;
                        if(belt[next] == 0)
                            K--;
                    }
                }
            }

            //로봇 추가
            if(!robots[0] && belt[cur_pos] > 0) {
                robots[0] = true;
                belt[cur_pos]--;
                if(belt[cur_pos] == 0)
                    K--;
            }
        }
        System.out.println(time);
    }
}
