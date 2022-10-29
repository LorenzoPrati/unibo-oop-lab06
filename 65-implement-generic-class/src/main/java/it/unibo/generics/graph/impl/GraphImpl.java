package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unibo.generics.graph.api.FrontierStrategy;
import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> edges = new LinkedHashMap<>();
    private final FrontierStrategy<pathNode<N>> strat;

    public GraphImpl() {
        this(BreadthFirst.getInstance());
    }

    public GraphImpl(final FrontierStrategy<pathNode<N>> strategy) {
        this.strat = Objects.requireNonNull(strategy);
    }

    /*
     * Utility class implementing a step of the path,
     * with field value and the reference to the previous node in the
     * path (father)
     */
    static class pathNode<N> {

        private final N value;
        private pathNode<N> father;

        public pathNode(final N value) {
            this(value, null);
        }

        public pathNode(final N value, final pathNode<N> father) {
            this.value = value;
            this.father = father;
        }

        public N getValue() {
            return this.value;
        }

        public pathNode<N> getFather() {
            return this.father;
        }
    }

    public List<N> getPath(final N source, final N target) {
        if (isPresent(source) && isPresent(target)) {
            return getPathExec(source, target);
        } else {
            return Collections.emptyList();
        }
    }

    public List<N> getPathExec(final N source, final N target) {
        final List<N> visited = new LinkedList<>();
        /*
         * the frontier act as queue or stack depending on strategy
         */
        final Deque<pathNode<N>> frontier = new LinkedList<>();
        frontier.add(new pathNode<N>(source));
        while (!frontier.isEmpty() && visited.size() < this.getNodesCount()) {
            final pathNode<N> curr = frontier.removeFirst();
            if (curr.getValue().equals(target)) {
                return this.getPathFromNode(curr);
            } else {
                visited.add(curr.getValue());
                for (final N adj : this.linkedNodes(curr.getValue())) {
                    pathNode<N> adjNode = new pathNode<N>(adj, curr);
                    if (!visited.contains(adjNode)) {
                        strat.addToFrontier(frontier, adjNode);
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    private List<N> getPathFromNode(pathNode<N> node) {
        final List<N> path = new LinkedList<>();
        do {
            path.add(0, node.getValue());
            node = node.getFather();
        } while (node != null);
        return path;
    }

    private int getNodesCount() {
        return this.edges.keySet().size();
    }

    private boolean isPresent(final N node) {
        if (!this.edges.containsKey(node)) {
            throw new IllegalArgumentException("Node " + node + " does not exist");
        }
        return true;
    }

    public void addEdge(final N source, final N target) {
        if (this.isPresent(source) && this.isPresent(target)) {
            this.edges.get(source).add(target);
        }
    }

    public void addNode(final N node) {
        this.edges.put(node, new HashSet<>());
    }

    public Set<N> linkedNodes(final N node) {
        return this.edges.get(node);
    }

    public Set<N> nodeSet() {
        return this.edges.keySet();
    }
}
