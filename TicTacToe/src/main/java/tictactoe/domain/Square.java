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
public class Square {

    private String contents;

    public Square() {
        this.contents = "";
    }

    public Square(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}
