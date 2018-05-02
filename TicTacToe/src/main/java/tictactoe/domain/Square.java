/**
 * Pelilaudan ruudut
 */
package tictactoe.domain;

/**
 *
 * @author minnahir
 */
public class Square {

    private String contents;
/**
 * Konstruktori luo ruudun käyttäjän antamalla syötteellä
 * @param contents ruutuun haluttu sisältö   
 */
    public Square(String contents) {
        this.contents = contents;
    }

/**
 * Metodi palauttaa ruudun sisällön
 * @return ruudun sisältö 
 */
    public String getContents() {
        return this.contents;
    }

 /**
 * Metodi asettaa ruutuun käyttäjän haluaman sisällön
 * @param contents ruutuun haluttu sisältö 
 */
    public void setContents(String contents) {
        this.contents = contents;
    }

}
