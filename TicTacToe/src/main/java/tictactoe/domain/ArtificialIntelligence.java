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
public class ArtificialIntelligence extends Player {

    private Board board;

    public ArtificialIntelligence(Board board, String token) {
        super(token);
        this.board = board;
    }

    public String generateMove() {
        String move = board.emptySpots().get(new java.util.Random().nextInt(board.emptySpots().size()));
        return move;
    }

}
