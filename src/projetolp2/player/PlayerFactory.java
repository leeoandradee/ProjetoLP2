/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.player;

import java.awt.HeadlessException;
import projetolp2.player.Race;
import projetolp2.player.Warrior;
import javax.swing.JOptionPane;
import projetolp2.exceptions.InvalidInputException;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class PlayerFactory {

    public static Player createPlayer() {
        JOptionPane.showMessageDialog(null,"Vamos começar criando seu perfil...");
        String nome = writeName();
        Race r = chooseRace();
        Classe c= chooseClass();
        Player p1 = new Player (nome,r,c);
        JOptionPane.showMessageDialog(null,"\nPerfil criado com sucesso!");
        return p1;
        
    }
    
    public static Race chooseRace(){
        int op = 0;
        try{
            do{
                op = Integer.parseInt(JOptionPane.showInputDialog("\nEscolha sua raça: "
                                                        +"\n_________________"
                                                        +"\n1 - Elfo"
                                                        +"\n2 - Anão"
                                                        +"\n3 - Humano"));
                    if(op<1||op>3) throw new InvalidInputException("Input inválido!");                                     
            }while(op<1||op>3);
            
        }catch(NumberFormatException | InvalidInputException ex){
            JOptionPane.showMessageDialog(null,"Ops! Você digitou algo inválido");
            return chooseRace();
        }
        
        Race r = null;
        
        switch (op){
            case 1:
                Race r1 = new Elf();
                r = r1;
            break;
            
            case 2:
                Race r2 = new Dwarf();
                r = r2;
            break;
            
            case 3:
                Race r3 = new Human();
                r = r3;
            break;
        }
        return r;
    }
    
    public static Classe chooseClass(){
        int op = 0;
        try{
           do{ 
            op = Integer.parseInt(JOptionPane.showInputDialog("\nEscolha sua classe: "
                                                    +"\n_________________"
                                                    +"\n1 - Mago"
                                                    +"\n2 - Guerreiro"
                                                    +"\n3 - Arqueiro"));
                if(op<1||op>3) throw new InvalidInputException("Input inválido!");                                   
           }while(op<1||op>3);
        }catch(NumberFormatException | InvalidInputException ex){
            JOptionPane.showMessageDialog(null,"Ops! Você digitou algo inválido");
            return chooseClass();    
        }
        
        Classe c = null;
        switch (op){
                case 1:
                    Classe c1 = new Mage();
                    c = c1;
                break;

                case 2:
                    Classe c2 = new Warrior();
                    c = c2;
                break;

                case 3:
                   Classe c3 = new Archer();
                   c = c3;
                break;
        }
        return c;
    }
    
    public static String writeName(){
        try {
            String nome = JOptionPane.showInputDialog("\nDigite seu nome: ");
            if (nome.equals("")) {
                throw new InvalidInputException("Input inválido!");                
            }
            return nome;
        } catch (InvalidInputException invalidInputException) {
            JOptionPane.showMessageDialog(null,"O nome não pode ser vazio!");
            return writeName();
        }
    }
    
    
}
