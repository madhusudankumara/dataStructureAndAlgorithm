package java_collection.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ManageStock {
    public static final int CAPACITY = 5;
    Queue<Integer> productQueue = new LinkedList<>();
    public volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        ManageStock ms = new ManageStock();

        Thread producer1 = new Thread(new Producer(ms));
        Thread producer2 = new Thread(new Producer(ms));
        Thread consumer1 = new Thread(new Consumer(ms));
        Thread consumer2 = new Thread(new Consumer(ms));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        Thread.sleep(10000);
        System.out.println("Thread is slept for for 10000ms");


        ms.stop();

        consumer1.join();
        System.out.println("consumer1 stopped");
        consumer2.join();
        System.out.println("consumer2 stopped");
        producer1.join();
        System.out.println("producer1 stoped");
        producer2.join();
        System.out.println("producer2 stoped");

        System.out.println("All the threads have been terminated");

    }

    public void stop() {
        synchronized (this) {
            running = false;
            System.out.println("Now running is false");
            notifyAll();
        }
    }

    public void produce(int value) throws InterruptedException {
        synchronized (this) {
            while (productQueue.size() == CAPACITY && running) {
                wait();
            }
            if (!running) return;
            productQueue.add(value);
            System.out.println("Produced " + value);
            notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (productQueue.isEmpty() && running) {
                wait();
            }
            if (!running) return;
            int value = productQueue.poll();
            System.out.println("Consumed " + value);
            notifyAll();
        }
    }
}
