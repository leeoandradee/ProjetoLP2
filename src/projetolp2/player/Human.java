/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import projetolp2.player.Player;
import projetolp2.player.Race;
import javax.swing.JOptionPane;
import projetolp2.match.Monster;
import projetolp2.match.MonsterEnum;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Human extends Race{
    private final String name = "Human";
    private final MonsterEnum[] fullAttack = {MonsterEnum.FANTASMA,MonsterEnum.ZUMBI};
    private final MonsterEnum[] halfAttack = {MonsterEnum.DRAGÃO, MonsterEnum.BANDIDO, MonsterEnum.GIGANTE};
    
    
    
    @Override
    public int applyBonus(Monster m1, Player p1) {
        int old_level = p1.getLevel();
        for (int i = 0; i < fullAttack.length; i++) {
            if(m1.getType()==fullAttack[i]){
                p1.setLevel(1);
                JOptionPane.showMessageDialog(null,"Sua raça possui vantagem contra esse inimigo!");
                return old_level;
            }
            
        }
        JOptionPane.showMessageDialog(null,"Sua raça possui desvantagem contra esse inimigo!");
        p1.setLevel(-1);
        return old_level;
    }

    @Override
    public void returnLevel(Player p1,int level) {
        p1.setLevelO(level);
    }
    
    @Override
    public String toString() {
        return "Humano";
    }

    
    
}
