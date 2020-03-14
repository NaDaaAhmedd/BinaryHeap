package eg.edu.alexu.csd.filestructure.sort;

public class Node implements INode {
    private Comparable value;
    private int index;
    private int heapsize;

    public void setIndex(int index) {
        this.index = index;
    }

    private Comparable[] arr;

    Node (Comparable[] arr, int heapsize){
        this.arr = arr;
        this.heapsize = heapsize;
    }
    @Override
    public INode getLeftChild() {
        int indl = index * 2;
        if (indl <= heapsize && indl > 0) {
            Node left = new Node(arr,heapsize);
            left.index = indl;
            left.setValue(arr[indl - 1]);
            return left;
        }
        return null;
    }

    @Override
    public INode getRightChild() {
        int indr = index * 2 + 1;
        if (indr <= heapsize && indr > 0) {
            Node right = new Node(arr,heapsize);
            right.index = indr;
            right.setValue(arr[indr - 1]);
            return right;
        }
        return null;
    }

    @Override
    public INode getParent() {
        int indp = index/2;
        if (indp <= heapsize && indp > 0) {
            Node parent = new Node(arr,heapsize);
            parent.index = indp;
            parent.setValue(arr[indp - 1]);
            return parent;
        }
        return null;
    }

    @Override
    public Comparable getValue() {
        return value;
    }

    @Override
    public void setValue(Comparable value) {
        this.value = value;
    }
}
