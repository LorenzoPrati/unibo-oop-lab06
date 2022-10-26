package it.unibo.generics.graph.impl;

public class NodeImpl<N> {

    private final N value;
    private NodeImpl<N> father;

    public NodeImpl(final N value) {
        this(value, null);
    }

    public NodeImpl(final N value, final NodeImpl<N> father) {
        this.value = value;
        this.father = father;
    }

    public N getValue() {
        return this.value;
    }

    public NodeImpl<N> getFather() {
        return this.father;
    }
}
