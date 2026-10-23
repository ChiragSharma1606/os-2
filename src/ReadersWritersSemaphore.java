import java.util.concurrent.Semaphore;

/** Readers-Writers solution using semaphores. */
public class ReadersWritersSemaphore {
    private static final Semaphore mutex = new Semaphore(1);
    private static final Semaphore roomEmpty = new Semaphore(1);
    private static int readerCount = 0;
    private static int sharedValue = 0;

    static class Reader extends Thread {
        private final int id;
        Reader(int id) { this.id = id; }

        public void run() {
            try {
                for (int round = 1; round <= 3; round++) {
                    mutex.acquire();
                    readerCount++;
                    if (readerCount == 1) roomEmpty.acquire();
                    mutex.release();

                    System.out.println("R" + id + " reads value " + sharedValue);
                    Thread.sleep(150);

                    mutex.acquire();
                    readerCount--;
                    if (readerCount == 0) roomEmpty.release();
                    mutex.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Writer extends Thread {
        private final int id;
        Writer(int id) { this.id = id; }

        public void run() {
            try {
                for (int round = 1; round <= 3; round++) {
                    roomEmpty.acquire();
                    sharedValue++;
                    System.out.println("W" + id + " writes value " + sharedValue);
                    Thread.sleep(180);
                    roomEmpty.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[6];
        for (int i = 0; i < 4; i++) threads[i] = new Reader(i + 1);
        for (int i = 0; i < 2; i++) threads[4 + i] = new Writer(i + 1);
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        System.out.println("Final shared value: " + sharedValue);
    }
}