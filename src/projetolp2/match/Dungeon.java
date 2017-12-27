/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import projetolp2.match.Gear;
import projetolp2.match.Monster;
import projetolp2.match.MonsterEnum;
import projetolp2.player.Player;
import javax.swing.JOptionPane;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class Dungeon {
    
    public Dungeon(Gear[] gear, Player p1, Difficult dif1){
        int level = p1.getLevel();
        int spawnChance = 0 + (int)(Math.random() * ((100 - 0) + 1));
        
        if (spawnChance<=dif1.getChanceSpawnLoot()){
            int badThing = 0 + (int)(Math.random() * ((3 - 0) + 1));
            MonsterEnum type = MonsterEnum.values()[0 + (int)(Math.random() * ((4 - 0) + 1))];
            int levelM;
            if(level<3) levelM=1;
            else levelM = (level-2) + (int)(Math.random() * (((level+dif1.getChanceSpawnMonster()) - (level-2)) + 1));
            int loot = 50 + (int)(Math.random() * ((dif1.getMaxDropMonster() - 50) + 1));
            Monster m1 = new Monster(levelM, loot, type, badThing);
            JOptionPane.showMessageDialog(null,"Você se depara com um "+type+" nível "+levelM+"."+"\n"+"\nSeu level: "+p1.getLevel());
            int old_level = p1.getRace().applyBonus(m1,p1);
            if(p1.getInventory().getGear()[4]!=null) p1.getClasse().applyBonus(p1);
            if(p1.getLevel()>=m1.getLevel()){
                p1.getRace().returnLevel(p1,old_level);
                p1.setLevel(1);
                JOptionPane.showMessageDialog(null,"Você possui nível sufiente e consegue derrotar o monstro em combate, subindo 1 nível!");
                lootMonster(p1, m1);
            }else{
                JOptionPane.showMessageDialog(null,"Você NÃO possui nível suficiente para derrotar o monstro, e terá que lançar o dado para tentar escapar!");
                p1.getRace().returnLevel(p1,old_level);
                Dice d1 = Dice.getInstance();
                d1.rollDice();
                JOptionPane.showMessageDialog(null,"Você tirou "+d1.selectedFace+" no dado.");
                if(d1.selectedFace>=dif1.getChanceEscape()) JOptionPane.showMessageDialog(null,"Você conseguiu escapar, mas não conseguiu recompensa alguma.");
                else {
                    p1.getRace().returnLevel(p1,old_level);
                    p1.setLevel(-2);
                    int chance = 0 + (int)(Math.random() * ((100 - 0) + 1));
                    if(chance<=dif1.getChanceBreak()) JOptionPane.showMessageDialog(null,"Você não consegue escapar e acabou perdendo dois níveis.");
                    else if(p1.getInventory().getGear()[badThing]!=null){
                        String name = p1.getInventory().getGear()[badThing].getName();
                        p1.getInventory().setGear(null, badThing);
                        JOptionPane.showMessageDialog(null,"Você não consegue escapar, perdeu dois níveis, e seu " +name+" se quebrou.");
                    }else JOptionPane.showMessageDialog(null,"Você não consegue escapar e acabou perdendo dois níveis.");
                }
            }
            
        }else{
            lootDungeon(p1, gear);
        }
        
        
    }
    
    public static void lootDungeon(Player p1, Gear[] gear){
        int lootRarity = 0 + (int)(Math.random() * ((100 - 0) + 1));
        Gear loot;
        if (lootRarity<=60) {
          loot = gear[0 + (int)(Math.random() * ((6 - 0) + 1))];
        }else if(lootRarity<=90){
          loot = gear[13 + (int)(Math.random() * ((13 - 7) + 1))];
        }else{
          loot = gear[14 + (int)(Math.random() * ((20 - 14) + 1))];  
        }
        
        String msg;
        JOptionPane.showMessageDialog(null,"Você encontrou "+loot.getName()+"!");
            if(p1.getInventory().getGear()[loot.getBodyPart()]==null){
                p1.setLevel(loot.getBonus());
                p1.getInventory().setGear(loot, loot.getBodyPart());
                JOptionPane.showMessageDialog(null,"Você equipou "+loot.getName()+".");
            }else if(loot.getBonus()>p1.getInventory().getGear()[loot.getBodyPart()].getBonus()){
                p1.setLevel((loot.getBonus())-(p1.getInventory().getGear()[loot.getBodyPart()].getBonus()));
                msg = "Você equipou "+loot.getName()+", e seu equipamento anterior foi movido para o inventário.";
                p1.getInventory().addItem(p1.getInventory().getGear()[loot.getBodyPart()], msg);
                p1.getInventory().setGear(loot, loot.getBodyPart());
            }else{
                msg = loot.getName()+" é inferior ao seu equipamento atual, portanto será armazenado no inventário.";
                p1.getInventory().addItem(loot, msg);
            }
    }
    
    public void lootMonster(Player p1, Monster m1){
        JOptionPane.showMessageDialog(null,"Você encontrou "+m1.getLoot()+" moedas no corpo do inimigo.");
        p1.setMoney(m1.getLoot());
    }
}
