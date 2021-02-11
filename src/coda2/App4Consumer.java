/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coda2;

import java.util.concurrent.BlockingQueue;


/**consuma il valore del produttore e chiede nuovi valori 
 *
 * @author tss
 */
public class App4Consumer implements Runnable {
    
    private final String nome;
    private final int intervallo;
    private final StringBuilder log = new StringBuilder();
    private final  BlockingQueue<String> coda;

    public App4Consumer(String nome, int intervallo, BlockingQueue<String> coda) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.coda = coda;
    }
   

    

   
    
    
    
    

    @Override
    public void run() {
         try {
            while (true) {
                String s = coda.take();
                log.append("").append(s);
                long p = (long) (Math.random() * 1000 * intervallo);
                Thread.sleep(p);
               
            }
        } catch (InterruptedException ex) {
        }
        System.out.println(nome + " " + log);
    }
    
}
