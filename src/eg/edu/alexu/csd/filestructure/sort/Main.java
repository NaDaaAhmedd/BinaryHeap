package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        IHeap<Integer> heap = new Heap();
        heap.insert(1);
        heap.insert(5);
        heap.insert(200);
        heap.insert(170);
        heap.insert(10);
        heap.insert(40);

        INode n = heap.getRoot();
        System.out.println("   " + n.getValue() + "   ");
        System.out.println(n.getLeftChild().getValue() + "    " + n.getRightChild().getValue());
        System.out.println(n.getLeftChild().getLeftChild().getValue() + " "
                + n.getLeftChild().getRightChild().getValue()
                + "   " + n.getRightChild().getLeftChild().getValue());

        System.out.println();

        System.out.println(heap.extract());
        System.out.println("Heap Size : " + heap.size());
        System.out.println(heap.extract());
        System.out.println("Heap Size : " + heap.size());
        System.out.println();

        Heap heap1 =  new Heap();
        ArrayList<Comparable> a = new ArrayList<>();
        a.add(15);
        a.add(10);
        a.add(20);
        a.add(18);
        a.add(4);
        a.add(8);
        a.add(96);
        heap1.build(a);
        INode n1 = heap1.getRoot();
        System.out.println("    " + n1.getValue() + "   ");
        System.out.println(" " + n1.getLeftChild().getValue() + "    " + n1.getRightChild().getValue());
        System.out.println(n1.getLeftChild().getLeftChild().getValue() + " "
                + n1.getLeftChild().getRightChild().getValue()
                + "  " + n1.getRightChild().getLeftChild().getValue() + " "
                + n1.getRightChild().getRightChild().getValue());

        System.out.println();

        ArrayList<Comparable> a1 = new ArrayList<>();
        a1.add(6);
        a1.add(69);
        a1.add(3);
        a1.add(8);
        a1.add(33);
        a1.add(9);
        a1.add(16);
        a1.add(0);

        System.out.println("Array befor sorting : ");
        for(Comparable c : a1){
            System.out.print(c + " ");
        }

        ISort s = new Sort();
        IHeap h = s.heapSort(a1);

        System.out.println();
        System.out.println("Array after sorting : ");
        for(Comparable c : a1){
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Size of the used heap : " + h.size());


    }
}
