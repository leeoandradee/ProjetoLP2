/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import java.io.Serializable;

/**
 *
 * @author 31644961
 */
public class Gear implements Serializable{
    private int bonus, bodyPart, price;
    private String name;
    

    public Gear(int bonus, int bodyPart, String name, int price) {
        this.bonus = bonus;
        this.bodyPart = bodyPart;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" (+"+bonus+")";
    }

    public int getBonus() {
        return bonus;
    }

    public int getBodyPart() {
        return bodyPart;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    
    

   

   
    
    
    
}
