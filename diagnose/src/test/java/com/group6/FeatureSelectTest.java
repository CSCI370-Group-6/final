package com.group6;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Random;

import org.junit.Test;

public class FeatureSelectTest {

    public static int[] featureSelect(int numOfFeatures) {
        Random rand = new Random();
        int[] randomColumns = new int[numOfFeatures];
        for (int i = 0; i < numOfFeatures; i++) {
            int randCol;
            boolean isUnique;
            do {
                randCol = rand.nextInt(12);
                isUnique = true;
                for (int j = 0; j < numOfFeatures; j++) {
                    if (randomColumns[j] == randCol) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            randomColumns[i] = randCol;
        }
        return randomColumns;
    }

    public static boolean isUnique(int[] randomColumns) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: randomColumns) {
            if (set.contains(i)) return false; 
            set.add(i); 
        }
        return true; 
    }

    @Test
    public void featureSelectionTest(){

        System.out.println("THE FOLLOWING SHOULD BE TRUE:");

        for (int i = 0; i < 100; i++) {
            int[] randomColumns = featureSelect(3); //collect random features indices (3 in this case)

            assertTrue(isUnique(randomColumns));
        }

        System.out.println("\nTHE FOLLOWING SHOULD BE FALSE:");

        
        int notRandom1[] = {1, 1, 3};
        int notRandom2[] = {1, 3, 3};
        int notRandom3[] = {1, 1};
        int notRandom4[] = {1, 1, 3, 5, 6};
        int notRandomArrays[][] = {notRandom1, notRandom2, notRandom3, notRandom4};
        for (int[] notRandomArray : notRandomArrays) {
            assertFalse(isUnique(notRandomArray));
        }

    }
    
}
