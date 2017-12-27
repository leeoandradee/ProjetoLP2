/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp2.match;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 *@author Leonardo Andrade dos Santos
 *@author Igor Vallim
 */
public class MatchIO {
    
    public static Match loadMatch(){ 
        File f = new File("Match.txt");
        Match m1 = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            m1 = (Match)ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return m1;
    }
    
    public static void saveMatch(Match m1){
        File f = new File("Match.txt");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m1);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Problema no fluxo de saída");
        }
    }
}
