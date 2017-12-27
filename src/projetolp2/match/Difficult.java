/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import java.io.Serializable;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Difficult implements Serializable{
    private String name;
    private int chanceBreak;
    private int chanceEscape;
    private int chanceSpawnLoot;
    private int chanceSpawnMonster;
    private int maxDropMonster;

    public Difficult(String name, int chanceBreak, int chanceEscape, int chanceSpawnLoot, int chanceSpawnMonster, int maxDropMonster) {
        this.chanceBreak = chanceBreak;
        this.chanceEscape = chanceEscape;
        this.chanceSpawnLoot = chanceSpawnLoot;
        this.chanceSpawnMonster = chanceSpawnMonster;
        this.maxDropMonster = maxDropMonster;
        this.name = name;
    }

    public int getChanceBreak() {
        return chanceBreak;
    }

    

    public int getChanceEscape() {
        return chanceEscape;
    }

   

    public int getChanceSpawnLoot() {
        return chanceSpawnLoot;
    }

    

    public int getChanceSpawnMonster() {
        return chanceSpawnMonster;
    }

    public int getMaxDropMonster() {
        return maxDropMonster;
    }

    public String getName() {
        return name;
    }

    
    
    
}
