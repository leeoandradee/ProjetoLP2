/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Warrior extends Classe{
    private final String name = "Warrior";

    @Override
    public void applyBonus(Player p1) {
        if(p1.getInventory().getGear()[4].getName().contains("Espada")){
            p1.setLevel(1);
        }
    } 

    @Override
    public String toString() {
        return "Guerreiro";
    }
    
    
    
}
