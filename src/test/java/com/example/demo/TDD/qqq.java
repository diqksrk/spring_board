//package com.example.demo.TDD;
//
//import lombok.extern.log4j.Log4j2;
//import org.junit.Test;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//@Log4j2
//public class qqq {
//
//
//
//    private class seatPosition  {
//        int row;
//        int column;
//        int number;
//
//        public seatPosition(int row, int column, int number) {
//            this.row = row;
//            this.column = column;
//            this.number = number;
//        }
//    }
//
//    int[][] hallOfseats = new int[50][50];
//    int[][] copedHallOfSeats = new int[50][50];
//    boolean[][] visitedSeatInfo = new boolean[50][50];
//    Queue<seatPosition> seatPositionList = new LinkedList<>();
//    int[] answer = new int[2];
//    int[] directRow = { 0,  0, 1, -1 };
//    int[] directColumn = { 1, -1, 0, 0 };
//
//
//    public void setInitSeats(int n) {
//        for (int row = 0; row < n; row++) {
//            for (int column = 0; column < n; column++) {
//                if (row == 0 && column == 0) {
//                    hallOfseats[row][column] = 1;
//                } else if ( row == n-1 && column == n - 1 ) {
//                    hallOfseats[row][column] = 2;
//                } else {
//                    hallOfseats[row][column] = 0;
//                }
//            }
//        }
//    }
//
//    public void setSeatsOfList(int n) {
//        for (int row = 0; row<n; row++) {
//            for (int column = 0; column<n; column++) {
//                if (hallOfseats[row][column] != 0) {
//                    seatPositionList.add(new seatPosition(row, column, 0));
//                }
//            }
//        }
//    }
//
//    public void copyHallOfseats(int n) {
//        for (int row = 0; row < n; row++) {
//            for (int column = 0; column < n; column++) {
//                if (hallOfseats[row][column] != 0) {
//                    visitedSeatInfo[row][column] = true;
//                }
//
//                copedHallOfSeats[row][column] = 0;
//            }
//        }
//    }
//
//    public void setInitvisitedSeatInfo(int n) {
//        for (int row=0; row<n; row++) {
//            for (int column=0; column<n; column++) {
//                visitedSeatInfo[row][column] = false;
//            }
//        }
//    }
//
//    public void calcBestPlace(int n) {
//        while (!seatPositionList.isEmpty()) {
//            seatPosition seatPosition = seatPositionList.poll();
//
//            for (int i = 0; i<4; i++) {
//                int nextRow = seatPosition.row + directRow[i];
//                int nextColumn = seatPosition.column + directColumn[i];
//
//                if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < n) {
//                    if (visitedSeatInfo[nextRow][nextColumn]) continue;
//
//                    int seatPositionNumber = seatPosition.number + 1;
//                    copedHallOfSeats[nextRow][nextColumn] = seatPositionNumber;
//                    visitedSeatInfo[nextRow][nextColumn] = true;
//                    seatPositionList.add(new seatPosition(nextRow, nextColumn, seatPositionNumber));
//                }
//            }
//        }
//    }
//
//    public void setAudienceToBestPlace(int n, int k, int targetNumber) {
//        int curMax = 0;
//        int curRow = 0;
//        int curColumn = 0;
//
//        for (int row = 0; row<n; row++) {
//            for (int column = 0; column < n; column++) {
//                if (curMax < copedHallOfSeats[row][column]) {
//                    curMax = copedHallOfSeats[row][column];
//                    curRow = row;
//                    curColumn = column;
//                } else if (curMax == copedHallOfSeats[row][column]) {
//                    if (curColumn > column) {
//                        curColumn = column;
//                        curRow = row;
//                    } else if (curColumn == column) {
//                        if (curRow > row) {
//                            curRow = row;
//                            curColumn = column;
//                        }
//                    }
//                }
//            }
//        }
//
//        hallOfseats[curRow][curColumn] = k;
//        if (targetNumber == k) {
//            answer[0] = curRow + 1;
//            answer[1]= curColumn + 1;
//        }
//    }
//
//    public int[] solution(int n, int k) {
//
//        setInitSeats(n);
//
//        for (int u = 2; u<k;u++) {
//            setInitvisitedSeatInfo(n);
//            setSeatsOfList(n);
//            copyHallOfseats(n);
//            calcBestPlace(n);
//            setAudienceToBestPlace(n, u + 1, k);
//        }
//
//        return answer;
//    }
//
//
//    @Test
//    public void main() {
//        int n = 5;
//        int k = 12;
//
//        solution(n, k);
//    }
//}
