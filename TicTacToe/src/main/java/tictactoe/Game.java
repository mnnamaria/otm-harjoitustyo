/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author minnahir
 */
public class Game {
    private Board board;
    private String playerX;
    private String playerO;
    
    Game(){
        this.board = new Board();
        this.playerX="X";
        this.playerO="O";
    }
    
    public void playGame(){
        while(true){
            if(board.gameOver()){
                break;
            }
        }
    }
    
    
}
