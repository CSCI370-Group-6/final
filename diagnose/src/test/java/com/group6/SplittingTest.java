package com.group6;

import org.junit.Test;
import static org.junit.Assert.*;

public class SplittingTest {
    @Test
    public void SplitTest() {
        DataContainer data = new DataContainer(); 
        split(data, 0);
    }

    public void split(DataContainer data, int index) {
        if (index == 12) return; 
        String[] thresholds = {"60", "female", "8", "Instagram", "Sports", "United States", "Urban", "Student", "10564", "False", "True", "False"};

        DataContainer leftData = data.split(true, index, thresholds[index]);
        DataContainer rightData = data.split(false, index, thresholds[index]);

        System.out.println("\n\n\n\n\nstart--------------------------------------------------------------------------------------------");
        System.out.println("LEFT CHILD, I SPLIT ON " + thresholds[index] + " which is at index of " + index);
        leftData.print();
        System.out.println();
        System.out.println("RIGHT CHILD, I SPLIT ON NOT OF " + thresholds[index] + " which is at index of " + index);
        rightData.print();
        System.out.println("end--------------------------------------------------------------------------------------------");

        if (index <= 4 ) {
            index++;
            split(leftData, index);      
        }
        else {
            index++;
            split(rightData, index);        
        }

    }
}
