public class LeakyClass {
    static {
        System.out.println("LeakyClass loaded");
    }

    public static void hello() {
        Runtime.getRuntime().addShutdownHook(new Thread(new LeakyRunnable()));
    }

    public static void goodbye() {
    }
}
