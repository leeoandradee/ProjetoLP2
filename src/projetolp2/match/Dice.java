/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Dice {
    private static Dice instance;
    public int selectedFace;
    
    private Dice(){
        this.selectedFace = 1;
    }
    
    public static Dice getInstance(){
        if(instance == null){        /*se o dado já esta criado*/
            instance = new Dice();   /*cria um novo dado*/
        }
        return instance;             /*smp retornar o valor do dado*/
    }
    
    public int rollDice(){
        int min = 1;
        int max = 6;
        selectedFace = min + (int)(Math.random() * (max - min + 1));
    
        return  selectedFace;
                
    }
}
