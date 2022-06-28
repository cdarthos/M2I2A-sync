package Exercice_4_prioriteLecture_mutex;

public class Redacteur  extends Thread{
    private int nbRedaction = 2;
    private Journal canard;

    public Redacteur (Journal enchaine) {
        canard = enchaine;
    }

    public void run () {
        while (nbRedaction > 0) {
            Journal.travaille();
            canard.demandeRedaction();
            System.out.println(Thread.currentThread().getName() + " ecrit ... ");
            Journal.travaille();
            canard.finRedaction();
            nbRedaction--;
            System.out.println(Thread.currentThread().getName() + " n'ecrit' plus, encore " + nbRedaction + " a faire");

        }
    }

}
