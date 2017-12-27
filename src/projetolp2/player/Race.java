/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import java.io.Serializable;
import projetolp2.match.Monster;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public abstract class Race implements Serializable{
    
    public abstract int applyBonus(Monster m1, Player p1);
    public abstract void returnLevel(Player p1, int level);
}
