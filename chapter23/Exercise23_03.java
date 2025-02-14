package chapter23;

import java.util.Comparator;

public class Exercise23_03 {

    // First quickSort method using Comparable
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSortHelper(list, 0, list.length - 1);
    }

    // Helper method for quickSort (using Comparable)
    private static <E extends Comparable<E>> void quickSortHelper(E[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }

    // Partition method for quickSort (using Comparable)
    private static <E extends Comparable<E>> int partition(E[] list, int low, int high) {
        E pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list[j].compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    // Swap helper method
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    // Second quickSort method using Comparator
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSortHelperComparator(list, 0, list.length - 1, comparator);
    }

    // Helper method for quickSort (using Comparator)
    private static <E> void quickSortHelperComparator(E[] list, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partitionComparator(list, low, high, comparator);
            quickSortHelperComparator(list, low, pivotIndex - 1, comparator);
            quickSortHelperComparator(list, pivotIndex + 1, high, comparator);
        }
    }

    // Partition method for quickSort (using Comparator)
    private static <E> int partitionComparator(E[] list, int low, int high, Comparator<? super E> comparator) {
        E pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list[j], pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);  // Sort using Comparable
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                         new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                         new Circle(3), new Circle(14), new Circle(12)};
        quickSort(list1, new GeometricObjectComparator());  // Sort using Comparator
        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i] + " ");
        }
    }
}