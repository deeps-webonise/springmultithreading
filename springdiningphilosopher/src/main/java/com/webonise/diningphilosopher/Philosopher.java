package com.webonise.diningphilosopher;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Scope("prototype")
public class Philosopher implements Runnable {

    private Lock leftFork = new ReentrantLock();
    private Lock rightFork = new ReentrantLock();
    private String name;


    public void setValues(Lock leftFork, Lock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;

    }


    public void run() {
        while (true) {
            think(name);
            eat(leftFork, rightFork, name);
        }
    }

    private void eat(Lock leftFork, Lock rightFork, String name) {
        //We will lock left and right fork when a philospher is eating
        leftFork.lock();
        rightFork.lock();

        System.out.println(name + " eating");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // we will unlock the left and right fork when a philospher finishes eating
            leftFork.unlock();
            rightFork.unlock();
            System.out.println(name + " done eating");
        }
    }

    private void think(String name) {
        System.out.println(name + " thinking");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
