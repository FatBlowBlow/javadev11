package ca.bytetube._10_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph<V,E> {

    protected WeightManager<E> weightManager;//增加成员属性

    public Graph() {}//无参

    public Graph(WeightManager<E> weightManager) {//单参
        this.weightManager = weightManager;
    }


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

    public abstract Set<EdgeInfo<V,E>> mst();

    public abstract Map<V, E> shortestPath(V begin);

    public abstract Map<V, PathInfo<V,E>> shortestPath02(V begin);

    public abstract Map<V, Map<V, PathInfo<V,E>>> shortestPath();//Floyd


    public interface VertexVisitor<V>{
        public boolean visit(V v);
    }


    public static class PathInfo<V,E> {
        protected E weight;
        protected List<EdgeInfo<V,E>> edgeInfos = new LinkedList<>();

        public PathInfo() { }

        public PathInfo(E weight) {
            this.weight = weight;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        public List<EdgeInfo<V, E>> getEdgeInfos() {
            return edgeInfos;
        }

        public void setEdgeInfos(List<EdgeInfo<V, E>> edgeInfos) {
            this.edgeInfos = edgeInfos;
        }

        @Override
        public String toString() {
            return "pathInfo{" +
                    "weight=" + weight +
                    ", edgeInfos=" + edgeInfos +
                    '}';
        }
    }

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
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }


    //管理权重. 设计成接口. 不同类型有不同比较规则
    public interface WeightManager<E> {
        public int compare(E w1, E w2);
        public E add(E w1, E w2);
        public E initial();
        //...增加需要的方法
    }

}
