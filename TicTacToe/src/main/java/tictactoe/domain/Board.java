/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

/**
 *
 * @author minnahir
 */
import java.util.ArrayList;

public class Board {

    private Square[][] board;
    private int tokens;
    private String winner;
    private String message;
    private int boardSize;
    private int tokensInARow;

    public Board(int boardSize, int tokensInARow) {

        this.boardSize = boardSize;
        this.tokensInARow= tokensInARow;

        this.board = new Square[boardSize][boardSize];
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                board[i][j] = new Square(" ");

            }
        }
        this.tokens = 0;
        this.winner = "";
        this.message = "";
    }

    public boolean gameOver() {
        if (threeInARow("X")) {
            this.message = "Game over, the winner is " + this.winner;
            return true;
        } else if (threeInARow("O")) {
            this.message = "Game over, the winner is " + this.winner;
            return true;
        } else if (tokens == boardSize * boardSize) {
            this.message = "Game over, the board is full";
            return true;
        }
        return false;

    }

    public boolean threeInARow(String token) {
        if (checkRows(token)) {
            this.winner = token;
            return true;
        } else if (checkColumns(token)) {
            this.winner = token;
            return true;
        } else if (checkFirstDiagonal(token)) {
            this.winner = token;
            return true;
        } else if (checkSecondDiagonal(token)) {
            this.winner = token;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRows(String token) {

        for (int i = 0; i < this.boardSize; i++) {
            int count = 0;
            for (int j = 0; j < this.boardSize; j++) {
                if (board[i][j].getContents().equals(token)) {
                    count++;
                }

                if (count == this.tokensInARow) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkColumns(String token) {

        for (int i = 0; i < this.boardSize; i++) {
            int count = 0;
            for (int j = 0; j < this.boardSize; j++) {
                if (board[j][i].getContents().equals(token)) {
                    count++;
                }

                if (count == this.tokensInARow) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkFirstDiagonal(String token) {
        int count = 0;
        for (int i = 0; i < this.boardSize; i++) {
            if (board[i][i].getContents().equals(token)) {
                count++;
            }

            if (count == this.tokensInARow) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSecondDiagonal(String token) {
        for (int i = this.boardSize - 1; i >= 0; i--) {
            int count = 0;
            int row = 0;

            if (board[row][i].getContents().equals(token)) {
                count++;
            }
            row++;

            if (count == this.tokensInARow) {
                return true;
            }
        }

        return false;
    }

    public void setToBoard(String token, int x, int y) {
        tokens++;
        board[x][y] = new Square(token);

    }

    public ArrayList<String> emptySpots() {
        ArrayList<String> empty = new ArrayList<String>();

        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (board[j][i].getContents().equals(" ")) {
                    empty.add("" + i + "," + j);
                }

            }
        }
        return empty;
    }

    public int getTokens() {
        return tokens;
    }

    public String getMessage() {
        return this.message;
    }

    public String getWinner() {
        return this.winner;
    }

}
