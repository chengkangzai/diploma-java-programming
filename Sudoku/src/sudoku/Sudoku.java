/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Sudoku {

    public static int[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
            { 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
            { 0, 0, 1, 9, 0, 4, 5, 7, 0 } };

    private static int[][] BOARD;
    public static int EMPTY = 0;
    public static int SIZE = 9;

    public Sudoku(int[][] board) {
        Sudoku.BOARD = board;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Sudoku.BOARD[i][j] = board[i][j];
            }
        }
    }

    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (BOARD[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (BOARD[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (BOARD[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOK(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) & !isInBox(row, col, number);
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Empty Cell
                if (BOARD[row][col] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOK(row, col, number)) {
                            BOARD[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                BOARD[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (i == 3 || i == 6) {
                System.out.print("------------------\n");
            }
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + BOARD[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkCorrect(int[][] answer) {
        boolean returnValue = false;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (BOARD[i][j] == answer[i][j]) {
                    returnValue = true;
                }
            }
        }
        return returnValue;
    }

    public int[][] getAnswerFromCli(){
        int[][] answer=new int[9][9];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < BOARD.length; i++) {
            System.out.println("Line " + i);
            String tempp = scan.nextLine();
            String[] split = tempp.split("\\,");
            answer[i][0] = Integer.valueOf(split[0]);
            answer[i][1] = Integer.valueOf(split[1]);
            answer[i][2] = Integer.valueOf(split[2]);
            answer[i][3] = Integer.valueOf(split[3]);
            answer[i][4] = Integer.valueOf(split[4]);
            answer[i][5] = Integer.valueOf(split[5]);
            answer[i][6] = Integer.valueOf(split[6]);
            answer[i][7] = Integer.valueOf(split[7]);
            answer[i][8] = Integer.valueOf(split[8]);
        }
        return answer;
    }

    public static void main(String[] args) {

    }

}
