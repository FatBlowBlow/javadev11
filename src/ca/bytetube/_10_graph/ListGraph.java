package ca.bytetube._10_graph;

import java.util.*;

public class ListGraph<V,E> implements Graph<V,E> {
    private Map<V, Vertex<V,E>> vertices = new HashMap<>();//点集
    private Set<Edge<V,E>> edges = new HashSet<>();//边集

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }


    @Override
    public void addEdge(V fromV, V toV) {
        addEdge(fromV, toV, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        //1. 先判断from， to顶点是否存在
        Vertex<V,E> fromVertex = vertices.get(from);
        if (fromVertex == null){
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V,E> toVertex = vertices.get(to);
        if (toVertex == null){
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        //能来到这， 说明一定可以保证有起点和终点，
        //接下来需要确定这两个点之间之前是否存在边
        //如果不存在，新建一个边。 如果存在，更新weight
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;
        if (fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVeVertex = vertices.get(from);
        if (fromVeVertex == null) return;
        Vertex<V, E> toVeVertex = vertices.get(from);
        if (toVeVertex == null) return;

        //能来到这，说明起点和终点都存在，但是不代表两个顶点之间存在连线
        Edge<V, E> edge = new Edge<>(fromVeVertex, toVeVertex);
        if (fromVeVertex.outEdges.remove(edge)){
            toVeVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);//点集中先删除点
        if (vertex == null) return;

//        //如果需要对容器一边遍历一边修改，一定会失败，这种操作会破坏容器的原子性。绝对不能这么写！
//
//        vertex.outEdges.forEach((Edge<V, E> edge) -> {
//            removeEdge(edge.from.value, edge.to.value);
//        });
//
//        vertex.inEdges.forEach((Edge<V, E> edge) -> {
//            removeEdge(edge.from.value, edge.to.value);
//        });

        //如果需要对容器一边遍历一边修改，用迭代器
        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ){
            Edge<V,E> edge = iterator.next();
            //通过这根线作为线索，找到这根线的终点，把终点的edge.to的inEdges删除掉这根线
            edge.to.inEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ){
            Edge<V,E> edge = iterator.next();

            edge.from.outEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }
    }


    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    public void print() {
        System.out.println("[vertex]-------------------");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("out-----------");
            System.out.println(vertex.outEdges);
            System.out.println("in-----------");
            System.out.println(vertex.inEdges);
        });

        System.out.println("[edge]-------------------");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }

    private static class Vertex<V,E>{//点
        V value;
        Set<Edge<V,E>>  inEdges = new HashSet<>();
        Set<Edge<V,E>>  outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(value, ((Vertex<V,E>)o).value);
        }

        @Override
        public int hashCode() {
            return value == null? 0 : value.hashCode();

        }

        @Override
        public String toString() {
            return value == null? "null" : value.toString();
        }
    }

    private static class Edge<V,E>{//边
        E weight;
        Vertex<V,E> from;
        Vertex<V,E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
            weight = null;
        }

        @Override
        public boolean equals(Object o) {
            Edge<V,E> edge = (Edge<V,E>)o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }


}
