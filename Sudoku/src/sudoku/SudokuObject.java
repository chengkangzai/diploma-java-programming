/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author CCK
 */
public class SudokuObject {
    private String col1;
    private String col2;
    private String col3;
    private String col4;
    private String col5;
    private String col6;
    private String col7;
    private String col8;
    private String col9;

    public SudokuObject(int col1, int col2, int col3, int col4, int col5, int col6, int col7, int col8, int col9) {
        if (col1 == 0)
            this.col1 = "";
        else
            this.col1 = String.valueOf(col1);
        if (col2 == 0)
            this.col2 = "";
        else
            this.col2 = String.valueOf(col2);
        if (col3 == 0)
            this.col3 = "";
        else
            this.col3 = String.valueOf(col3);
        if (col4 == 0)
            this.col4 = "";
        else
            this.col4 = String.valueOf(col4);
        if (col5 == 0)
            this.col5 = "";
        else
            this.col5 = String.valueOf(col5);
        if (col6 == 0)
            this.col6 = "";
        else
            this.col6 = String.valueOf(col6);
        if (col7 == 0)
            this.col7 = "";
        else
            this.col7 = String.valueOf(col7);
        if (col8 == 0)
            this.col8 = "";
        else
            this.col8 = String.valueOf(col8);
        if (col9 == 0)
            this.col9 = "";
        else
            this.col9 = String.valueOf(col9);
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public String getCol4() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4 = col4;
    }

    public String getCol5() {
        return col5;
    }

    public void setCol5(String col5) {
        this.col5 = col5;
    }

    public String getCol6() {
        return col6;
    }

    public void setCol6(String col6) {
        this.col6 = col6;
    }

    public String getCol7() {
        return col7;
    }

    public void setCol7(String col7) {
        this.col7 = col7;
    }

    public String getCol8() {
        return col8;
    }

    public void setCol8(String col8) {
        this.col8 = col8;
    }

    public String getCol9() {
        return col9;
    }

    public void setCol9(String col9) {
        this.col9 = col9;
    }

    

}
