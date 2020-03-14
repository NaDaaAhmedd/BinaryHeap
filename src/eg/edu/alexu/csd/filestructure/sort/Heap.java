package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Collection;

public class Heap implements IHeap {
    private Comparable[] arr = new Comparable[10000000];
    private int heapsize = 0;
    private int CurrentInd;

    private void Swap(int i1, int i2) {
        Comparable temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public void setHeapsize (int heapsize){
        this.heapsize = heapsize;
    }

    @Override
    public INode getRoot() {
        if (heapsize != 0) {
            Node root = new Node(arr, heapsize);
            root.setIndex(1);
            root.setValue(arr[0]);
            return root;
        }
        return null;
    }

    @Override
    public int size() {
        return heapsize;
    }

    @Override
    public void heapify(INode iNode) {
        if (iNode == null) {
            return;
        }
        int left = 2 * CurrentInd - 1;
        int right = 2 * CurrentInd;
        int largest = CurrentInd - 1;

        if (left < heapsize && arr[left].compareTo(arr[largest]) > 0)
            largest = left;
        if (right < heapsize && arr[right].compareTo(arr[largest]) > 0)
            largest = right;
        if (largest != CurrentInd - 1) {
            Swap(CurrentInd - 1, largest);
            Node n = new Node(arr, heapsize);
            n.setIndex(largest + 1);
            CurrentInd = largest + 1;
            n.setValue(arr[largest]);
            heapify(n);
        }

    }

    @Override
    public Comparable extract() {
        if (heapsize == 0) {
            return null;
        }
        Swap(0, heapsize - 1);
        heapsize--;
        for (int i = 1; i < heapsize;) { //index starts from 1 (heap)
            if (2 * i > heapsize)
                break;
            else if (2 * i + 1 > heapsize) {
                if (arr[2 * i - 1].compareTo(arr[i - 1]) > 0) {
                    Swap(2 * i - 1, i - 1);
                }
                break;
            }
             if (arr[2 * i - 1].compareTo(arr[2 * i]) >= 0) { //left > right
                if (arr[2 * i - 1].compareTo(arr[i - 1]) > 0) {
                    Swap(2 * i - 1, i - 1);
                    i = 2 * i;
                }
                else {
                    break;
                }
            } else {
                if (arr[2 * i].compareTo(arr[i - 1]) >= 0) {
                    Swap(2 * i, i - 1);
                    i = 2 * i + 1;
                }
                else {
                    break;
                }
            }

        }
        return arr[heapsize];
    }

    @Override
    public void insert(Comparable comparable) {
        if (comparable == null){
            return;
        }
        arr[heapsize] = comparable;
        heapsize++;
        for (int i = heapsize; i > 1; i /= 2) {
            if (arr[(i - 1)].compareTo(arr[(i / 2) - 1]) > 0) {
                Swap(i - 1, (i / 2) - 1);
            } else
                break;
        }
    }

    @Override
    public void build(Collection collection) {
        if (collection == null){
            return;
        }
        ArrayList<Comparable> temp = new ArrayList<>(collection);
        int k = 0;
        for (Comparable c : temp){
            arr[k] = c;
            k++;
        }
        heapsize = collection.size();
        for (int i = arr.length - 1; i >= 0; i--) {
            Node n = new Node(arr, heapsize);
            n.setIndex(i + 1);
            CurrentInd = i + 1;
            n.setValue(arr[i]);
            heapify(n);
        }

    }
}