package com.pb.scheduledexecutorservice;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Entry {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        System.out.println("STARTED.");
        Entry entry = new Entry();
        Process process = new Process();
        entry.run(process);
        System.out.println("FINISHED.");
    }

    public void run(Process process) {
        CallableImpl callableImpl = new CallableImpl(process);
        System.out.println("Entry. Before getting of object Future.");
        final ScheduledFuture<?> future = scheduler.schedule(callableImpl, 5, SECONDS);
        System.out.println("Entry. Object Future has gotten. Has done? --> " + future.isDone());
        try {
            Process aim = (Process) future.get();
            while (!aim.isDone()) {
                System.out.println("Entry. Within the main cycle. Has done? --> " + future.isDone());
                System.out.println("Geted -->   " + aim.getCountOperations());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }
        scheduler.shutdownNow();
        System.out.println("Entry. That's all. Has done? --> " + future.isDone());
    }
}
