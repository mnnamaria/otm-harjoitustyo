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
import tictactoe.domain.Player;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import tictactoe.domain.RandomArtificialIntelligence;

public class TicTacToeUi extends Application {
    private GlyphFont glyphFont;
    private Board ticTacToeBoard;
    private Button[][] buttonTable;
    private RandomArtificialIntelligence computerPlayer;
    private Player humanPlayerX;
    private Player humanPlayerO;
    private Scene primaryScene;
    private Scene computerScene;
    private Scene otherPlayerScene;

    /**
     * Metodi alustaa projektin riippuvuudet
     */
    @Override
    public void init() throws Exception {
        ticTacToeBoard = new Board(4, 4);
        buttonTable = new Button[4][4];
        computerPlayer = new RandomArtificialIntelligence(ticTacToeBoard, "O");
        humanPlayerX = new Player("X");
        humanPlayerO = new Player("O");
        glyphFont = GlyphFontRegistry.font("FontAwesome");


    }

    /**
     * Metodin suorituksen aikana muodostetaan käyttöliittymä
     *
     * @param primaryStage tarvitaan käyttöliittymän muodostuksessa
     */
    @Override
    public void start(Stage primaryStage) {

        VBox primaryPane = new VBox(10);
        primaryPane.setPadding(new Insets(10));

        Label textLabel = new Label("Choose the number of players:");
        Button computerButton = new Button("1 player");
        Button otherPlayerButton = new Button("2 players");

        primaryPane.getChildren().addAll(textLabel, computerButton, otherPlayerButton);
        primaryScene = new Scene(primaryPane, 300, 300);

        computerButton.setOnAction(e -> {
            primaryStage.setScene(createComputerScene());
        });

        otherPlayerButton.setOnAction(e -> {
            primaryStage.setScene(createOtherPlayerScene());
        });
        
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    
    /**
     * Luo Scenen tietokonetta vastaan pelaamista varten
     *
     */

    public Scene createComputerScene() {
        GridPane computerGrid = new GridPane();
        computerGrid.setPrefSize(300, 300);
        BorderPane borderPaneComputer = new BorderPane();
        borderPaneComputer.setCenter(computerGrid);

        Label upperLabel = new Label("Choose an empty position:");
        upperLabel.setFont(Font.font("Monospaced", 14));
        borderPaneComputer.setTop(upperLabel);

        for (int y = 1; y <= ticTacToeBoard.getBoardSize(); y++) {
            for (int x = 1; x <= ticTacToeBoard.getBoardSize(); x++) {
                int xCoordinate = x;
                int yCoordinate = y;

                Button button = new Button("", glyphFont.create("CIRCLE").size(38).color(Color.TRANSPARENT));
                buttonTable[x - 1][y - 1] = button;

                button.setFont(Font.font("Monospaced", 50));
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        ticTacToeBoard.setToBoard(humanPlayerX.getToken(), xCoordinate - 1, yCoordinate - 1);
                        button.setGraphic(new FontAwesome().create(FontAwesome.Glyph.TIMES).size(40));
                        button.setDisable(true);

                        gameOver(upperLabel);
                        
                        if (!ticTacToeBoard.gameOver()) {
                            String randomLocation = computerPlayer.generateMove();
                            int column = Character.getNumericValue(randomLocation.charAt(0));
                            int row = Character.getNumericValue(randomLocation.charAt(2));
                            buttonTable[row][column].setGraphic(new FontAwesome().create(FontAwesome.Glyph.CIRCLE).size(38));
                            buttonTable[row][column].setDisable(true);

                            ticTacToeBoard.setToBoard(computerPlayer.getToken(), row, column);

                            gameOver(upperLabel);
                        }

                    }

                });

                computerGrid.add(button, x, y);

            }
        }
        computerScene = new Scene(borderPaneComputer, 400, 400);
        return computerScene;
    }
    
    /**
     * Luo Scenen toisen pelaajan kanssa pelaamista varten
     *
     */

    public Scene createOtherPlayerScene() {

        GridPane otherPlayerGrid = new GridPane();
        otherPlayerGrid.setPrefSize(300, 300);
        BorderPane borderPaneOtherPlayer = new BorderPane();
        borderPaneOtherPlayer.setCenter(otherPlayerGrid);

        Label upperLabel = new Label("X plays, choose an empty position:");
        upperLabel.setFont(Font.font("Monospaced", 15));
        borderPaneOtherPlayer.setTop(upperLabel);

        for (int y = 1; y <= ticTacToeBoard.getBoardSize(); y++) {
            for (int x = 1; x <= ticTacToeBoard.getBoardSize(); x++) {
                int xCoordinate = x;
                int yCoordinate = y;
                
                Button button = new Button("", glyphFont.create("CIRCLE").size(38).color(Color.TRANSPARENT));
                buttonTable[x - 1][y - 1] = button;

                button.setFont(Font.font("Monospaced", 50));
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        
                        if (ticTacToeBoard.getTokens() % 2 == 0) {
                            ticTacToeBoard.setToBoard(humanPlayerX.getToken(), xCoordinate - 1, yCoordinate - 1);
                            button.setGraphic(new FontAwesome().create(FontAwesome.Glyph.TIMES).size(40));
                            button.setDisable(true);
                            upperLabel.setText("O plays, choose an empty position");

                            gameOver(upperLabel);
                            
                        } else {
                            ticTacToeBoard.setToBoard(humanPlayerO.getToken(), xCoordinate - 1, yCoordinate - 1);
                            button.setGraphic(new FontAwesome().create(FontAwesome.Glyph.CIRCLE).size(38));
                            button.setDisable(true);
                            upperLabel.setText("X plays, choose an empty position");

                            gameOver(upperLabel);
                            
                        }


                    }

                });

                otherPlayerGrid.add(button, x, y);

            }
        }

        otherPlayerScene = new Scene(borderPaneOtherPlayer, 400, 400);
        return otherPlayerScene;
    }
    
    /**
     * Jos peli on ohi, kaikki ruudut asetetaan toimimattomiksi ja pelin yläreunaan
     * ilmestyy viesti pelin päättymisen syystä
     *
     * @param label Kenttä, jossa pelinpäättymisviesti näytetään
     */
    
    public void gameOver(Label label){
        if (ticTacToeBoard.gameOver()) {
                                for (int i = 0; i < ticTacToeBoard.getBoardSize(); i++) {
                                    for (int j = 0; j < ticTacToeBoard.getBoardSize(); j++) {
                                        buttonTable[i][j].setDisable(true);
                                    }
                                }

                                label.setText(ticTacToeBoard.getMessage());
                            }
    }

    /**
     * Pääluokka kutsuu metodia launch
     *
     * @param args syöte, jolla metodia launch kutsutaan
     */
    public static void main(String[] args) {
        launch(args);
    }

}
