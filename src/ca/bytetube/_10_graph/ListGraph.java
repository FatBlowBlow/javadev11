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

    @Override
    public void bfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V, E>> visited = new HashSet<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visited.add(beginVertex);

        while(!queue.isEmpty()){
            Vertex<V, E> poll = queue.poll();
            System.out.println(poll.value);
            for(Edge<V,E> outEdge : poll.outEdges){
                if (visited.contains(outEdge.to))return;
                queue.offer(outEdge.to);
                visited.add(outEdge.to);
            }
        }
    }

    public void dfsByRecursion(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V,E>> set = new HashSet<>();
        dfs(beginVertex,set);
    }

    public void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> set){
        System.out.println(beginVertex.value);
        set.add(beginVertex);
        for (Edge<V,E> edge : beginVertex.outEdges){
            if(set.contains(edge.to)) continue;
            dfs(edge.to, set);
        }

    }


    /**
     * 1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
     * 2.然后从它outEdges中选取一条边将这条边的from，to顶点按顺序再次入栈
     * 3.访问终点to
     * 4.将终点to加入到已经访问的记录里（set）
     * 5.break（不去访问outEdges中的其他边，而是访问被选取边的剩余顶点）
     * 6.弹出栈顶元素
     * @param begin
     */
    @Override
    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Stack<Vertex<V,E>> stack = new Stack<>();
        Set<Vertex<V,E>> visitedVertices = new HashSet<>();
        //1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
        stack.push(beginVertex);
        System.out.println(beginVertex.value);
        visitedVertices.add(beginVertex);
        while (!stack.isEmpty()){
            //6.弹出栈顶元素
            Vertex<V,E> vertex = stack.pop();
            //2.从它outEdges中选取一条边, 将这条边的from，to顶点按顺序再次入栈
            for (Edge<V,E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                stack.push(edge.from);
                stack.push(edge.to);
            //3.访问终点to
                System.out.println(edge.to.value);
            //4.将终点to加入到已经访问的记录里（set）
                visitedVertices.add(edge.to);
                break;
            }
        }

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
