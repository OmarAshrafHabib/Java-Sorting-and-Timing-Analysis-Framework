import java.util.Random;

public class MergeSortTest
{
  public static void main(String args[])
  {
    int[] a = new int[10];
    Random generator = new Random();

    for (int i=0; i < a.length; i++)
      a[i] = generator.nextInt(50);

    System.out.println("\nUnsorted array: " 
                     + arrayString(a));

    mergeSort(a);
    
    System.out.println("\nSorted array:   "
                     + arrayString(a) + "\n");
  }

  //===============================================
  /**
     Convenience method for the recursive mergeSort
  */
  public static void mergeSort(int[] a)
  {   mergeSort(a, 0, a.length - 1);
  }
  
  //===============================================
  /**
     Sorts a range within an array with merge sort
     @param a The array to be sorted
     @param from The first index of the range
     @param to The last index of the range
  */
  private static void mergeSort(int[] a, int from, int to)
  {  if (from == to) return;

     int mid = (from + to) / 2;

     mergeSort(a, from, mid);
     mergeSort(a, mid + 1, to);
     merge(a, from, mid, to);
  }

  //===============================================
  /**
     Merges two adjacent subranges of an array
     @param a The array with entries to be merged
     @param from Index of first element of the first range
     @param mid Index of last element of the first range
     @param to Index of last element of the second range
   */
  public static void merge(int[] a, int from, int mid, int to)
  {  
    int n = to - from + 1;   // size of the range to be merged

    // merge both halves into a temporary array b 
    int[] b = new int[n];

    int i1 = from;     // next element to consider
                          //   in the first range
    int i2 = mid + 1;  // next element to consider 
                          //    in the second range
    int j = 0;         // next open position in b

    // as long as neither i1 nor i2 past the end, move
    // the smaller element into b
    while (i1 <= mid && i2 <= to)
    { if (a[i1] <= a[i2])
      { b[j] = a[i1];
        i1++;
      }
      else
      { b[j] = a[i2];
        i2++;
      }
      j++;
    }

    // Copy any remaining entries of the first half
    while (i1 <= mid)
    { b[j] = a[i1];
      i1++;
      j++;
    }
      
    // Copy any remaining entries of the second half
    while (i2 <= to)
    { b[j] = a[i2];
      i2++;
      j++;
    }

    // Copy back from the temporary array
    for (j = 0; j < n; j++)
      a[from + j] = b[j];
  }


  //===============================================
  /** Formats array contents for display purposes
  */
  public static String arrayString(int[] a)
  {
    String r = "{";
    for (int i=0; i < a.length-1; i++)
      r = r + a[i] + ", ";
    return r + a[a.length-1] + "}";   
  }

} // MergeSortTest

