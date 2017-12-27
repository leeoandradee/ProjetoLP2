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
public class GearFactory {
    
    public static Gear[] createGear(){
        Gear l1 = new Gear(1,0,"Capacete de couro",200);
        Gear l2 = new Gear(1,1,"Peitoral de couro",200);
        Gear l3 = new Gear(1,2,"Calças de couro",200);
        Gear l4 = new Gear(1,3,"Botas de couro",200);
        Gear l5 = new Gear(1,4,"Espada de madeira",200);
        Gear l6 = new Gear(1,4,"Arco de madeira",200);
        Gear l7 = new Gear(1,4,"Varinha mágica",200);

        Gear i1 = new Gear(2,0,"Capacete de aço",400);
        Gear i2 = new Gear(2,1,"Peitoral de aço",400);
        Gear i3 = new Gear(2,2,"Calças de aço",400);
        Gear i4 = new Gear(2,3,"Botas de aço",400);
        Gear i5 = new Gear(2,4,"Espada de aço",400);
        Gear i6 = new Gear(2,4,"Arco de ossos",400);
        Gear i7 = new Gear(2,4,"Cajado de fogo",400);

        Gear d1 = new Gear(3,0,"Capacete de diamante",800);
        Gear d2 = new Gear(3,1,"Peitoral de diamante",800);
        Gear d3 = new Gear(3,2,"Calças de diamante",800);
        Gear d4 = new Gear(3,3,"Botas de diamante",800);
        Gear d5 = new Gear(3,4,"Espada de diamante",800);
        Gear d6 = new Gear(3,4,"Arco élfico",800);
        Gear d7 = new Gear(3,4,"Cajado arcano",800);
        
        Gear[] allGear = {l1, l2, l3, l4, l5, l6, l7, i1, i2, i3, i4, i5, i6, i7, d1, d2, d3, d4, d5, d6, d7};
        return allGear;
    } 
}
