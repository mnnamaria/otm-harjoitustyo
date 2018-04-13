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
import java.util.Scanner;
public class Game {
    private Board board;
    //private String playerX;
    //private String playerO;
    private Player playerX;
    private Player playerO;
    private int moves;
    private Scanner scanner;
    
    public Game(){
        this.board = new Board();
        this.playerX = new Player("X");
        this.playerO = new Player("O");
        this.moves = 1;
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
                System.out.println("X plays, choose column (a number between 1-3):");
                int newPositionX = Integer.parseInt(scanner.nextLine());
                System.out.println("X plays, choose row (a number between 1-3):");
                int newPositionY = Integer.parseInt(scanner.nextLine());
                
                board.setToBoard(playerX.getToken(), newPositionX,newPositionY);
//                System.out.println("X plays, choose an empty position (a number between 1-9):");
//                int position = Integer.parseInt(scanner.nextLine());
                //board.setToBoard(playerX.getToken(), position);
                moves++;
            } else {
                System.out.println("O plays, choose column (a number between 1-3):");
                int newPositionX = Integer.parseInt(scanner.nextLine());
                System.out.println("O plays, choose row (a number between 1-3):");
                int newPositionY = Integer.parseInt(scanner.nextLine());
                
                board.setToBoard(playerO.getToken(), newPositionX,newPositionY);
//                System.out.println("O plays, choose an empty position (a number between 1-9):");
//                int position = Integer.parseInt(scanner.nextLine());
//                board.setToBoard(playerO.getToken(), position);
                moves++;
            }
        }
    }
    
    public int getMoves(){
        return this.moves;
    }
    
    public void addMove(){
        this.moves++;
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    
}
