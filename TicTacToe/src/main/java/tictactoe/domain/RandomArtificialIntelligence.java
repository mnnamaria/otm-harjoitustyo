/**
 * Pelin tietokonepelaaja
 */
package tictactoe.domain;

/**
 *
 * @author minnahir
 */
public class RandomArtificialIntelligence extends Player {

    private Board board;
/**
 * Konstruktori luo tekoälypelaajan
 * @param board pelilauta, jolla tekoälypelaaja pelaa
 * @param token tietokonepelaajan käyttämä pelimerkki
 */
    public RandomArtificialIntelligence(Board board, String token) {
        super(token);
        this.board = board;
    }
    
 /**
 * Metodi generoi tekoälypelaajan seuraavan siirron
 * @return move merkkijono, joka on muotoa "seuraavan siirron rivi,seuraavan siirron sarake"
 */

    public String generateMove() {
        String move = board.emptySpots().get(new java.util.Random().nextInt(board.emptySpots().size()));
        return move;
    }

}
