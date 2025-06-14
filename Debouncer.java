// This problem was asked by Facebook.

// Given a function f, and N return a debounced f of N milliseconds.

// That is, as long as the debounced f continues to be invoked, f itself will not be called for N milliseconds
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Debouncer {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Runnable task;
    private final long delay;
    private long lastExecutionTime;

    public Debouncer(long delay) {
        this.delay = delay;
    }

    public void debounce(Runnable f) {
        if (task != null) {
            // Cancel the previous task if it exists
            scheduler.shutdownNow();
        }

        task = () -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastExecutionTime >= delay) {
                f.run();
                lastExecutionTime = currentTime;
            }
        };

        // Schedule the task to run after the specified delay
        scheduler.schedule(task, delay, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        Debouncer debouncer = new Debouncer(1000); // 1000 milliseconds debounce time

        Runnable myFunction = () -> System.out.println("Function executed at: " + System.currentTimeMillis());

        // Simulating rapid calls to the debounced function
        for (int i = 0; i < 5; i++) {
            debouncer.debounce(myFunction);
            try {
                Thread.sleep(200); // Simulate a delay between calls
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Give some time for the last call to execute before shutting down
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        debouncer.shutdown();
    }
}
