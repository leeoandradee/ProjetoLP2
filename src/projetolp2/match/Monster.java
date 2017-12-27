/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import projetolp2.match.MonsterEnum;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Monster {
    private int level, loot;
    private MonsterEnum type;
    private int badThing;

    public Monster(int level, int loot, MonsterEnum type, int badThing) {
        this.level = level;
        this.loot = loot;
        this.type = type;
        this.badThing = badThing; 
    }

    public int getLevel() {
        return level;
    }

    public int getLoot() {
        return loot;
    }

    public MonsterEnum getType() {
        return type;
    }
    
    
    
    
    
    
}
