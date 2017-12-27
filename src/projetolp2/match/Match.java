/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import java.awt.HeadlessException;
import projetolp2.match.MatchIO;
import projetolp2.player.Player;
import projetolp2.player.PlayerFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import projetolp2.exceptions.InvalidInputException;
import projetolp2.exceptions.MatchNotFoundException;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Match implements Serializable{
    public Date date;
    public Difficult difficult;
    public Player player;
    
    public Match() { 
        JOptionPane.showMessageDialog(null,"\nBem-vindo ao Munchkin!"+"\nEstá pronto para começar essa aventura?","Olá novo jogador",JOptionPane.INFORMATION_MESSAGE);
        startMatch();
        Gear[] allgear = GearFactory.createGear();
        
        Difficult dif1 = this.difficult;
        
        int  op = 0;
        do{
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer?"
                        + "\n1 - Visualizar perfil."
                        + "\n2 - Visualizar inventário."
                        + "\n3 - Entrar em uma dungeon."
                        + "\n4 - Ir para o mercado."
                        + "\n5 - Sair do jogo."));
                switch (op) {
                    case 1:
                        JOptionPane.showMessageDialog(null, this.player);
                        break;
                    case 2:
                        String str = "Seus itens equipados:";
                        for (Gear gear : player.getInventory().getGear()) {
                            if (gear == null) {
                                str += ("\n (Vazio)");
                            } else {
                                str += ("\n" + gear);
                            }
                        }
                        JOptionPane.showMessageDialog(null, str);
                        boolean control = false;
                        do {
                            try {
                                str = "Seu inventário: (Pressione o número do item para equipa-lo ou 0 para sair)";
                                int i = 1;
                                for (Gear item : player.getInventory().getItems()) {
                                    str += ("\n" + i + " - " + item);
                                    i++;
                                }
                                int equip = Integer.parseInt(JOptionPane.showInputDialog(str));
                                if (equip == 0) {
                                    break;
                                } else if (equip > 0 && equip < 6) {
                                    Gear newItem = this.player.getInventory().getItems().get(equip - 1);
                                    Gear oldItem = this.player.getInventory().getGear()[newItem.getBodyPart()];
                                    this.player.getInventory().getGear()[newItem.getBodyPart()] = null;
                                    this.player.getInventory().getItems().remove(equip - 1);
                                    this.player.setLevel((newItem.getBonus()) - (oldItem.getBonus()));
                                    String msg = "Você equipou " + newItem.getName() + ", e seu equipamento anterior foi movido para o inventário.";
                                    this.player.getInventory().addItem(oldItem, msg);
                                    this.player.getInventory().setGear(newItem, newItem.getBodyPart());
                                    control = true;
                                } else {
                                    throw new InvalidInputException("Input inválido!");
                                }
                            } catch (InvalidInputException | NumberFormatException | IndexOutOfBoundsException ex) {
                                JOptionPane.showMessageDialog(null, "Você digitou algo inválido!");
                            }
                        } while (!control);                        
                        break;
                    case 3:                        
                        Dungeon d1 = new Dungeon(allgear, this.player, dif1);
                        break;
                    case 4:                        
                        Market m2 = new Market(allgear, this.player);
                        break;                    
                    case 5:
                        MatchIO.saveMatch(this);                        
                        break;
                    default:
                        throw new InvalidInputException("Input inválido!");
                }
                if (player.getLevel() >= 20) {
                    JOptionPane.showMessageDialog(null, "Você chegou ao nível 20 e terminou o jogo! Parabéns!");
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                JOptionPane.showMessageDialog(null,"Você digitou algo inválido!");
            }
           
        }while (op!=5 && player.getLevel()<20);
        
    }
   

  
    public Match loadMatch(){
        Match m1 = MatchIO.loadMatch();
        return m1;
    }

    public Date getDate() {
        return date;
    }
    
    public void startMatch(){
        try {
            Player p1;
            int op2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Começar nova partida."
                    + "\n2 - Carregar partida anterior."));
            if (op2 == 1) {
                this.player = PlayerFactory.createPlayer();                
                this.date = new Date();
                this.difficult = setDifficult();
            } else if(op2==2){
                Match m1 = loadMatch();
                if (m1.getDifficult() == null) {
                    throw new MatchNotFoundException("Partida não encontrada!");
                } else {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    this.difficult = m1.getDifficult();
                    this.player = m1.getPlayer();
                    String date_str = df.format(m1.getDate());
                    JOptionPane.showMessageDialog(null, this.player + "\nDificuldade: " + this.difficult.getName() + "\nData jogada: " + date_str);                    
                }
            }else throw new InvalidInputException("Input inválido!");
        } catch (MatchNotFoundException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null,"Nenhuma partida foi encontrada!");
                this.player = PlayerFactory.createPlayer();   
                this.date = new Date();
                this.difficult = setDifficult();
        } catch (InvalidInputException ex){
            JOptionPane.showMessageDialog(null,"Você digitou algo inválido!");
            startMatch();
        }
        
    }

    public Difficult getDifficult() {
        return difficult;
    }
    
    
    
    public Difficult setDifficult(){
        try {
            int op = Integer.parseInt(JOptionPane.showInputDialog("\nSelecione a dificuldade do jogo:"
                    + "\n1 - Fácil"
                    + "\n2 - Normal"
                    + "\n3 - Difícil"));
            
            switch (op) {
                case 1:                    
                    int chanceBreak = 80;                    
                    int chanceEscape = 3;                    
                    int chanceSpawnLoot = 60;                    
                    int chanceSpawnMonster = 2;
                    int maxDropMonster = 250;
                    
                    Difficult easy = new Difficult("Fácil", chanceBreak, chanceEscape, chanceSpawnLoot, chanceSpawnMonster, maxDropMonster);
                    return easy;
                case 2:                    
                    int mchanceBreak = 60;                    
                    int mchanceEscape = 4;                    
                    int mchanceSpawnLoot = 80;                    
                    int mchanceSpawnMonster = 2;
                    int mmaxDropMonster = 200;
                    
                    Difficult medium = new Difficult("Médio", mchanceBreak, mchanceEscape, mchanceSpawnLoot, mchanceSpawnMonster, mmaxDropMonster);
                    return medium;
                
                case 3:                    
                    int hchanceBreak = 30;                    
                    int hchanceEscape = 5;                    
                    int hchanceSpawnLoot = 90;                    
                    int hchanceSpawnMonster = 3;
                    int hmaxDropMonster = 150;
                    
                    Difficult hard = new Difficult("Difícil", hchanceBreak, hchanceEscape, hchanceSpawnLoot, hchanceSpawnMonster, hmaxDropMonster);
                    return hard;
                default:
                    throw new InvalidInputException("Input inválido!");
            }

        } catch (InvalidInputException | NumberFormatException ex) {
           JOptionPane.showMessageDialog(null,"Você digitou uma dificuldade inválida!");
           return setDifficult();
        }
        
    }

    @Override
    public String toString() {
        return "Match{" + "date=" + date + ", difficult=" + difficult + '}';
    }

    public Player getPlayer() {
        return player;
    }
    
    
   
}
