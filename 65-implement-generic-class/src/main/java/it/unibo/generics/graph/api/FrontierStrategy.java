package it.unibo.generics.graph.api;

import java.util.Deque;

public interface FrontierStrategy<N> {
    void addToFrontier(Deque<N> frontier, N node);
}
