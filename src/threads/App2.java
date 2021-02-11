/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**Un thread continua a stampare stringhe 
 * e un altro (il main) lo interrompe dopo 10 sec.
 *
 * @author tss
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        runnable a dichiarazione mi permette di usare solo i suoi metodi 
        a runtime lo dichiaro come una classe che lo implementa 
        */
        Runnable worker = new App2Worker("work!!"); 
        Thread t = new Thread(worker); //parametro è variabile di Runnable definifta in precedenza 
        t.start();
        // main interrompe la stampa delle stringhe 
        Thread.sleep(10*1000);
        t.interrupt();
     }
}
