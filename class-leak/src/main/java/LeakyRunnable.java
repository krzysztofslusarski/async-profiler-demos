public class LeakyRunnable implements Runnable {
    @Override
    public void run() {
        LeakyClass.goodbye();
    }
}
