/**
 * Sort.java   2018年3月9日 上午10:00:05 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;



public class Sort {

    static int a[] = {1, 2, 2, 2, 3, 4};

    public static void bubbleSort(int[] a) {
        int tmp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //bubbleSort(a);
        //        quickSort(a);
        //        for (int i : a) {
        //            System.out.print(i + " ");
        //        }
        //        int value = binarySearch(a, 2);
        //        System.out.println("\n" + value);
        //        System.out.println(search_first(a, 2));
        //        System.out.println(search_last(a, 2));
    }

    public static void quickSort(int[] a) {
        if (a.length > 0) {
            sort(a, 0, a.length - 1);
        }
    }

    public static void sort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            sort(a, low, middle - 1);
            sort(a, middle + 1, high);
        }
    }

    public static int getMiddle(int[] a, int low, int high) {
        int tmp = a[low];
        while (low < high) {
            while (low < high && a[high] >= tmp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= tmp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    public static int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        if (low > high || value < a[low] || value > a[high]) {
            return -1;
        }
        while (low <= high) {
            //middle = (low + high) / 2;// low或high太大会溢出
            middle = low + (high - low) / 2;
            if (value == a[middle]) {
                return middle;
            }
            if (value < a[middle]) {
                high = middle - 1;
                continue;
            }
            if (value > a[middle]) {
                low = middle + 1;
                continue;
            }
        }
        return -1;
    }

    public static int search_first(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        if (low > high || value < a[low] || value > a[high]) {
            return -1;
        }
        while (low < high) {
            middle = low + (high - low) / 2;
            if (a[middle] < value) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        if (a[low] == value) {
            return low;
        }
        return -1;
    }

    public static int search_last(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        if (low > high || value < a[low] || value > a[high]) {
            return -1;
        }
        while (low + 1 < high) { //两个或一个元素就不需要while循环了
            middle = low + (high - low) / 2;
            if (a[middle] > value) {
                high = middle - 1;
            } else {
                low = middle;
            }
        }
        if (a[high] == value) {
            return high;
        } else if (a[low] == value) {
            return low;
        }
        return -1;
    }

}
