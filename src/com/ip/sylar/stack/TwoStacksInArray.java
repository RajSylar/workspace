package com.ip.sylar.stack;

public class TwoStacksInArray {
    private int[] arr;

    private int low;
    private int size;
    private int high;

    public TwoStacksInArray(int size) {
        arr = new int[size];
        low = -1;
        high = arr.length;
        this.size = size;
    }

    private void pushOne(int data) {
        if (low < high - 1) {
            low++;
            arr[low] = data;
        } else {
            System.out.println("OverFlowCondition");
        }
    }

    private void pushTwo(int data) {
        if (low < high - 1) {
            high--;
            arr[high] = data;
        } else {
            System.out.println("OverFlowCondition");
        }
    }

    private int popFromOne() {
        if (low < 0) {
            System.out.println("UnderFlow Condition");
            return -1;
        } else {
            int data = arr[low];
            arr[low] = 0;
            low--;
            return data;
        }
    }

    private int popFromTwo() {
        if (high >= size) {
            System.out.println("UnderFlow Condition");
            return -1;
        } else {
            int data = arr[high];
            high++;
            return data;
        }
    }

    public static void main(String[] args) {
        TwoStacksInArray twoStacksInArray = new TwoStacksInArray(3);
        System.out.println(twoStacksInArray.popFromOne());
        System.out.println(twoStacksInArray.popFromTwo());
        twoStacksInArray.pushOne(1);
        twoStacksInArray.pushOne(3);
        twoStacksInArray.pushOne(5);
        twoStacksInArray.pushOne(6);
        System.out.println(twoStacksInArray.popFromOne());
        twoStacksInArray.pushOne(8);
        System.out.println(twoStacksInArray.popFromOne());
        System.out.println(twoStacksInArray.popFromOne());
        System.out.println(twoStacksInArray.popFromOne());
        System.out.println(twoStacksInArray.popFromTwo());
        twoStacksInArray.pushTwo(11);
        twoStacksInArray.pushTwo(32);
        twoStacksInArray.pushTwo(33);
        twoStacksInArray.pushTwo(35);
        System.out.println(twoStacksInArray.popFromTwo());
        twoStacksInArray.pushTwo(37);
        System.out.println(twoStacksInArray.popFromTwo());
        System.out.println(twoStacksInArray.popFromTwo());
        System.out.println(twoStacksInArray.popFromTwo());


    }
}
