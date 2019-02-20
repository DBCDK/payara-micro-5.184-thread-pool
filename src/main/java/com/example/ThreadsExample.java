package com.example;

import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.concurrent.ManagedExecutorService;

@Singleton
@Startup
public class ThreadsExample {

    @Resource(type = ManagedExecutorService.class)
    ExecutorService mes;

    @PostConstruct
    public void init() {
        System.out.println("In PostConstruct");
        for (int i = 0 ; i < 10 ; i++) {
            String task = String.valueOf(i);
            mes.submit(() -> {
                String thr = Thread.currentThread().toString();
                for (int c = 0 ; c < 10 ; c++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadsExample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("thread=" + thr + "; task=" + task + "; counter=" + c);
                }
            });
            System.out.println("Submitted task=" + task);
        }
    }
}
