/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

/**
 *
 * @author minnahir
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tictactoe.domain.Board;
import tictactoe.domain.Game;
import tictactoe.domain.Player;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import tictactoe.domain.ArtificialIntelligence;

public class TicTacToeUi extends Application {

    private Board ticTacToeBoard;
    private ArrayList<Button> buttonList;
    private String turn;
    private String message;

    @Override
    public void init() throws Exception {
        ticTacToeBoard = new Board();

        buttonList = new ArrayList<Button>();
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TicTacToe");
        GridPane grid = new GridPane();
        grid.setPrefSize(300, 300);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);

        Label upperLabel = new Label("X plays, choose an empty position:");
        upperLabel.setFont(Font.font("Monospaced", 14));
        borderPane.setTop(upperLabel);

        for (int y = 1; y <= 3; y++) {
            for (int x = 1; x <= 3; x++) {
                int xCoordinate = x;
                int yCoordinate = y;

                Button button = new Button(" ");
                buttonList.add(button);
                button.setFont(Font.font("Monospaced", 50));
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        String token = "";
                        String whoseTurn = "";
                        token = "X";
                        ticTacToeBoard.setToBoard("X", xCoordinate, yCoordinate);

                        button.setText(token);
                        button.setDisable(true);

                        if (ticTacToeBoard.gameOver()) {
                            int i = 0;
                            while (i < buttonList.size()) {
                                buttonList.get(i).setDisable(true);
                                i++;
                            }

                            upperLabel.setText(ticTacToeBoard.getMessage());
                        }

                        token = "O";
                        ArtificialIntelligence aI = new ArtificialIntelligence(ticTacToeBoard);
                        int random = aI.generateMove();
                        buttonList.get(random - 1).setText(token);
                        buttonList.get(random - 1).setDisable(true);
                        ticTacToeBoard.setToBoard(token, aI.getX(random), aI.getY(random));
                        if (ticTacToeBoard.gameOver()) {
                            int i = 0;
                            while (i < buttonList.size()) {
                                buttonList.get(i).setDisable(true);
                                i++;
                            }

                            upperLabel.setText(ticTacToeBoard.getMessage());
                        }

                    }

                });

                grid.add(button, x, y);

            }
        }
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
