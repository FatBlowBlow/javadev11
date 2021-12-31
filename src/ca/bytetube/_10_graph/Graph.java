package ca.bytetube._10_graph;

import ca.bytetube._07_AVLTree.BinaryTree;

import java.util.Map;
import java.util.Set;

public abstract class Graph<V,E> {


    protected WeightManager<E> weightManager;
    public Graph(WeightManager<E> weightManager) {
        this.weightManager = weightManager;
    }

    public Graph() {}

    public abstract int verticesSize();

    public abstract int edgesSize();

    public abstract void addVertex(V v);

    public abstract void removeVertex(V v);

    public abstract void addEdge(V fromV, V toV);

    public abstract void addEdge(V fromV, V toV, E weight);

    public abstract void removeEdge(V fromV, V toV);

    public abstract void bfs(V begin);

    public abstract void dfs(V begin);

    public abstract void bfs(V begin, VertexVisitor<V> visitor);

    public abstract void dfs(V begin,VertexVisitor<V> visitor);

    public abstract Map<V, E> shortestPath(V begin);

    public interface WeightManager<E> {
        public int compare(E w1, E w2);
        public E add(E w1, E w2);
        public E zero();
    }

    public abstract Set<EdgeInfo<V,E>> mst();






    public static class EdgeInfo<V,E> {
        private V from;
        private V to;
        private E weight;


        public EdgeInfo(V from, V to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        public V getFrom() {
            return from;
        }

        public void setFrom(V from) {
            this.from = from;
        }

        public V getTo() {
            return to;
        }

        public void setTo(V to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "EdgeInfo{" +
                    "weight=" + weight +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }



    public interface VertexVisitor<V>{
        public boolean visit(V v);
    }
}
