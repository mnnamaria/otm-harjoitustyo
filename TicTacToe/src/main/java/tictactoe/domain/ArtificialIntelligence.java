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
public class ArtificialIntelligence {

    private Board board;

    public ArtificialIntelligence(Board board) {
        this.board = board;
    }

    public int generateMove() {
        int move = board.emptySpots().get(new java.util.Random().nextInt(board.emptySpots().size()));
        return move;
    }

    public int getX(Integer position) {
        if (position == 1 || position == 4 || position == 7) {
            return 1;
        } else if (position == 2 || position == 5 || position == 8) {
            return 2;
        } else {
            return 3;
        }
    }

    public int getY(Integer position) {
        if (position == 1 || position == 2 || position == 3) {
            return 1;
        } else if (position == 4 || position == 5 || position == 6) {
            return 2;
        } else {
            return 3;
        }
    }

}
