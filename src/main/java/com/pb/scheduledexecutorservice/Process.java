package com.pb.scheduledexecutorservice;

import java.util.concurrent.TimeUnit;

public class Process {

    private static final int MAX = 10;
    private int countOperations;
    private boolean done;

    public int getCountOperations() {
        return countOperations;
    }

    public boolean isDone() {
        return done;
    }

    public void doProcess() {
        System.out.println("Process. Before launch execution.");
        while (countOperations < MAX) {
            System.out.println("Seted -->   " + (++countOperations));
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        done = true;
        System.out.println("Process. Launching has done.");
    }
}
