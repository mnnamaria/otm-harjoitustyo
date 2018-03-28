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
    private int tokens;
    
    Board(){
        this.board= new ArrayList<String>();
        for (int i = 0; i<9; i++){
            board.add("[ ]");
        }
        this.tokens = 0;
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
            return false;
        } else if(!board.get(position-1).equals("[ ]")){
            return false;
        } else {
            return true;
        }
    }    
    
    public boolean boardFull(){
        if(tokens ==9){
            System.out.println("The board is full");
            return true;
        } else {
            return false;
        }
    }    
    
    public boolean gameOver(){
        if(boardFull()){
            System.out.println("Game over!");
            return true;
        } else if (threeInARow("X")){
            return true;
        } else if(threeInARow("O")){
            return true;
        }
        
        return false;

    }
    
    public boolean threeInARow(String token){
        if(board.get(0).equals("["+ token + "]")&&board.get(1).equals("["+ token + "]")&&board.get(2).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(3).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(5).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(6).equals("["+ token + "]")&&board.get(7).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(0).equals("["+ token + "]")&&board.get(3).equals("["+ token + "]")&&board.get(6).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(1).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(7).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(2).equals("["+ token + "]")&&board.get(5).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        } else if (board.get(0).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(8).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        }else if (board.get(2).equals("["+ token + "]")&&board.get(4).equals("["+ token + "]")&&board.get(6).equals("["+ token + "]")){
            System.out.println("The winner is " + token);
            return true;
        }
        return false;
    }
    
    public void setToBoard(String token, int position){
        if(boardFull()){
            System.out.println("Move not valid, the board is full");
            gameOver();
        } else if(!validMove(position)){
            System.out.println("Move not valid, choose another position:");
            Scanner scanner = new Scanner (System.in);
            int newPosition = Integer.parseInt(scanner.nextLine());
            setToBoard(token, newPosition);
        } else {
            tokens++;
            board.set(position-1, "["+token+"]");
            printBoard();
        }
    }
}

