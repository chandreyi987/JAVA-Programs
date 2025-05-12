import java.util.*;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private final Queue queue = new LinkedList();
    private final Object lock = new Object();

    class Producer implements Runnable {
        public void run() {
            int value = 0;
            while (true) {
                synchronized (lock) {
                    while (queue.size() == CAPACITY) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(value);
                    System.out.println("Produced: " + value);
                    value++;
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (queue.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = (int) queue.poll();
                    System.out.println("Consumed: " + value);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.start();
    }
}
