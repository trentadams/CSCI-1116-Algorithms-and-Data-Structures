package chapter20;

import java.util.Comparator;

public class Exercise20_21 {
  
  // Generic selectionSort method using a Comparator
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
    for (int i = 0; i < list.length - 1; i++) {
      int indexOfMin = i; // Assume the min element is at index i
      
      // Find the index of the smallest element in the unsorted part of the array
      for (int j = i + 1; j < list.length; j++) {
        if (comparator.compare(list[j], list[indexOfMin]) < 0) {
          indexOfMin = j; // Update the index of the min element
        }
      }
      
      // Swap the found minimum element with the element at index i
      E temp = list[i];
      list[i] = list[indexOfMin];
      list[indexOfMin] = temp;
    }
  }

  public static void main(String[] args) {
    // Example with GeometricObject array
    GeometricObject[] list = {
      new Circle(5), new Rectangle(4, 5),
      new Circle(5.5), new Rectangle(2.4, 5),
      new Circle(0.5), new Rectangle(4, 65),
      new Circle(4.5), new Rectangle(4.4, 1),
      new Circle(6.5), new Rectangle(4, 5)
    };

    // Sorting the list of geometric objects using GeometricObjectComparator
    selectionSort(list, new GeometricObjectComparator());
    
    // Display sorted list
    for (GeometricObject geoObj : list) {
      System.out.println(geoObj.getArea());
    }

    // Example with Circle array
    Circle[] list1 = {
      new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1),
      new Circle(2), new Circle(3), new Circle(14), new Circle(12)
    };

    // Sorting the list of circles using GeometricObjectComparator
    selectionSort(list1, new GeometricObjectComparator());

    // Display sorted list of circles by area
    for (Circle circle : list1) {
      System.out.println(circle.getArea() + " ");
    }
  }
}