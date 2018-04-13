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
public class Player {
    private String token;
    
    public Player(String token){
        this.token=token;
    }
    
    public String getToken(){
        return this.token;
    }
}
