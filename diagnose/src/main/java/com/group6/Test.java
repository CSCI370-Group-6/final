package com.group6;

import java.io.IOException;
import java.util.Scanner;

public class Test {

 
    public static void main(String[] args) throws IOException {
    

    //random forest testing  ----------------------------------------------

        RandomForest forest = new RandomForest(100);
        //forest.print(); //prints the tree objects

        // Scanner scanner = new Scanner(System.in);
        // String[] inputs = new String[]{
        //     "your age", 
        //     "your gender", 
        //     "your hours spent on social media", 
        //     "your favorite social media platform", 
        //     "your interest", 
        //     "your location", 
        //     "your demographic (Urban, Sub_Urban, Rural)", 
        //     "your profession", 
        //     "your monthly income", 
        //     "if you are in debt", 
        //     "if you are a homeowner",
        //     "if you own a car"
        // };
        // String[] userInputs = new String[inputs.length];

        // for (int i = 0; i < inputs.length; i++) {
        //     System.out.println("Enter your " + inputs[i]);
        //     userInputs[i] = scanner.nextLine();
        // }
        // String userInputString = userInputs[0] + "," + userInputs[1] + "," + userInputs[2] + "," + userInputs[3] + "," + userInputs[4] + "," + userInputs[5] + "," + userInputs[6] + "," + userInputs[7] + "," + userInputs[8] + "," + userInputs[9] + "," + userInputs[10] + ",True";
        // scanner.close();

        String userInputString = args[0];
        // System.out.println(userInputString);


        


        // String input = "28,male,4,Instagram,Sports,Australia,Sub_Urban,Marketer Manager,10223,True,False,True"; 
        DataContainer userInput = new DataContainer(userInputString); 

        //NOTE AT THIS TIME I AM JUST COLLECTING THE ARRAY OF PREDICTIONS SO THAT WE CAN SEE HOW IT CHANGES WITH DIFFERENT INPUTS
        int[] prediction = forest.aggregate(userInput);
        int label0 = 0, label1 = 0;
        
        // System.out.println("Prediction array is: ");
        // System.out.print("[");
        for (int i = 0; i < prediction.length - 1; i++) {
            // System.out.print(prediction[i] + ", ");
            if (prediction[i] == 1) label1++;
            else label0++;
        }
        // System.out.println(prediction[99] + "]");
        int confidence = Math.max(label0, label1); //confidence level (0-1
        if (label0 > label1) System.out.println("NO ADDICTION");
        else System.out.println("YES ADDICTION");
        System.out.println("Confidence level: " + confidence + "%");

 
    //tree testing  ---------------------------------------------------

        // DecisionTree root = new DecisionTree();
        // root.buildTree(4);
        
        // System.out.println(root);
        // System.out.println(root.getLeft());
        // System.out.println(root.getRight());
        // root.getLeft().print();
        // root.getRight().print();
        // root.print();

    //decision node test cases (Tree class will handle) --------------------------------------

        // DataContainer dataset = new DataContainer();
        // DecisionNode root = new DecisionNode(dataset);
        // //root.print();
        // System.out.println(root.getLabel(0));
        // System.out.println(root.getLabel(1));
        // System.out.println(root.getLabel(2));
        // System.out.println(root.getLabel(3));
        // System.out.println(root.getLabel(4));

        // // just testing left and right w/ random data, SPLITTINGCRITERIA() will be the one using this
        // DataContainer dataLeft = new DataContainer(10, 13);
        // DataContainer dataRight = new DataContainer(5, 13);
        
        // DecisionNode nodeLeft = new DecisionNode(dataLeft);
        // DecisionNode nodeRight = new DecisionNode(dataRight);

        // root.setLeft(nodeLeft);
        // root.setRight(nodeRight);


        // System.out.println("I am roots left child----");
        // root.getLeft().getData().print();
        // System.out.println("\nI am roots right child----");
        // root.getRight().getData().print();

        // System.out.println(root.isLeaf());
        // System.out.println(nodeLeft.isLeaf());
        // System.out.println(nodeRight.isLeaf());

        // //Testing out label counts, will be used to find impurity/IG/giniIndex
        // DataContainer bootstrappedData = new DataContainer(10, 5);
        // bootstrappedData.print();


    //data container label tests ----------------------------

        // DataContainer bootstrappedData = new DataContainer(5, 5);
        // bootstrappedData.print();
        // System.out.println("\nLabel 0 = " + bootstrappedData.getLabelCount(0));
        // System.out.println("Label 1 = " + bootstrappedData.getLabelCount(1));
        // System.out.println("data class is pure = " + bootstrappedData.isPure());
        
        /*
            40 male 7 YouTube 1 
            58 non-binary 8 YouTube 1 
            36 female 9 Instagram 1 
            47 female 8 YouTube 1 
            18 male 6 YouTube 1 

            Label 0 = 0
            Label 1 = 5
            data class is pure = true
        */


    //dataset test case ---------------------------------------------

        // DataContainer dataset = new DataContainer();
        // System.out.println(dataset.getValue(0, 0));
        // System.out.println(dataset.getValue(999, 11));
        // dataset.print();


    //bootstrap test case --------------------------------------------

        // DataContainer bootstrappedData = new DataContainer(1000, 13);
        // bootstrappedData.print();           


    //data imputation on user input test cases ------------------------------------

        //no inputs removed
            // String input = "28,male,2,Instagram,Sports,Australia,Sub_Urban,Marketer Manager,10223,True,False,True"; 
            // DataContainer userInput = new DataContainer(input); 
            // userInput.print();     

        //end removed
            // String input = "28,male,2,Instagram,Sports,Australia,Sub_Urban,Marketer Manager,10223,True,False,"; 
            // DataContainer userInput = new DataContainer(input); //true was inputted correctly
            // userInput.print();

        //first input removed
            // String input = ",male,2,Instagram,Sports,Australia,Sub_Urban,Marketer Manager,10223,True,False,True"; 
            // DataContainer userInput = new DataContainer(input); //43 was inputted correctly
            // userInput.print();

        //middle input "country" removed
            // String input = "28,male,2,Instagram,Sports,,Sub_Urban,Marketer Manager,10223,True,False,True"; 
            // DataContainer userInput = new DataContainer(input); 
            // userInput.print();

        //beginning & end removed
            // String input = ",male,2,Instagram,Sports,Australia,Sub_Urban,Marketer Manager,10223,True,False,"; 
            // DataContainer userInput = new DataContainer(input); 
            // userInput.print();

        //mixed removed
            // String input = ",male,2,,Sports,,Sub_Urban,,10223,True,False,"; 
            // DataContainer userInput = new DataContainer(input); 
            // userInput.print();

    }
}
