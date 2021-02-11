/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coda2;

import java.util.concurrent.BlockingQueue;



/**
 * produce il valore e lo inserisce nella coda
 *
 * @author tss
 */
public class App4Productor implements Runnable {

    private final String nome;
    private final int intervallo;
    private final StringBuilder log = new StringBuilder();
    private final BlockingQueue<String>coda;
    private final String[] testo;

    public App4Productor(String nome, int intervallo, BlockingQueue<String> coda, String[] testo) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.coda = coda;
        this.testo = testo;
    }
    
    

  
    @Override
    public void run() {
        try {
            int i = 0;

            while (true) {
                coda.put(testo[i]);
                log.append(" ").append(testo[i]);
                i = (i + 1) % testo.length;
                long p = (long) (Math.random() * 1000 * intervallo);
                Thread.sleep(p);
            }

        } catch (InterruptedException e) {
        }
        System.out.println(nome + " " + log);

    }

}
