package com.webonise.producerconsumer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Consumer implements Runnable {
    private List<Integer> itemsList;

    public void setItemsList(List<Integer> itemsList) {
        this.itemsList = itemsList;
    }

    public void run() {
        //The run method will execute after start() is called
        while (true) {
            try {
                Thread.sleep(1000);
                //We will call the consume function
                consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        //This will check if queue is empty ,if empty then it will wait for the producer to add items

        synchronized (itemsList) {
            while (itemsList.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + itemsList.size());
                itemsList.wait();
            }
            //if not empty then remove the element and let producer add an element by calling notify
            int i = (Integer) itemsList.remove(0);
            System.out.println("Consumed: " + i);
            itemsList.notify();
        }
    }
}