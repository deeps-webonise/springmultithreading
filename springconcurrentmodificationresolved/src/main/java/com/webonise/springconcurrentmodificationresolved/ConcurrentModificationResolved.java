package com.webonise.springconcurrentmodificationresolved;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConcurrentModificationResolved {
    public static void main(String args[]) {
        ApplicationContext context = SpringApplication.run(ConcurrentModificationResolved.class, args);
//        DataFetchAndRetrieve dataFetchAndRetrieve = new DataFetchAndRetrieve();
        DataFetchAndRetrieve dataFetchAndRetrieve = context.getBean(DataFetchAndRetrieve.class);
        dataFetchAndRetrieve.addData();
        dataFetchAndRetrieve.printDataAndRemove();
        System.out.println();
        dataFetchAndRetrieve.printData();
    }
}
