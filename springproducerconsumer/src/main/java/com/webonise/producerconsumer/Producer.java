package com.webonise.producerconsumer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Producer implements Runnable {
    private List<Integer> itemsList;
    private final static int MAX_CAPACITY;

    static {
        MAX_CAPACITY = 5;//Only the producer requires the max size because if size is greate than max size producer will wait
    }


    public void setItemsList(List<Integer> itemsList) {
        this.itemsList = itemsList;
    }

    public void run() {
        //The run method will execute after start() is called
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(300);
                //We will call the produce function.
                //The argument is the increment count because producer will insert data in the arrayList
                produce(counter++);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (itemsList) {
            //If the size of array list is equal to the max value specified by us
            //then the producer cannot add any more items.Hence it has to wait
            while (itemsList.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + itemsList.size());
                itemsList.wait();//This will make the producer loose lock of synchronized block
            }

            itemsList.add(i);//This will add value to the arrayList
            System.out.println("Produced: " + i);
            itemsList.notify();//Now the notify will help the consumer to move from wait state to the executing state

        }
    }
}

