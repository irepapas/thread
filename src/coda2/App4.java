/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coda2;

import java.util.concurrent.ArrayBlockingQueue;
import threads.App3Consumer;

/**
 *
 * @author tss
 */
public class App4 {
    
    public static void main(String[] args) throws InterruptedException {
        
        ArrayBlockingQueue<String> c = new ArrayBlockingQueue<>(20);
      
        String[] text = "mare mare montagna sole vacanze".split(" ");
        Thread p1 = new Thread(new App4Productor("p1", 1, c, text));
        Thread c1 = new Thread(new App4Consumer("c1", 2, c));
        Thread c2 = new Thread(new App4Consumer("c2", 6, c));
        Thread c3 = new Thread(new App4Consumer("c3", 8, c));
        p1.start();c1.start();c2.start();c3.start();
        Thread.sleep(10*1000);
        p1.interrupt();c1.interrupt();c3.interrupt();c2.interrupt();
        System.out.println(c);
    }
    
}
