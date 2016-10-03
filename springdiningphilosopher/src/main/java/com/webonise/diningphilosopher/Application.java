package com.webonise.diningphilosopher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class Application {
    @Autowired
    Philosopher philosopher1;
    @Autowired
    Philosopher philosopher2;
    @Autowired
    Philosopher philosopher3;
    @Autowired
    Philosopher philosopher4;
    @Autowired
    Philosopher philosopher5;

    void start() {
        Lock forks[] = new ReentrantLock[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }

        philosopher1.setValues(forks[4], forks[0], "first");
        philosopher2.setValues(forks[0], forks[1], "second");
        philosopher3.setValues(forks[1], forks[2], "third");
        philosopher4.setValues(forks[2], forks[3], "fourth");
        philosopher5.setValues(forks[3], forks[4], "fifth");

        //This will create 5 Threads one for each philosopher
        Thread p1 = new Thread(philosopher1);
        Thread p2 = new Thread(philosopher2);
        Thread p3 = new Thread(philosopher3);
        Thread p4 = new Thread(philosopher4);
        Thread p5 = new Thread(philosopher5);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }
}
