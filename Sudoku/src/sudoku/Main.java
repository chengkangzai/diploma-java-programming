/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;




/**
 *
 * @author ASUS
 */
public class Main extends GUI {

    public static void main(String[] args) {
        int[][] board = Calc.generateGrid(40);

        Sudoku sudoku = new Sudoku(board);
        sudoku.display();
        sudoku.solve();
        //sudoku.display();
        
        if (sudoku.checkCorrect(sudoku.getAnswerFromCli())) {
            System.out.println("yay");
        } else {
            System.out.println("nah");
        }
        System.exit(0);
        
        
    }
}
