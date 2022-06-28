package Exercice_4_prioriteLecture_mutex;

public class Lecteur extends Thread{
    private int nbLecture = 5;
    private Journal canard;

    public Lecteur (Journal enchaine){
        canard = enchaine;
    }

    public void run() {
        int nbLecteurs;
        while (nbLecture > 0) {
            Journal.travaille();
            nbLecteurs = canard.demandeLecture();
            System.out.println(Thread.currentThread().getName() + " lit ... " );
            System.out.println(nbLecteurs + " en attente");
            Journal.travaille();
            nbLecteurs = canard.finLecture();
            nbLecture --;
            System.out.println(Thread.currentThread().getName() + " ne lit plus, encore " + nbLecture + " a faire");
        }
    }
}
