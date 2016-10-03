package com.webonise.springconcurrentmodificationresolved;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataFetchAndRetrieve {
    @Autowired
    private List<String> myList;


    void addData() {
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("fourth");
        myList.add("fifth");
    }

    void printDataAndRemove() {
        for (String string : myList) {
            System.out.println(string);
            myList.remove("third");
            //Used CopyOnWriteArrayList to resolve the ConcurrentModificationException
            //It will create a copy of the arraylist and iterate over that array
            //Any modification which takes place on the original array is reflected to the copy array only after it has finished iterating
            //So it will print all all values including the deleted value because its a copy
        }
    }


    void printData() {
        //Now when we print the ArrayList again we find that the element is deleted and not printed.
        for (String string : myList) {
            System.out.println(string);
        }
    }
}
