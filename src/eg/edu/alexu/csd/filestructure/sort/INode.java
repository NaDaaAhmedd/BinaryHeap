//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package eg.edu.alexu.csd.filestructure.sort;

public interface INode<T extends Comparable<T>> {
    INode<T> getLeftChild();

    INode<T> getRightChild();

    INode<T> getParent();

    T getValue();

    void setValue(T var1);
}
