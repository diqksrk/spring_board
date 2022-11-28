package com.example.demo.TDD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class oioio {

    @Test
    public void test10() {
        int[][] beds = { {4,1, 200000} };
        int[][] tables = {{ 2, 3, 100000 }};
        int cost = 10000;

//        assertEquals(420000, solution(beds, tables, cost));
    }


    @Test
    public void main() {


        solution(2, 4, 1, 1);
    }

    int[] xIndex = {0, 1, 0, 1};
    int[] yIndex = {0, 0, 1, 1};
    
    public boolean isPossibleRoom(int[][] roomMap, int x, int y) {
        int xLength = roomMap[0].length;
        int yLength = roomMap.length;
        for (int i = 0; i<4; i++) {
            if (x + xIndex[i] >= xLength || y + yIndex[i] >= yLength) return false;
        }
        
        return true;
    }

    public void putRoom(int[][] roomMap, i, j) {
        roomMap[i][j] = 1;
        roomMap[i + yIndex[0]][j + xIndex[0]] = 1;
        roomMap[i + yIndex[1]][j + xIndex[1]] = 1;
        roomMap[i + yIndex[2]][j + xIndex[2]] = 1;
    }

    public void DFS(int[][] roomMap, int room, int bath, int curRoom, int curBath) {
        if (curRoom == room && curBath == bath) {
            return;
        }

        if (curRoom < room) {
            putRoom();

//            for (int i = 0; i<roomMap.length; i++) {
//                for (int j = 0; j<roomMap[i].length; j++) {
//                    if (isPossibleRoom(roomMap, j, i)) {
//                        roomMap[i][j] = 1;
//                        roomMap[i + yIndex[0]][j + xIndex[0]] = 1;
//                        roomMap[i + yIndex[1]][j + xIndex[1]] = 1;
//                        roomMap[i + yIndex[2]][j + xIndex[2]] = 1;
//                    }
//                }
//            }
        }
        System.out.println("roomMap = " + roomMap);
    }

    public int solution(int n, int m, int room, int bath) {
        int answer = -1;
        int[][] roomMap = new int[n][m];

        DFS(roomMap, room, bath, 0, 0);


        return answer;
    }






    public int getMinRoomWidth(int bedXposition, int bedYposition, int tableXposition, int tableYposition) {
        return (bedXposition + tableXposition) * (Math.max(bedYposition, tableYposition));
    }
//
//    public long solution(int[][] beds, int[][] tables, int cost) {
//        long answer = Long.MAX_VALUE;
//        for (int i=0; i<beds.length; i++) {
//            for (int j = 0; j < tables.length; j++) {
//                int totalPrice = 0;
//                int minWidth = Integer.MAX_VALUE;
//                int bedPrice = beds[i][2];  int tablePrice = tables[j][2];
//
//                //first x y축 그대로
//                minWidth = Math.min(getMinRoomWidth(beds[i][0], beds[i][1], tables[j][0], tables[j][1]), minWidth);
//                //first x y축 90도 그대로
//                minWidth = Math.min(getMinRoomWidth(beds[i][0], beds[i][1], tables[j][1], tables[j][0]), minWidth);
//                //first x 90도 y축 그대로
//                minWidth = Math.min(getMinRoomWidth(beds[i][1], beds[i][0], tables[j][0], tables[j][1]), minWidth);
//                //first x 90도 y축 90% 그대로
//                minWidth = Math.min(getMinRoomWidth(beds[i][1], beds[i][0], tables[j][1], tables[j][0]), minWidth);
//
//                totalPrice += (  bedPrice + tablePrice + minWidth * cost  );
//
//                answer = Math.min(answer, totalPrice);
//            }
//        }
//
//        return answer;
//    }



















    String[] partiName = { "a", "b", "c", "d" };
    HashMap<String, String> coupleInfo = new HashMap<>();
    HashMap<String, String> prevCoupleInfo = new HashMap<>();
    HashMap<String, String> arrowInfo = new HashMap<>();
    ArrayList<String> ruleViolPeople = new ArrayList<>();
    public int solution(String[][] rounds) {
        int answer = 0;

        for (int i=0; i<rounds.length; i++) {
            arrowInfo.clear();
            prevCoupleInfo.clear();
            prevCoupleInfo.putAll(coupleInfo);
            coupleInfo.clear();
            ruleViolPeople.clear();
            for (int j = 0; j < 4; j++) {
                if (partiName[j] == rounds[i][j]) {
                    answer++;
                    ruleViolPeople.add(partiName[j]);
                }

                if (prevCoupleInfo.getOrDefault(partiName[j], "Z").equals(rounds[i][j])) {
                    answer++;
                    ruleViolPeople.add(partiName[j]);
                }

                if (partiName[j].equals(arrowInfo.get(rounds[i][j])) && !ruleViolPeople.contains(partiName[j]) ) {
                    coupleInfo.put(partiName[j], rounds[i][j]);
                    coupleInfo.put(rounds[i][j], partiName[j]);
                }

                arrowInfo.put(partiName[j], rounds[i][j]);
            }
        }

        return answer;
    }
    
}
