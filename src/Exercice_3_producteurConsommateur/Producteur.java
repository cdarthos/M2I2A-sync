package Exercice_3_producteurConsommateur;

public class Producteur extends Thread{
    protected final Buffer buffer;

    public Producteur (Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        try{
            for (int j =100; j > 0; j--){
                Thread.sleep(50);
                buffer.put(Integer.valueOf(j));
                System.out.println("Producter : " + j + " done");
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException : " + e.getMessage());
        }
        return;
    }

}
