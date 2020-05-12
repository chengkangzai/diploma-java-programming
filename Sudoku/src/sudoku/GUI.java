/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import GUI.ConfirmBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class GUI extends Application {

    Stage window;
    TableView<SudokuObject> table;
    int[][] gird = Calc.generateGrid(20);
    int[][] solvedGird = new int[9][9];

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        TableColumn<SudokuObject, String> col1 = new TableColumn<>("");
        col1.setMinWidth(50);
        col1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        TableColumn<SudokuObject, Double> col2 = new TableColumn<>("");
        col2.setMinWidth(50);
        col2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        TableColumn<SudokuObject, String> col3 = new TableColumn<>("");
        col3.setMinWidth(50);
        col3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        TableColumn<SudokuObject, String> col4 = new TableColumn<>("");
        col4.setMinWidth(50);
        col4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        TableColumn<SudokuObject, String> col5 = new TableColumn<>("");
        col5.setMinWidth(50);
        col5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        TableColumn<SudokuObject, String> col6 = new TableColumn<>("");
        col6.setMinWidth(50);
        col6.setCellValueFactory(new PropertyValueFactory<>("col6"));
        TableColumn<SudokuObject, String> col7 = new TableColumn<>("");
        col7.setMinWidth(50);
        col7.setCellValueFactory(new PropertyValueFactory<>("col7"));
        TableColumn<SudokuObject, String> col8 = new TableColumn<>("");
        col8.setMinWidth(50);
        col8.setCellValueFactory(new PropertyValueFactory<>("col8"));
        TableColumn<SudokuObject, String> col9 = new TableColumn<>("");
        col9.setMinWidth(50);
        col9.setCellValueFactory(new PropertyValueFactory<>("col9"));
        
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);

        VBox layout = new VBox();
        layout.getChildren().addAll(table);
        Scene scene = new Scene(layout);
        window.setTitle("Hello World!");
        window.setScene(scene);
        window.setOnCloseRequest(e -> {
            // Prevent default
            e.consume();
            if (ConfirmBox.display("Confirmation ", "Are you sure you want to exit?")) {
                window.close();
            }
        });
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // test();
    }

    public ObservableList<SudokuObject> getProduct() {
        int[][] grid = Calc.generateGrid(20);
        ObservableList<SudokuObject> girdlist = FXCollections.observableArrayList();
        for (int i = 0; i < grid.length; i++) {
            girdlist.add(new SudokuObject(grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4],
                    grid[i][5], grid[i][6], grid[i][7], grid[i][8]));
        }
        return girdlist;
    }

}
