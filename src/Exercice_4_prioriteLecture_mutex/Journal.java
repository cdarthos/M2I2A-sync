package Exercice_4_prioriteLecture_mutex;

public class Journal {
    public static final int PAUSE = 5;

    private int nbLecteurs;
    private boolean Lecture;
    private boolean Redaction;

    public Journal () {
        nbLecteurs = 0;
        Lecture = false;
        Redaction = false;
    }

    public synchronized int demandeLecture () {
        while (Redaction == true) {
            try{
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        nbLecteurs ++;

        if (nbLecteurs == 1) {
            Lecture = true;
        }
        return nbLecteurs;
    }

    public synchronized int finLecture () {
        nbLecteurs --;

        if (nbLecteurs == 0) {
            Lecture = false;
        }

        notifyAll();
        return nbLecteurs;
    }

    public synchronized void demandeRedaction() {
        while (Lecture == true || Redaction == true){
            try {
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        Redaction = true;
    }

    public synchronized void finRedaction() {
        Redaction = false;
        notifyAll();
    }

    public static void travaille () {
        int tpspause = (int) ( PAUSE * Math.random());
        try {
            Thread.sleep(tpspause * 100);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
