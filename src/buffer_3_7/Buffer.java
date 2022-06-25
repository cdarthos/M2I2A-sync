package buffer_3_7;

public class Buffer {
    protected final int max;
    protected final Object data[];

    protected int tete = 0;
    protected int queue = 0;
    protected int count = 0;

    public Buffer (int max){
        this.max = max;
        this.data = new Object[max];
    }

    public synchronized void put ( Object item) {
        while (count == max) {
            try {
                wait();
            }
            catch ( InterruptedException e) {
                System.out.println("InterruptedException : " + e.getMessage());
            }
        }

        data[tete] = item;
        tete = (tete + 1) % max;
        count = count + 1;
        notify();
    }

    public synchronized Object get(){
        while (count == 0){
            try{
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException : " + e.getMessage());
            }
        }
        Object result = data[queue];
        queue = (queue + 1) % max;
        count = count - 1;
        notify();

        return result;
    }
}
