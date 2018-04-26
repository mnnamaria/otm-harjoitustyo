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
    private Button[][] buttonTable;
    private ArtificialIntelligence computerPlayer;
    private Player humanPlayer;
    private String message;
    private int gameSize;
    private int tokensInARow;

    @Override
    public void init() throws Exception {
        this.gameSize = 4;
        this.tokensInARow = 4;
        ticTacToeBoard = new Board(gameSize, tokensInARow);
        buttonTable = new Button[gameSize][gameSize];
        computerPlayer = new ArtificialIntelligence(ticTacToeBoard, "O");
        humanPlayer = new Player("X");

    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TicTacToe");
        GridPane grid = new GridPane();
        grid.setPrefSize(300, 300);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);

        Label upperLabel = new Label("Choose an empty position:");
        upperLabel.setFont(Font.font("Monospaced", 14));
        borderPane.setTop(upperLabel);

        for (int y = 1; y <= gameSize; y++) {
            for (int x = 1; x <= gameSize; x++) {
                int xCoordinate = x;
                int yCoordinate = y;

                Button button = new Button(" ");
                buttonTable[x - 1][y - 1] = button;

                button.setFont(Font.font("Monospaced", 50));
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        ticTacToeBoard.setToBoard(humanPlayer.getToken(), xCoordinate - 1, yCoordinate - 1);

                        button.setText(humanPlayer.getToken());
                        button.setDisable(true);

                        if (ticTacToeBoard.gameOver()) {
                            for (int i = 0; i < gameSize; i++) {
                                for (int j = 0; j < gameSize; j++) {
                                    buttonTable[i][j].setDisable(true);
                                }
                            }

                            upperLabel.setText(ticTacToeBoard.getMessage());
                        }
                        if (!ticTacToeBoard.gameOver()) {
                            String randomLocation = computerPlayer.generateMove();
                            int column = Character.getNumericValue(randomLocation.charAt(0));
                            int row = Character.getNumericValue(randomLocation.charAt(2));
                            buttonTable[row][column].setText(computerPlayer.getToken());
                            buttonTable[row][column].setDisable(true);

                            ticTacToeBoard.setToBoard(computerPlayer.getToken(), row, column);

                            if (ticTacToeBoard.gameOver()) {
                                for (int i = 0; i < gameSize; i++) {
                                    for (int j = 0; j < gameSize; j++) {
                                        buttonTable[i][j].setDisable(true);
                                    }
                                }

                                upperLabel.setText(ticTacToeBoard.getMessage());
                            }
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
