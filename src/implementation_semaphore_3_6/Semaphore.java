package implementation_semaphore_3_6;

public class Semaphore {
    private int capteur = 0;

    public Semaphore (int c){
        capteur =c;
    }

    public synchronized  void  prendreSemaphore() throws InterruptedException {
        while ( capteur == 0) {
            this.wait();
        }
        capteur --;
    }

    public synchronized void rendreSemaphore(){
        capteur ++ ;
        this.notify();
    }

}

