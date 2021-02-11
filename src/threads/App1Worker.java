/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**Due thread stampano 10 stringhe, 
 * ciascuno ad intervalli casuali <= 1 secondo.
 *
 * @author tss
 */
public class App1Worker extends Thread{
    //classe che fa quello che voglio io 
    private final int n; // decido anche quante volte stampare la stringa 
    
    public App1Worker(String name, int n) {
        super(name);
        this.n=n;
    }
    
    
    //stampare per 10 volte o n volte grazie a ciclo for 
    @Override
    public void run() {
       for (int i=0; i<=this.n; i++){
           System.out.println(i+""+ getName());
           //a intervalli casuali usando random
          try {
              sleep((long)(Math.random()*1000));//simula gli intervalli di 10 secondi 
          } catch(InterruptedException e){
              System.out.println(e.getMessage());
          }
       }
        System.out.println("DONE" + getName());
    }
    
      
    
}
