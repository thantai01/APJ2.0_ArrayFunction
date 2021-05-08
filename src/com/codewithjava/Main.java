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
        System.out.println("3. Find largest item in array ");
        System.out.println("4. Find and delete item in array ");
        System.out.println("5. Insert new item to array ");


        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                arrayReverse(array);
                break;
            case 2:
                System.out.print("Which one?: ");
                int item = sc.nextInt();
                arrayFindItem(array, item);
                break;
            case 3:
                arrayMax(array);
                break;
            case 4:
                System.out.print("Which you want to kill?: ");
                int item2 = sc.nextInt();
                int[] newArray = deleteItem(array,indexDeleteItem(array,item2));
                System.out.println(Arrays.toString(newArray));
                break;
            case 5:
                System.out.println("New item :? ");
                int item3 = sc.nextInt();
                System.out.println("Add to where?? ");
                int index3 = sc.nextInt();
                int[] newArray2 = insertItem(array,item3,index3);
                System.out.println("Your new array: "+Arrays.toString(newArray2));

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
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("New array " + Arrays.toString(array));
    }

    private static void arrayFindItem(int[] array, int item) {
        boolean isItems = false;
        int i = 0;
        for (; i < array.length; i++) {
            if (item == array[i]) {
                isItems = true;
                break;
            }
        }
        if (isItems) {
            System.out.println("This item was found at Index " + i);
        } else System.out.println("Item not found");
    }

    private static void arrayMax(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("The largest value in the array is " + max + " at position " + index);
    }

    static int indexDeleteItem(int[] array, int item2) {
        int index = -1;
        for (int i = 0; i <array.length;i++) {
            if(item2 == array[i]) {
                index = i;
            }
        }
        return index;
    }
    static int[] deleteItem(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int i =0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index +1; i< array.length; i++) {
            newArray[i-1] = array[i];
        }
        return newArray;
    }

    static int[] insertItem(int[] array, int item3,int index3) {
        int[] newArray = new int[array.length + 1];
        for(int i = 0;i < index3; i++) {
            newArray[i] = array[i];
            newArray[index3] = item3;
        }
        for (int i = index3+1; i< newArray.length;i++) {
            newArray[i] = array[i-1];
        }

        return newArray;
    }





}
