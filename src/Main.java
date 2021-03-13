
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("exception");
//                System.out.println("thread name - " + Thread.currentThread().getName());
//                System.out.println("thread priority - " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("custom name");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread name - " + t.getName() + " error - " + e.getMessage());
            }
        });
        System.out.println("in thread - " + Thread.currentThread().getName());
        thread.start();
        System.out.println("thread after start - " + Thread.currentThread().getName());
    }
}
