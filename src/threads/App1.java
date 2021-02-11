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
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       App1Worker t1= new App1Worker("Worker1",15);
       App1Worker t2= new App1Worker("Worker2",30);
       t1.start();
       t2.start();
    }
    
}
