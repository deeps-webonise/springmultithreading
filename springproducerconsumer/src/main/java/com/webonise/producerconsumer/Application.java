package com.webonise.producerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application {
    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    @Autowired
    List<Integer> itemsList;

    void start() {

        producer.setItemsList(itemsList);
        consumer.setItemsList(itemsList);

        Thread tProducer = new Thread(producer, "com.webonise.Producer");
        Thread tConsumer = new Thread(consumer, "com.webonise.Consumer");
        tProducer.start();
        tConsumer.start();
    }
}
