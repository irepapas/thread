/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.LinkedList;

/**oggetto condiviso tra produttore e consumaotre 
 * il produttore sospende se la coda è piena 
 * si riattiva quando c'è una posizione libera 
 *
 * @author tss
 */
public class App3Coda {
    
    private final int capacita;
    private final  LinkedList<String> coda;
    /*
    al posto di costruire la coda si poteva utilizzare ArrayBlockingQueue
    */
    
    // contatori di quelli in attesa tra prod e consumatori
    private int nProd,nCons;
    
    
    public App3Coda(int capacita) {
        this.capacita = capacita;
        coda = new LinkedList<>();
    }

    
    public synchronized void aggiungi(String s) throws InterruptedException{
        while(coda.size()==capacita){
           nProd++;
           wait();
        }
         coda.add(s);
         notifyAll();
    }
    
    public  synchronized String togli() throws InterruptedException{
        while(coda.isEmpty()){
            nCons++;
            wait();
        }
        String s="";
        coda.remove(s);
        notifyAll();
        return s;
    }

    @Override
    public synchronized String toString() {
        return "App3Coda{" + "nProd in attesa=" + nProd + ", nCons in attesa=" + nCons + '}';
    }
    
}
