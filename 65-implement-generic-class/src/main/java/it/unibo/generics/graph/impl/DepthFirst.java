package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FrontierStrategy;

public class DepthFirst<N> implements FrontierStrategy<N> {

    public static <N> DepthFirst<N> getInstance() {
        return new DepthFirst<>();
    }

    public void addToFrontier(final Deque<N> frontier, final N node) {
        frontier.addFirst(node);
    }
}
