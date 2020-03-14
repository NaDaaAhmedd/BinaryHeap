package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class Sort implements eg.edu.alexu.csd.filestructure.sort.ISort {
    Comparable[] arr;

    private void Swap(int i1, int i2) {
        Comparable temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    @Override
    public IHeap heapSort(ArrayList arrayList) {
        Heap h = new Heap();
        if (arrayList == null) {
            return h;
        }

        for (Object c : arrayList) {
            h.insert((Comparable) c);
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList.set(i, h.extract());
        }
        h.setHeapsize(arrayList.size());
        return h;
    }

    @Override
    public void sortSlow(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        //Selection sort
        arr = new Comparable[arrayList.size()];
        int ind = 0;
        for (Object c : arrayList) {
            arr[ind++] = (Comparable) c;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[imin].compareTo(arr[j]) > 0) {
                    imin = j;
                }

            }
            Swap(i, imin);
        }
        arrayList.clear();
        for (Comparable c : arr) {
            arrayList.add(c);
        }
    }

    @Override
    public void sortFast(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        arr = new Comparable[arrayList.size()];
        int ind = 0;
        for (Object c : arrayList) {
            arr[ind++] = (Comparable) c;
        }
        mergeSort(arr, 0, arr.length - 1);
        arrayList.clear();
        for (Comparable c : arr) {
            arrayList.add(c);
        }
    }

    void merge(Comparable arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        Comparable L[] = new Comparable[n1];
        Comparable R[] = new Comparable[n2];
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(Comparable arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /*private void QuickSort(Comparable arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);  // Before pi
            QuickSort(arr, pi + 1, high); // After pi
        }
    }

    private int partition(Comparable arr[], int low, int high) {
        // pivot (Element to be placed at right position)
        Comparable pivot = arr[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j].compareTo(pivot) < 0) {
                i++;    // increment index of smaller element
                Swap(i, j);
            }
        }
        Swap(i + 1, high);
        return (i + 1);
    }*/
}