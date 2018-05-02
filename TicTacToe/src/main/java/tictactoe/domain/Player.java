/**
 * Pelin pelaaja
 */
package tictactoe.domain;

/**
 *
 * @author minnahir
 */
public class Player {

    private String token;
/**
 * Konstruktori luo pelaajan, jonka pelimerkiksi tulee käyttäjän antama syöte
 * @param token pelaajan pelimerkki
 */
    
    public Player(String token) {
        this.token = token;
    }

 /**
 * Metodi palauttaa pelaajan pelimerkin
 * @return pelimerkki
 */
    public String getToken() {
        return this.token;
    }
}
