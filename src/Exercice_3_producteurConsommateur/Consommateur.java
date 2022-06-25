package Exercice_3_producteurConsommateur;

public class Consommateur extends Thread {
    protected final Buffer buffer;

    public Consommateur (Buffer buffer){
        this.buffer = buffer;
    }

    public void run () {
        try{
            for (int j = 100; j > 0; j-- ){
                Integer p = (Integer) (buffer.get());
                int k = p.intValue();
                Thread.sleep(100);
                System.out.println("Consommateur : " + j + " done");
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException : " + e.getMessage());
        }
        return;
    }
}
