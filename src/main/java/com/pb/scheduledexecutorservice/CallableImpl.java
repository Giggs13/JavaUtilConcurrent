package com.pb.scheduledexecutorservice;

import java.util.concurrent.Callable;

public class CallableImpl
        implements Callable<Process> {

    private final Process process;

    public CallableImpl(Process process) {
        this.process = process;
    }

    @Override
    public Process call()
            throws Exception {
        System.out.println("CallableImpl. Before running the process as a Thread.");
        new Thread(new RunnableImpl(process)).start();
        System.out.println("CallableImpl. After running the process as a Thread.");
        return process;
    }
}
