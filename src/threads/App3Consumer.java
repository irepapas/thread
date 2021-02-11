/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**consuma il valore del produttore e chiede nuovi valori 
 *
 * @author tss
 */
public class App3Consumer implements Runnable {
    
    private final String nome;
    private final int intervallo;
    private final StringBuilder log = new StringBuilder();
    private final App3Coda coda;
   

    public App3Consumer(String nome, int intervallo, App3Coda coda) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.coda = coda;
        
    }

   
    
    
    
    

    @Override
    public void run() {
         try {
            while (true) {
                String s = coda.togli();
                log.append("").append(s);
                long p = (long) (Math.random() * 1000 * intervallo);
                Thread.sleep(p);
               
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(nome + "" + log);
    }
    
}
