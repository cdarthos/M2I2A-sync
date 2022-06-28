package Exercice_4_prioriteLecture_mutex;

public class LecteurRedacteur {

    static Journal mediapart = new Journal();

    public static void main (String args []){
        Redacteur tabRedacteur[] = new Redacteur[10];
        Lecteur tabLecteur[] = new Lecteur[10];

        for (int i =0; i<10;i++){
            tabLecteur[i] = new Lecteur(mediapart);
            tabRedacteur[i] = new Redacteur(mediapart);
        }

        for (int i = 0; i<10;i++){
            tabLecteur[i].start();
            tabRedacteur[i].start();
        }
    }
}
