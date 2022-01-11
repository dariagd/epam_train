package multithreading.thread;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable myRunnable = () -> System.out.println(Thread.currentThread().getName());
        new Thread(myRunnable).start();
    }
}
