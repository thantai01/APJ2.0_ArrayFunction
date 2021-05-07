package com.codewithjava;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        int arrSize;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        arrSize = sc.nextInt();
        int[] array = arrayCreate(arrSize);
        displayArray(array);

        System.out.println("Let's choose an action which you want : ");
        System.out.println("1. Reverse your Array ");
        System.out.println("2. Find an items in array ");
        System.out.println("3. Find max value in array ");
        int choose = sc.nextInt();
        switch (choose){
            case 1: arrayReverse(array);break;
            case 2:
                System.out.print("Which one?: ");
                int item = sc.nextInt();
                arrayFindItem(array,item);break;
            case 3:arrayMax(array); break;


        }
    }

    private static int[] arrayCreate(int arrSize) {
        int[] array = new int[arrSize];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arrSize; ) {
            System.out.print("Insert item :");
            array[i] = sc.nextInt();
            System.out.println("Item " + array[i] + " has added to index " + i);
            i++;
        }
        return array;
    }

    private static void displayArray(int[] array) {
        System.out.println("Your array : " + Arrays.toString(array));

    }

    private static void arrayReverse(int[] array) {
        for (int i = 0; i< array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        System.out.println("New array "+Arrays.toString(array));
    }

    private static void arrayFindItem(int[] array, int item){
        boolean isItems = false;
        int i = 0;
        for (;i < array.length;i++) {
            if (item == array[i]) {
                isItems = true;
                break;
            }
        }
        if (isItems) {
            System.out.println("This item was found at Index " + i);
        } else System.out.println("Item not found");
    }

    private static void arrayMax(int[] array){
        int max = array[0];
        int index = 0;
        for (int i = 0;i<array.length;i++) {
            if(array[i]>max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("The largest value in the array is " + max +" at position " + index);
    }


}
