package java_collection.ProducerConsumer;

public class Consumer implements Runnable {
    private final ManageStock ms;

    public Consumer(ManageStock ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        while (ms.running) {
            try {
                ms.consume();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Consumer thread terminated");
    }
}
