package exclusion_mutuelle_synchronisation_3_5;

public class MesCoordonnees {
    String nom;
    String address;

    public synchronized void maj (String n, String a, int numThread){
        nom = n;
        if (numThread < 2){
            try {
                Thread.currentThread().sleep(1000);
            }
            catch (InterruptedException e){

            }
        }
    }
}
