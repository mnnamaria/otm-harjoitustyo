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
import java.util.Scanner;
public class Game {
    private Board board;
    private String playerX;
    private String playerO;
    private int moves;
    private Scanner scanner;
    
    Game(){
        this.board = new Board();
        this.playerX="X";
        this.playerO="O";
        this.moves = 0;
        this.scanner = new Scanner (System.in);
    }
    
    public void playGame(){
        while(true){
            if(board.gameOver()){
                break;
            }
            
            if(this.moves==0){
                board.printBoard();
                moves++;
            }else if(this.moves%2==1){
                System.out.println("X plays, choose an empty position (a number between 1-9):");
                int position = Integer.parseInt(scanner.nextLine());
                board.setToBoard(playerX, position);
                moves++;
            } else {
                System.out.println("O plays, choose an empty position (a number between 1-9):");
                int position = Integer.parseInt(scanner.nextLine());
                board.setToBoard(playerO, position);
                moves++;
            }
        }
    }
    
    
}
