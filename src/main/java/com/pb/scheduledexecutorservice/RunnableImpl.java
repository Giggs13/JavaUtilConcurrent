package com.pb.scheduledexecutorservice;

public class RunnableImpl
        implements Runnable {

    private final Process process;

    public RunnableImpl(Process process) {
        this.process = process;
    }

    @Override
    public void run() {
        System.out.println("RunnableImpl. Before launch the process.");
        process.doProcess();
        System.out.println("RunnableImpl. After launch the process.");
    }
}
