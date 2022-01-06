package baekjoon_1301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bead_arr = new int[N];
        for (int i = 0; i < N; i++) {
            bead_arr[i] = Integer.parseInt(br.readLine());
        }

        boolean isEmpty = false;
        while(!isEmpty){
            for (int i = 0; i < N; i++) {
                bead_arr[i] -= 1;
                if(bead_arr[i] == 0)
                    isEmpty = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if(bead_arr[i] >= 2){
                System.out.println(0);
                System.exit(0);
            }
        }

        int rest_beads = 0;
        for (int i = 0; i < N; i++) {
            rest_beads += bead_arr[i];
        }

        int answer = N - rest_beads;

        if (answer == 1)
            System.out.println(1);
        if (answer == 2)
            System.out.println(2);
        if (answer == 3)
            System.out.println(6);
        if (answer == 4)
            System.out.println(24);
        if (answer == 5)
            System.out.println(120);
    }
}
