/**
 * Pelilauta, joka toteutetaan Square-ruuduista koostuvana taulukkona
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
    
 /**
 * Konstruktori luo uuden pelilaudan ottaen huomioon käyttäjän antaman pelilaudan
 * koon ja voittokriteerin
 * 
 * @param boardSize pelilaudan koko
 * @param tokensInARow kuinka monta merkkiä peräkkäin vaaditaan pelin voittamiseen 
 * (tällä hetkellä oikein toimii vain versio, jossa merkkejä vaaditaan yhtä monta
 * kuin pelilaudan kokokin on, muutoin voitontarkistus ei löydä kaikkia vinorivejä)
 */

    public Board(int boardSize, int tokensInARow) {

        this.boardSize = boardSize;
        this.tokensInARow = tokensInARow;

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
    
 /**
 * Metodi arkistaa, onko peli ohi: onko X tai O voittanut tai onko pelilauta täysi.
 * Jos peli on ohi, asettaa laudalle viestin pelin päättymisen syystä.
 * @return onko peli ohi
 */

    public boolean gameOver() {
        if (fourInARow("X")) {
            this.message = "Game over, the winner is " + this.winner;
            return true;
        } else if (fourInARow("O")) {
            this.message = "Game over, the winner is " + this.winner;
            return true;
        } else if (tokens == boardSize * boardSize) {
            this.message = "Game over, the board is full";
            return true;
        }
        return false;

    }
/**
 * Metodi arkistaa, onko parametrina saatua pelimerkkiä tarpeeksi monta peräkkäin
 * sarakkeissa, riveillä tai diagonaaleilla
 * @param pelimerkki
 * @return onko tarpeeksi monta peräkkäin
 */
    public boolean fourInARow(String token) {
        if (checkRows(token) || checkColumns(token) 
                || checkFirstDiagonal(token) || checkSecondDiagonal(token)) {
            this.winner = token;
            return true;
      
        } 
        
        return false;
    }
/**
 * Metodi arkistaa, onko parametrina saatua pelimerkkiä tarpeeksi monta peräkkäin
 * riveillä
 * @param pelimerkki
 * @return onko tarpeeksi monta peräkkäin
 */
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
/**
 * Metodi arkistaa, onko parametrina saatua pelimerkkiä tarpeeksi monta peräkkäin
 * sarakkeilla
 * @param pelimerkki
 * @return onko tarpeeksi monta peräkkäin
 */
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
/**
 * Metodi arkistaa, onko parametrina saatua pelimerkkiä tarpeeksi monta peräkkäin
 * vasemmasta yläkulmasta oikeaan alakulmaan kulkevalla diagonaalilla
 * @param pelimerkki
 * @return onko tarpeeksi monta peräkkäin
 */
    public boolean checkFirstDiagonal(String token) {
        int count = 0;
        
        for (int i = 0; i < this.boardSize; i++) {
            if (board[i][i].getContents().equals(token)) {
                count++;
            }
        }
        return count == this.tokensInARow;
    }
    
 /**
 * Metodi arkistaa, onko parametrina saatua pelimerkkiä tarpeeksi monta peräkkäin
 * oikeasta yläkulmasta vasempaan alakulmaan kulkevalla diagonaalilla
 * @param pelimerkki
 * @return onko tarpeeksi monta peräkkäin
 */

    public boolean checkSecondDiagonal(String token) {
        int count = 0;
        int row = 0;
        for (int i = this.boardSize - 1; i >= 0; i--) {
            

            if (board[row][i].getContents().equals(token)) {
                count++;
            }
            row++;

        }
        return count == this.tokensInARow;
    }
/**
 * Metodi asettaa syötteenä saadun pelimerkin syötteenä saatuihin
 * sarakkeeseen ja riviin
 * @param pelimerkki asetettava pelimerkki
 * @param x rivi
 * @param y sarake
 */
    public void setToBoard(String token, int x, int y) {
        tokens++;
        board[x][y].setContents(token);

    }
/**
 * Metodi listaa laudalla olevat tyhjät paikat
 * @return emptySpots tyhjät paikat merkkijonona muodossa "rivi, sarake"
 */
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

 /**
 * Metodi palauttaa laudalle asetettujen merkkien lukumäärän
 * @return merkkien lukumäärä
 */
    public int getTokens() {
        return tokens;
    }
    
/**
 * Metodi palauttaa pelilautaan liittyvän viestin
 * @return viesti siitä, onko jompikumpi pelaaja voitanut tai onko lauta täysi
 */
    public String getMessage() {
        return this.message;
    }

 /**
 * Metodi palauttaa voittavan pelimerkin
 * @return voittava pelimerkki (null, mikäli voittajaa ei ole)
 */
    public String getWinner() {
        return this.winner;
    }
    
/**
 * Metodi palauttaa pelilaudan koon
 * @return pelilaudan koko
 */
    public int getBoardSize() {
        return this.boardSize;
    }
    
    
 /**
 * Metodi kertoo, kuinka monta samaa merkkiä pitää saada peräkkäin
 * @return montako merkkiä peräkkäin tarvitaan pelin voittoon
 */
    public int getTokensInARow() {
        return this.tokensInARow;
    }

}
