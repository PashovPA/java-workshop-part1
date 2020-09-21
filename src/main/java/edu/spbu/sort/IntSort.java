package edu.spbu.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemaliev on 07/09/15.
 * Changed by pashovpavel on 21/09/20.
 */
public class IntSort {

//  public static void sort (int array[]) {
//    Arrays.sort(array);
//  }

  static int partition(int[] array, int begin, int end) {
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
      if (array[i] < array[pivot]) {
        int temp = array[counter];
        array[counter] = array[i];
        array[i] = temp;
        counter++;
      }
    }
    int temp = array[pivot];
    array[pivot] = array[counter];
    array[counter] = temp;

    return counter;
  }

  public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot-1);
    quickSort(array, pivot+1, end);
  }

  public static void sort (List<Integer> list) {
    Collections.sort(list);
  }
}
