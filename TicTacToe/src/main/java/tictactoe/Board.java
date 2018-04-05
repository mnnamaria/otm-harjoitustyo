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
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private ArrayList<String> board;
    private Scanner scanner;
    private int tokens;
    private String winner;
    
    public Board(){
        this.board= new ArrayList<String>();
        for (int i = 0; i<9; i++){
            board.add("[ ]");
        }
        this.tokens = 0;
        this.scanner = new Scanner(System.in);
        this.winner = null;
    }
    
    public void printBoard(){

        System.out.println("----------");
        System.out.println("");
            for (int j = 0; j<9; j++){
                System.out.print(board.get(j));
                if((j+1)%3==0){
                    System.out.println("\n");
                }
        }
        System.out.println("----------");

    }
    
    public boolean validMove(int position){
        if(position < 1 || position > 9){
            System.out.println("Number not in range (1-9), choose another position:");
            return false;
        } else if(!board.get(position-1).equals("[ ]")){
            System.out.println("Position already taken, choose another one:");
            return false;
        } else {
            return true;
        }
    }    
  
    
    public boolean gameOver(){
        if (threeInARow("X")){
            System.out.println("Game over, the winner is " + this.winner);
            return true;
        } else if(threeInARow("O")){
            System.out.println("Game over, the winner is " + this.winner);
            return true;
        } else if(tokens==9){
            System.out.println("Game over, the board is full");
            return true;
        }
        return false;

    }
    
    public boolean threeInARow(String token){
        if(board.get(0).equals("["+ token + "]")&&board.get(1).equals("["+ token + "]")&&board.get(2).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(3).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(5).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(6).equals("["+ token + "]")&&board.get(7).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(0).equals("["+ token + "]")&&board.get(3).equals("["+ token + "]")&&board.get(6).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(1).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(7).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(2).equals("["+ token + "]")&&board.get(5).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            this.winner=token;
            return true;
        } else if (board.get(0).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            this.winner=token;
            return true;
        }else if (board.get(2).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(6).equals("["+ token + "]")){
            this.winner=token;
            return true;
        }
        return false;
    }
    
    public void setToBoard(String token, int position){
        if(!validMove(position)){
            int newPosition = Integer.parseInt(scanner.nextLine());
            setToBoard(token, newPosition);
        } else {
            tokens++;
            board.set(position-1, "["+token+"]");
            printBoard();
        }
    }
    
    public String getWinner(){
        return this.winner;
    }
}

