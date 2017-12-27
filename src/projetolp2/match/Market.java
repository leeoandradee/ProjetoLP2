/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import java.awt.HeadlessException;
import projetolp2.player.Player;
import javax.swing.JOptionPane;
import projetolp2.exceptions.InvalidInputException;
import projetolp2.exceptions.NotEnoughMoneyException;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Market {
    public Market(Gear[] allgear, Player p1){
        int op = 0;
        do {            
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("1 - Comprar itens.\n2 - Vender itens.\n3 - Voltar."));
                int item;
                switch (op) {
                    case 1:
                        buyMenu(allgear, p1);
                        break;                    
                    case 2:
                        sellMenu(p1);
                        break;
                    case 3:
                        break;
                    default:
                        throw new InvalidInputException("Input inválido!");
                    
                }
            } catch (NumberFormatException | InvalidInputException ex) {
                JOptionPane.showMessageDialog(null,"Você digitou algo inválido!");
            }
        } while (op!=1 && op!=2 && op!=3);
    }
    public void buyMenu(Gear[] allgear, Player p1){
        try {
            int item;
            int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Itens comuns(+1 lvl).\n2 - Itens médios(+2 lvl).\n3 - Itens raros(+3 lvl).\n4 - Voltar."));
            String msg;
            switch (op) {
                case 1:
                    msg = "1 - Capacete de couro - 200 moedas."
                            + "\n2 - Peitoral de couro - 200 moedas."
                            + "\n3 - Calças de couro - 200 moedas."
                            + "\n4 - Botas de couro - 200 moedas."
                            + "\n5 - Espada de madeira - 200 moedas."
                            + "\n6 - Arco de madeira - 200 moedas."
                            + "\n7 - Varinha mágica - 200 moedas."
                            + "\n8 - Voltar."
                            + "\n\nSeu dinheiro: " + p1.getMoney() + " moedas.";
                    item = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
                    if (item == 8) {
                        break;
                    }
                    buyGear(allgear[item - 1], p1);
                    break;
                case 2:
                    msg = "1 - Capacete de aço. - 400 moedas"
                            + "\n2 - Peitoral de aço - 400 moedas."
                            + "\n3 - Calças de aço - 400 moedas."
                            + "\n4 - Botas de aço - 400 moedas."
                            + "\n5 - Espada de aço - 400 moedas."
                            + "\n6 - Arco de ossos - 400 moedas."
                            + "\n7 - Cajado de fogo - 400 moedas."
                            + "\n8 - Voltar."
                            + "\n\nSeu dinheiro: " + p1.getMoney() + " moedas.";
                    item = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
                    if (item == 8) {
                        break;
                    }
                    buyGear(allgear[item + 6], p1);
                    break;                
                case 3:
                    msg = "1 - Capacete de diamante - 800 moedas."
                            + "\n2 - Peitoral de diamante - 800 moedas."
                            + "\n3 - Calças de diamante - 800 moedas."
                            + "\n4 - Botas de diamante - 800 moedas."
                            + "\n5 - Espada de diamante - 800 moedas."
                            + "\n6 - Arco élfico - 800 moedas."
                            + "\n7 - Cajado arcano - 800 moedas."
                            + "\n8 - Voltar."
                            + "\n\nSeu dinheiro: " + p1.getMoney() + " moedas.";
                    item = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
                    if (item == 8) {
                        break;
                    }
                    buyGear(allgear[item + 13], p1);
                    break;                
                case 4:                    
                    break;
                default:
                    throw new InvalidInputException("Input inválido!");
                
            }
        } catch (NumberFormatException | InvalidInputException headlessException) {
            JOptionPane.showMessageDialog(null,"Você digitou algo inválido!");
            buyMenu(allgear, p1);
        }
    }
    
    public void sellMenu(Player p1){
        String msg = "";
        int item;
                int i = 1;
                for (Gear gear : p1.getInventory().getItems()) {
                    if (gear!=null){ 
                        msg+= ("\n"+i+" - "+gear.getName()+" - "+gear.getPrice()/2+" moedas.");
                        i++;        
                    }
                }
                msg+="\n"+i+" - Voltar.";
                
        try {
            item = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
            if (item != i) {
                sellGear(p1, item - 1);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null,"Você digitou algo inválido!");
            sellMenu(p1);
        }
    }
    
    public void buyGear(Gear product, Player p1){
        
        try {
            if (p1.getMoney() < product.getPrice()) {
                throw new NotEnoughMoneyException("Dinheiro insuficiente!");
            } else if (p1.getInventory().getItems().size() >= 5) {
                JOptionPane.showMessageDialog(null, "Você não tem espaço para comprar esse item!");
            } else {
                p1.setMoney(-product.getPrice());
                String msg;
                JOptionPane.showMessageDialog(null, "Você comprou " + product.getName() + "!");
                if (p1.getInventory().getGear()[product.getBodyPart()] == null) {
                    p1.setLevel(product.getBonus());
                    p1.getInventory().setGear(product, product.getBodyPart());
                    JOptionPane.showMessageDialog(null, "Você equipou " + product.getName() + ".");
                } else if (product.getBonus() > p1.getInventory().getGear()[product.getBodyPart()].getBonus()) {
                    p1.setLevel((product.getBonus()) - (p1.getInventory().getGear()[product.getBodyPart()].getBonus()));
                    msg = "Você equipou " + product.getName() + ", e seu equipamento anterior foi movido para o inventário.";
                    p1.getInventory().addItem(p1.getInventory().getGear()[product.getBodyPart()], msg);
                    p1.getInventory().setGear(product, product.getBodyPart());
                } else {
                    msg = product.getName() + " é inferior ao seu equipamento atual, portanto será armazenado no inventário.";
                    p1.getInventory().addItem(product, msg);
                }
            }
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            JOptionPane.showMessageDialog(null,"Você não tem dinheiro suficiente!");
        }
    }
    
    public void sellGear(Player p1, int item){
        p1.setMoney((p1.getInventory().getItems().get(item).getPrice())/2);
        JOptionPane.showMessageDialog(null,"Você vendeu "+p1.getInventory().getItems().get(item).getName()+" por "+p1.getInventory().getItems().get(item).getPrice()/2+" moedas.");
        p1.getInventory().removeItem(item);
    }
}
