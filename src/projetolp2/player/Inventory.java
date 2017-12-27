/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import java.awt.HeadlessException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import projetolp2.exceptions.FullInventoryException;
import projetolp2.match.Gear;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Inventory implements Serializable{
    private Gear[] gear = new Gear[5];
    private ArrayList<Gear> items = new ArrayList<>();

    public Gear[] getGear() {
        return gear;
    }

    public void setGear(Gear gear, int index) {
        this.gear[index] = gear;
    }

    public ArrayList<Gear> getItems() {
        return items;
    }
    

    @Override
    public String toString() {
        return "Inventory{" + "gear=" + gear + ", items=" + items + '}';
    }
    
    public void addItem(Gear item, String msg){
        
        try {
            if (items.size() < 5) {
                JOptionPane.showMessageDialog(null, msg);
                this.items.add(item);                
            } else {
                throw new FullInventoryException("Inventário cheio!");
            }
        } catch (FullInventoryException fullInventoryException) {
            JOptionPane.showMessageDialog(null,"Você não tem espaço para pegar esse item!");
        }
    }
    
    public void removeItem(int index){
            this.items.remove(index);    
    }
    
    
}
