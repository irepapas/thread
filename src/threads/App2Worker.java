/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App2Worker implements Runnable {

    private final String nome;

    public App2Worker(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(i++ + "" + this.nome);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
       System.out.println("DONE" + this.nome);
    }
}


