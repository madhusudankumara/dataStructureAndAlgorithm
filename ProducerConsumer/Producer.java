package java_collection.ProducerConsumer;

public class Producer implements Runnable {
    private final ManageStock ms;

    public Producer(ManageStock ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        int value = 0;
        while (ms.running) {
            try {
                ms.produce(value++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Producer thread terminated");
    }
}

