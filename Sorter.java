/**
 * @author Omar Habib ID:3742418
 * A Sorter class that find the largest element and swap it with the element at the end
 *of the unsorted portion of the array.
 */

public class Sorter <SomeType extends Comparable<SomeType>> {
    
    public void selectionSort(SomeType[] array, int objNum){

        for(int pass = 0; pass<objNum-1; pass++){
            int max = pass;
            for(int i=pass+1; i<objNum; i++){
                if(array[i].compareTo(array[max])<0){
                    max = i;
                }
            }
            SomeType temp = array[pass];
            array[pass]=array[max];
            array[max]= temp;
        }
    }

    public void mergeSort(SomeType[] a, int qty) {
        if (qty < 2 || qty > a.length) {
            return;
        }
        mergeSort(a, 0, qty - 1);
    }

    private void mergeSort(SomeType[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    public void merge(SomeType[] a, int from, int mid, int to) {
        int n = to - from + 1;
        Object[] b = new Object[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) <= 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        for (j = 0; j < n; j++) {
            a[from + j] = (SomeType) b[j];
        }
    }
}
