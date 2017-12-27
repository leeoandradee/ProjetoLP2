/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import projetolp2.player.Player;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Mage extends Classe{
    private final String name = "Mage";

    @Override
    public void applyBonus(Player p1) {
        if(p1.getInventory().getGear()[4].getName().contains("Cajado") ||p1.getInventory().getGear()[4].getName().contains("Varinha")){
            p1.setLevel(1);
        } 
    }

    

    @Override
    public String toString() {
        return "Mago";
    }

   
    
    
}
