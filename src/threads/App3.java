/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author tss
 */
public class App3 {
    
    public static void main(String[] args) throws InterruptedException {
        App3Coda c = new App3Coda(20);
        String[] text = "mare mare mare".split(" ");
        Thread p1 = new Thread(new App3Productor("p1", 1, c, text));
        Thread c1 = new Thread(new App3Consumer("c1", 2, c));
        Thread c2 = new Thread(new App3Consumer("c2", 4, c));
        Thread c3 = new Thread(new App3Consumer("c3", 8, c));
        p1.start();c1.start();c2.start();c3.start();
        Thread.sleep(10*1000);
        p1.interrupt();c1.interrupt();c3.interrupt();c2.interrupt();
        System.out.println(c);
        
       
        
    }
    
}
