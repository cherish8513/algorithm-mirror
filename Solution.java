package com.company;

class Solution {
    private int answer;
    static char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];

    public int solution(int n, String[] data) {
        calc(data, "");
        return answer;
    }

    public void calc(String[] data, String candidates){
        if(candidates.length() == 7){
            for(String condition : data){
                int targetIdxA = candidates.indexOf(condition.charAt(0));
                int targetIdxB = candidates.indexOf(condition.charAt(2));
                char sign = condition.charAt(3);
                int num = condition.charAt(4) - '0';
                if(sign == '='){
                    if(!(Math.abs(targetIdxA-targetIdxB) == num + 1))
                        return;
                }
                else if(sign == '>'){
                    if(!(Math.abs(targetIdxA-targetIdxB) > num + 1))
                        return;
                }
                else if(sign == '<'){
                    if(!(Math.abs(targetIdxA-targetIdxB) < num + 1))
                        return;
                }
            }
            answer++;
            return;
        }

        for(int i = 0; i < 8; i++){
            if(visited[i])
                continue;
            String name = candidates + names[i];
            visited[i] = true;
            calc(data, name);
            visited[i] = false;
        }
    }
}