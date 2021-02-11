/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * produce il valore e lo inserisce nella coda
 *
 * @author tss
 */
public class App3Productor implements Runnable {

    private final String nome;
    private final int intervallo;
    private final StringBuilder log = new StringBuilder();
    private final App3Coda coda;
    private final String[] testo;

    public App3Productor(String nome, int intervallo, App3Coda coda, String[] testo) {
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
                coda.aggiungi(testo[i]);
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
