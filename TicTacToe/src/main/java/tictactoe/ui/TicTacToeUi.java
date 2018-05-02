/**
 * Pelin graafinen käyttöliittymä
 */
package tictactoe.ui;

/**
 *
 * @author minnahir
 */
import javafx.geometry.Insets;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.domain.RandomArtificialIntelligence;

public class TicTacToeUi extends Application {

    private Board ticTacToeBoard;
    private Button[][] buttonTable;
    private RandomArtificialIntelligence computerPlayer;
    private Player humanPlayerX;
    private Player humanPlayerO;
    private String message;
    private int gameSize;
    private int tokensInARow;
    private Scene primaryScene;
    private Scene computerScene;
    private Scene otherPlayerScene;
    
 /**
 * Metodi alustaa projektin riippuvuudet
 */

    @Override
    public void init() throws Exception {
        this.gameSize = 4;
        this.tokensInARow = 4;
        ticTacToeBoard = new Board(gameSize, tokensInARow);
        buttonTable = new Button[gameSize][gameSize];
        computerPlayer = new RandomArtificialIntelligence(ticTacToeBoard, "O");
        humanPlayerX = new Player("X");
        humanPlayerO = new Player("O");

    }
 /**
 * Metodin suorituksen aikana muodostetaan käyttöliittymä
 * @param primaryStage tarvitaan käyttöliittymän muodostuksessa
 */
    @Override
    public void start(Stage primaryStage) {

        VBox primaryPane = new VBox(10);
        primaryPane.setPadding(new Insets(10));

        Label textLabel = new Label("I want to play against:");
        Button computerButton = new Button("Computer");
        Button otherPlayerButton = new Button("Other player");

        primaryPane.getChildren().addAll(textLabel, computerButton, otherPlayerButton);
        primaryScene = new Scene(primaryPane, 300, 300);

        //create computerScene
        GridPane computerGrid = new GridPane();
        computerGrid.setPrefSize(300, 300);
        BorderPane borderPaneComputer = new BorderPane();
        borderPaneComputer.setCenter(computerGrid);

        Label upperLabel = new Label("Choose an empty position:");
        upperLabel.setFont(Font.font("Monospaced", 14));
        borderPaneComputer.setTop(upperLabel);

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

                        ticTacToeBoard.setToBoard(humanPlayerX.getToken(), xCoordinate - 1, yCoordinate - 1);

                        button.setText(humanPlayerX.getToken());
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

                computerGrid.add(button, x, y);

            }
        }

        //create other player scene TOTETUTETAAN MYÖHEMMIN
//        GridPane otherPlayerGrid = new GridPane();
//        otherPlayerGrid.setPrefSize(300, 300);
//        BorderPane borderPaneOtherPlayer = new BorderPane();
//        borderPaneOtherPlayer.setCenter(otherPlayerGrid);
//
//        Label upperLabelOtherPlayer = new Label("Choose an empty position:");
//        upperLabelOtherPlayer.setFont(Font.font("Monospaced", 14));
//        borderPaneOtherPlayer.setTop(upperLabelOtherPlayer);
//
//        for (int y = 1; y <= gameSize; y++) {
//            for (int x = 1; x <= gameSize; x++) {
//                int xCoordinate = x;
//                int yCoordinate = y;
//
//                Button button = new Button(" ");
//                buttonTable[x - 1][y - 1] = button;
//
//                button.setFont(Font.font("Monospaced", 50));
//                button.setOnAction(new EventHandler<ActionEvent>() {
//
//                    @Override
//                    public void handle(ActionEvent event) {
//
//                        ticTacToeBoard.setToBoard(humanPlayerX.getToken(), xCoordinate - 1, yCoordinate - 1);
//
//                        button.setText(humanPlayerX.getToken());
//                        button.setDisable(true);
//
//                        if (ticTacToeBoard.gameOver()) {
//                            for (int i = 0; i < gameSize; i++) {
//                                for (int j = 0; j < gameSize; j++) {
//                                    buttonTable[i][j].setDisable(true);
//                                }
//                            }
//
//                            upperLabelOtherPlayer.setText(ticTacToeBoard.getMessage());
//                        }
//                        if (!ticTacToeBoard.gameOver()) {
//                            String randomLocation = computerPlayer.generateMove();
//                            int column = Character.getNumericValue(randomLocation.charAt(0));
//                            int row = Character.getNumericValue(randomLocation.charAt(2));
//                            buttonTable[row][column].setText(computerPlayer.getToken());
//                            buttonTable[row][column].setDisable(true);
//
//                            ticTacToeBoard.setToBoard(computerPlayer.getToken(), row, column);
//
//                            if (ticTacToeBoard.gameOver()) {
//                                for (int i = 0; i < gameSize; i++) {
//                                    for (int j = 0; j < gameSize; j++) {
//                                        buttonTable[i][j].setDisable(true);
//                                    }
//                                }
//
//                                upperLabelOtherPlayer.setText(ticTacToeBoard.getMessage());
//                            }
//                        }
//
//                    }
//
//                });
//
//                otherPlayerGrid.add(button, x, y);
//
//            }
//        }
        computerScene = new Scene(borderPaneComputer, 400, 400);
//        otherPlayerScene = new Scene(borderPaneOtherPlayer, 400, 400);

        computerButton.setOnAction(e -> {
            primaryStage.setScene(computerScene);
        });

//        otherPlayerButton.setOnAction(e->{
//            primaryStage.setScene(otherPlayerScene);
//        });
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    
/**
 * Pääluokka kutsuu metodia launch
 * @param args syöte, jolla metodia launch kutsutaan
 */
    public static void main(String[] args) {
        launch(args);
    }

}
