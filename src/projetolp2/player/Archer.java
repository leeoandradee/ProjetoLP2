/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import projetolp2.player.Player;

/**
 *
 * @author 31627862
 */
public class Archer extends Classe{
    private final String name = "Archer";

    @Override
    public void applyBonus(Player p1) {
        if(p1.getInventory().getGear()[4].getName().contains("Arco")){
            p1.setLevel(1);
        } 
    }

    

    @Override
    public String toString() {
        return "Arqueiro";
    }

  
    
    
    
    
}
