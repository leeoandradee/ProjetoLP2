/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import projetolp2.player.Race;
import java.io.Serializable;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Player implements Serializable{
    private String name;
    private int level, money;
    private Inventory inventory;
    private Race race;
    private Classe Classe;

    public Player(String name, Race race, Classe Class) {
        this.inventory = new Inventory();
        this.name = name;
        this.level = 1;
        this.money = 0;
        this.race = race;
        this.Classe = Class;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Race getRace() {
        return race;
    }

    public Classe getClasse() {
        return Classe;
    }

    public void setLevel(int level) {
        this.level += level;
        if(this.level<1) this.level=1;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }
    
    @Override
    public String toString() {
        return "Player" + "\nNome: " + name + "\nNível: " + level + "\nDinheiro: " + money +"\nRaça: " + race + "\nClasse: " + Classe;
    }

    public void setLevelO(int level){
        this.level = level;
    }
    
}
