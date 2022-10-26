package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FrontierStrategy;

public class BreadthFirst<N> implements FrontierStrategy<N> {

    public static <N> BreadthFirst<N> getInstance() {
        return new BreadthFirst<>();
    }

    public void addToFrontier(final Deque<N> frontier, final N node) {
        frontier.addLast(node);
    }
}
