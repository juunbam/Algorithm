package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static int max = -1;
    public static void main(String[] args){
        int m = 4;
        int n = 6;
        int s = 25;
        int[][] time_map = {{0, 1, 1, -1, 2, 4},{-1, 7, 2, 1, 5, 7},{-1, 1, -1, 1, 6, 3},{-1, 1, -1, -1, 7, 0}};

        solution(m,n,s,time_map);

    }

    public static int[] solution(int m, int n, int s, int[][] time_map) {
        int moveDistance = 0;
        int sumOfTalkTime = 0;

        move(m, n, s, 0, 0, 0, 0, time_map, new boolean[m][n]);

        int[] answer = new int[2];
        answer[0] = moveDistance;
        answer[1] = sumOfTalkTime;

        return answer;
    }

    public static void move(int m, int n, int s, int d, int[][] time_map) {
        ArrayList<Point> queue = new ArrayList<Point>();
        queue.add(new Point(0,0));

        while(!queue.isEmpty()) {
            Point p = queue.get(0);

            if(p.x+1 < m && time_map[p.x+1][p.y] != -1) {
                queue.add(new Point(p.x+1, p.y));
            }
            if(p.x-1 >= 0 && time_map[p.x-1][p.y] != -1) {
                queue.add(new Point(p.x-1, p.y));
            }
            if(p.y+1 < n && time_map[p.x][p.y+1] != -1) {
                queue.add(new Point(p.x, p.y+1));
            }
            if(p.y-1 >= 0 && time_map[p.x][p.y-1] != -1) {
                queue.add(new Point(p.x, p.y-1));
            }
        }

    }

    public static void move(int m, int n, int s, int h, int v, int d, int t, int[][] time_map, boolean[][] visit) {
        if(h==m-1 && v==n-1) {
            System.out.println(m+" "+n+" "+s+" "+h+" "+v+" "+d+" "+t+" "+Arrays.toString(time_map)+" "+Arrays.toString(visit));
            if(t < s) {
                if(max == -1 || max > t) {
                    System.out.println(d+" "+t);
                    max = t;
                    return;
                }
            }
        }

        if(h+1 < m && h+1 >= 0 && time_map[h+1][v] != -1 && !visit[h+1][v]) {
            visit[h+1][v] = true;
            move(m, n, s, h + 1, v, d + 1, t + time_map[h+1][v], time_map, visit);

            visit[h+1][v] = true;
        }

        if(h-1 < m && h-1 >= 0 && time_map[h-1][v] != -1 && !visit[h-1][v]) {
            visit[h-1][v] = true;
            move(m, n, s, h - 1, v, d + 1, t + time_map[h-1][v], time_map, visit);
        }

        if(v+1 < n && v+1 >= 0 && time_map[h][v+1] != -1 && !visit[h][v+1]) {
            visit[h][v+1] = true;
            move(m, n, s, h, v+1, d + 1, t + time_map[h][v+1], time_map, visit);
        }

        if(v-1 < n && v-1 >= 0 && time_map[h][v-1] != -1 && !visit[h][v-1]) {
            visit[h][v-1] = true;
            move(m, n, s, h, v-1, d + 1, t + time_map[h][v-1], time_map, visit);
        }

    }
}
