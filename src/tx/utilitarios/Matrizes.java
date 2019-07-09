/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tx.utilitarios;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class Matrizes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de linhas: ");
        
        int nome1 = scan.nextInt();
        
        System.out.println(nome1);

        /*123
        int x[][] = new int[2][2];
        x[0][0] = 5;
        x[0][1] = 10;
        x[1][0] = 15;
        x[1][1] = 20;

        for (int i = 0, j = 0; i < x.length && j < x.length; i++, j++) {
            System.out.println("| " + x[i][0]++ + " | " + (x[i][1] + 1) + "|");
            System.out.println("---------");
        }
         */
    }
}
