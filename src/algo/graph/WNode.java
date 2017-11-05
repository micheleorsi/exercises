package algo.graph;

public class WNode<T> implements IGNode<T> {

    private final T val;

    public WNode(T val) {

        this.val = val;
    }

    @Override
    public T getValue() {
        return null;
    }
}
