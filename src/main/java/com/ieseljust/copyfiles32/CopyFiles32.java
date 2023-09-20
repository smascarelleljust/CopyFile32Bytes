/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ieseljust.copyfiles32;



/**
 *
 * @author samuel
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.io.*;

/**
 *
 * @author Samuel
 */
public class CopyFiles32 {

    public static void main(String[] args) throws IOException {
        int i, bytes, bytescopied = 0;
        
        byte[] buffer = new byte[1024]; 
        
        FileInputStream fin = null;
        FileOutputStream fout = null;

        //Check possible argument errors
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        // Copy file
        try {
            // open files
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                bytes = fin.read(buffer);
                if (bytes != -1) {
                    fout.write(buffer);
                }
                bytescopied++;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("\rCopiats " + (bytescopied - 1) + " bytes ...");
            } while (bytes != -1);
            System.out.println("Done it!");

        } catch (IOException e) {
            System.out.println("Error d'entrada i eixida: " + e);
            //System.err.println(e);    

        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }

            } catch (IOException e) {
                System.out.println("Error en tancar el fitxer d'origen.");
            }
        }
    }
}