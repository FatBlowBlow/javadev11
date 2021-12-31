package ca.bytetube._10_graph;

import java.security.KeyStore;
import java.util.*;

//public class ListGraph<V,E> extends Graph<V,E> {
//
//
//    private Map<V, Vertex<V, E>> vertices = new HashMap<>();//点集
//    private Set<Edge<V, E>> edges = new HashSet<>();//边集，对于外界而言只有一条边---> Set
//
//    @Override
//    public void addVertex(V v) {
//        if (vertices.containsKey(v)) return;
//        vertices.put(v, new Vertex<>(v));
//    }
//
//    @Override
//    public void addEdge(V fromV, V toV) {
//        addEdge(fromV, toV, null);
//    }
//
//    @Override
//    public void addEdge(V from, V to, E weight) {
//        //1. 先判断from， to顶点是否存在 ----> 存在了，才能把边加进去
//        //1.1 检验点集中是否存在起点
//        Vertex<V, E> fromVertex = vertices.get(from);
//        if (fromVertex == null) {
//            fromVertex = new Vertex<>(from);
//            vertices.put(from, fromVertex);
//        }
//        //1.2 检验点集中是否存在终点
//        Vertex<V, E> toVertex = vertices.get(to);
//        if (toVertex == null) {
//            toVertex = new Vertex<>(to);
//            vertices.put(to, toVertex);
//        }
//
//        //2. 能来到这， 说明一定可以保证有起点和终点
//        //3. 接下来需要确定这两个点之间之前是否存在边
//        //4. 如果不存在，新建一个边。 如果存在，更新weight
//        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
//        edge.weight = weight;//weight初始化
//
//
////        if (fromVertex.outEdges.contains(edge)){ 如果包含这条边的话 ---> 删除
////            fromVertex.outEdges.remove(edge);
////            ...
////        }
//        //remove返回值是boolean ---> true ----> 删除成功 ----> 之前包含这条边
//        if (fromVertex.outEdges.remove(edge)) {
//            toVertex.inEdges.remove(edge);
//            edges.remove(edge);
//        }
//        fromVertex.outEdges.add(edge);
//        toVertex.inEdges.add(edge);
//        edges.add(edge);
//    }
//
//    @Override
//    public void removeEdge(V from, V to) {
//        //判空操作
//        Vertex<V, E> fromVeVertex = vertices.get(from);
//        if (fromVeVertex == null) return;
//        Vertex<V, E> toVeVertex = vertices.get(from);
//        if (toVeVertex == null) return;
//
//        //能来到这，说明起点和终点都存在，但是不代表两个顶点之间存在连线
//        Edge<V, E> edge = new Edge<>(fromVeVertex, toVeVertex);
//        if (fromVeVertex.outEdges.remove(edge)) {
//            toVeVertex.inEdges.remove(edge);
//            edges.remove(edge);
//        }
//    }
//
//    @Override
//    public void removeVertex(V v) {
//        Vertex<V, E> vertex = vertices.remove(v);//点集中先删除点
//        if (vertex == null) return;
//
////        //如果需要对容器一边遍历一边修改，一定会失败，这种操作会破坏容器的原子性。绝对不能这么写！
////
////        vertex.outEdges.forEach((Edge<V, E> edge) -> {//lambda表达式
////            removeEdge(edge.from.value, edge.to.value);
////        });
////
////        vertex.inEdges.forEach((Edge<V, E> edge) -> {
////            removeEdge(edge.from.value, edge.to.value);
////        });
//
//        //如果需要对容器一边遍历一边修改，用迭代器
//        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
//            Edge<V, E> edge = iterator.next();
//            //通过这根线作为线索，找到这根线的终点，把终点的edge.to的inEdges删除掉这根线
//            edge.to.inEdges.remove(edge);
//            iterator.remove();//起点的outEdge中删除
//            edges.remove(edge);
//        }
//
//        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
//            Edge<V, E> edge = iterator.next();
//
//            edge.from.outEdges.remove(edge);
//            iterator.remove();
//            edges.remove(edge);
//        }
//    }
//
//    @Override
//    public int verticesSize() {
//        return vertices.size();
//    }
//
//    @Override
//    public int edgesSize() {
//        return edges.size();
//    }
//
//    @Override
//    public void bfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//        Set<Vertex<V, E>> visited = new HashSet<>();//去重操作
//        Queue<Vertex<V, E>> queue = new LinkedList<>();
//        queue.offer(beginVertex);
//        visited.add(beginVertex);
//
//        while (!queue.isEmpty()) {
//            Vertex<V, E> poll = queue.poll();
//            System.out.println(poll.value);//出队即访问时刻
//
//            for (Edge<V, E> outEdge : poll.outEdges) {
//                if (visited.contains(outEdge.to)) return;
//                queue.offer(outEdge.to);
//                visited.add(outEdge.to);
//            }
//        }
//
//    }
//
//    @Override
//    public void bfs(V begin, VertexVisitor<V> visitor) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//        Set<Vertex<V, E>> visited = new HashSet<>();
//        Queue<Vertex<V, E>> queue = new LinkedList<>();
//        queue.offer(beginVertex);
//        visited.add(beginVertex);
//
//        while (!queue.isEmpty()) {
//            Vertex<V, E> poll = queue.poll();
////            System.out.println(poll.value);
//            if (visitor.visit(poll.value)) return;
//            for (Edge<V, E> outEdge : poll.outEdges) {
//                if (visited.contains(outEdge.to)) continue;
//                queue.offer(outEdge.to);
//                visited.add(outEdge.to);
//            }
//        }
//    }
//
//    public void dfsByRecursion(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//        Set<Vertex<V, E>> set = new HashSet<>();
//        dfs(beginVertex, set);
//    }
//
//    public void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> set) {
//        System.out.println(beginVertex.value);
//        set.add(beginVertex);
//        for (Edge<V, E> edge : beginVertex.outEdges) {
//            if (set.contains(edge.to)) continue;
//            dfs(edge.to, set);
//        }
//
//    }
//
//    /**
//     * 1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
//     * 2.然后从它outEdges中选取一条边将这条边的from，to顶点按顺序再次入栈
//     * 3.访问终点to
//     * 4.将终点to加入到已经访问的记录里（set）
//     * 5.break（不去访问outEdges中的其他边，而是访问被选取边的剩余顶点）
//     * 6.弹出栈顶元素
//     *
//     * @param begin
//     */
//    @Override
//    public void dfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//        Stack<Vertex<V, E>> stack = new Stack<>();
//        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
//        //1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
//        stack.push(beginVertex);
//        System.out.println(beginVertex.value);
//        visitedVertices.add(beginVertex);
//        while (!stack.isEmpty()) {
//            //6.弹出栈顶元素
//            Vertex<V, E> vertex = stack.pop();
//            //2.从它outEdges中选取一条边, 将这条边的from，to顶点按顺序再次入栈
//            for (Edge<V, E> edge : vertex.outEdges) {
//                if (visitedVertices.contains(edge.to)) continue;
//                stack.push(edge.from);
//                stack.push(edge.to);
//                //3.访问终点to
//                System.out.println(edge.to.value);
//                //4.将终点to加入到已经访问的记录里（set）
//                visitedVertices.add(edge.to);
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public void dfs(V begin, VertexVisitor<V> visitor) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//        Stack<Vertex<V, E>> stack = new Stack<>();
//        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
//        //1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
//        stack.push(beginVertex);
//        if (visitor.visit(beginVertex.value)) return;
//        visitedVertices.add(beginVertex);
//        while (!stack.isEmpty()) {
//            //6.弹出栈顶元素
//            Vertex<V, E> vertex = stack.pop();
//            //2.从它outEdges中选取一条边, 将这条边的from，to顶点按顺序再次入栈
//            for (Edge<V, E> edge : vertex.outEdges) {
//                if (visitedVertices.contains(edge.to)) continue;
//                stack.push(edge.from);
//                stack.push(edge.to);
//                //3.访问终点to
//                if (visitor.visit(edge.to.value)) return;
//                //4.将终点to加入到已经访问的记录里（set）
//                visitedVertices.add(edge.to);
//                break;
//            }
//        }
//    }
//
//
//    /**
//     * 1.准备一个queue（缓存区）， 一个list（装排序后结果），一个map（结构映射表）
//     * 2.将图中 inEdge=0 的点先入队queue，不为0的点放入map中记录Vertex和inEdge
//     * 3.queue顶点出队，装入list中， 更新该顶点outEdges所对应点的inEdge的信息
//     * 4.观察map中更新后的顶点中是否有 inEdge=0 的点，如果有装入queue
//     * 5.不断重复3，4直至queue为空
//     *
//     * @return
//     */
//    public List<V> topologicalSort() {
//        List<V> list = new LinkedList<>();
//        Queue<Vertex<V, E>> queue = new LinkedList<>();
//        Map<Vertex<V, E>, Integer> ins = new HashMap<>();
//        //2.将图中inEdge=0的顶点都先装入queue，不为0的点放入map
//        for (Map.Entry<V, Vertex<V, E>> entry : vertices.entrySet()) {
//            int in = entry.getValue().inEdges.size();
//            if (in == 0) {
//                queue.offer(entry.getValue());
//            } else {
//                ins.put(entry.getValue(), in);
//            }
//        }
////        //lambda
////        vertices.forEach((V v, Vertex<V,E>) vertex)-> {
////            int in = vertex.inEdges.size();
////            if (in == 0) {
////                queue.offer(vertex);
////            }else {
////                ins.put(vertex, in);
////            }
////        });
//
//        //5.不断重复3,4直至queue为空
//        while (!queue.isEmpty()) {
//            //3.queue顶点出队，装入list中， 更新该顶点outEdges所对应点的inEdge的信息
//            Vertex<V, E> vertex = queue.poll();
//            list.add(vertex.value);
//            for (Edge<V, E> edge : vertex.outEdges) {
//                int toIn = ins.get(edge.to) - 1;
//                ins.put(edge.to, toIn);
//                //4.观察map中更新后的顶点中是否有 inEdge=0 的点，如果有装入queue
//                if (toIn == 0) {
//                    queue.offer(edge.to);
//                } else {
//                    ins.put(edge.to, toIn);
//                }
//            }
//        }
//        return list;
//    }
//
//    @Override
//    public Set<EdgeInfo<V, E>> mst() {
//        return prim();
//    }
//
//    private Comparator<Edge<V, E>> edgeComparator = new Comparator<Edge<V, E>>() {
//        @Override
//        public int compare(Edge<V, E> e1, Edge<V, E> e2) {
//            return weightManager.compare(e1.weight, e2.weight);
//        }
//    };
//
//
//    private Set<EdgeInfo<V, E>> prim() {
//        //1.mst的边集，set A
//        Set<Edge<V, E>> edgeInfos = new HashSet<>();
//        //2.mst的点集, S
//        Set<Vertex<V, E>> addedVertices = new HashSet<>();
//
//        //3.拿到A点
////        Vertex<V, E> vertex = vertices.values().iterator().next();
////        System.out.println(vertex);
//        Iterator<Vertex<V, E>> iterator = vertices.values().iterator();
//        if (!iterator.hasNext()) return null;
//        Vertex<V, E> vertex = iterator.next();//A点
//        addedVertices.add(vertex);//A点加入到S点集
//
//        //4.边中选最小的
//        //nlogn
////        PriorityQueue<Edge<V,E>> heap = new PriorityQueue<>(edgeComparator);
////        for (Edge<V,E> edge : vertex.outEdges) {
////            heap.offer(edge);
////        }
//        //O(n)
////        MinHeap<Edge<V,E>> heap = new MinHeap<>(vertex.outEdges, edgeComparator);
////        while(!heap.isEmpty() && addedVertices.size() < vertices.size()){
////            //4.1 heap中找到weight最小的边
////            Edge<V,E> edge = heap.remove();
////
////            //4.5 对最小边做判断， 是否重复？
////            if (addedVertices.contains(edge.to)) continue;
////
////            //4.2 AB边加入Set A
////            edgeInfos.add(edge.info());
////            //4.3 B点加入S点集
////            addedVertices.add(edge.to);
////
////            //4.4 将B的所有outEdges放入到heap中， 继续寻找最小的横切边
////            heap.addAll(edge.to.outEdges);//因为是无向图，会有重复边
////        }
////
////        return edgeInfos;
////    }
////
////    private Set<EdgeInfo<V, E>> kruskal(){
////        int edgeSize = vertices.size();
////        //mst的边集
////        Set<Edge<V, E>> edgeInfos = new HashSet<>();
////
////        MinHeap<Edge<V,E>> heap = new MinHeap<>(edges, edgeComparator);
////
////        UnionFind<Vertex<V,E>> unionFind = new UnionFind<>();
////        vertices.forEach((V v, Vertex<V,E> vertex)->{
////            unionFind.makeSet(vertex);
////    });
////        while(!heap.isEmpty() && edgeInfos.size() < edgeSize - 1){
////            Edge<V, E> remove = heap.remove();
////            if(unionFind.isSame(remove.to, remove.from)) continue;
////            edgeInfos.add(remove.info());
////            unionFind.uion(remove.from, remove.to);
////        }
////        return edgeInfos;
////    }
//
//
//        @Override
//        public Map<V, E> shortestPath (V begin){
//            Vertex<V, E> beginVertex = vertices.get(begin);
//            if (beginVertex == null) return null;
//        /*
//        Map<V,E> paths = new HashMap<>();
//        paths.put("B",10);
//        paths.put("C",40);
//        paths.put("D",30);
//        paths.put("E",80);
//        选出当A起飞后的最小路径("B",10)
//        B点还在map中，下次再选的时候，最小值可能还是a到b
//        一个map不够，需要再做一个容器，用来保存已经走过的路
//        selectedPaths.put("B",10)
//        从paths.remove（"B")
//        对B点所有的outEdges进行一次relaxation(更新其他点到源点的最短路径信息）
//         */
//
//            Map<Vertex<V, E>, E> paths = new HashMap();
//            Map<V, E> selectedPaths = new HashMap();
//
//
//            //1.从起点出发，找到最小路径->确定下次起飞的点
//            getMinPath(paths);
//
//            return selectedPaths;
//        }
//
//        /**
//         * 从给定的一个顶点的outEdge中选取最小的路径信息
//         * @param paths
//         */
//
//        private void getMinPath (Map < Vertex < V, E >, E > paths){
//            Vertex<V, E> minVertex = null;
//            E minWeight = null;
//            for (Map.Entry<Vertex<V, E>, E> entry : paths.entrySet()) {
//                E weight = entry.getValue();
//                if (weightManager.compare(weight, minWeight) < 0) {
//                    minVertex = entry.getKey();
//                    minWeight = weight;
//
//                }
//            }
//
//        }
//
//
//        public void print () {
//            System.out.println("[vertex]-------------------");
//            vertices.forEach((V v, Vertex<V, E> vertex) -> {
//                System.out.println(v);
//                System.out.println("out-----------");
//                System.out.println(vertex.outEdges);
//                System.out.println("in-----------");
//                System.out.println(vertex.inEdges);
//            });
//
//            System.out.println("[edge]-------------------");
//            edges.forEach((Edge<V, E> edge) -> {
//                System.out.println(edge);
//            });
//        }
//
//        private static class Vertex<V, E> {//点
//            V value;
//            Set<Edge<V, E>> inEdges = new HashSet<>();
//            Set<Edge<V, E>> outEdges = new HashSet<>();
//
//            public Vertex(V value) {//有些图没有边，所以只构造value
//                this.value = value;
//            }
//
//            @Override
//            public boolean equals(Object o) {//把点比较清楚就行
//                return Objects.equals(value, ((Vertex<V, E>) o).value);
//            }
//
//            @Override
//            public int hashCode() {
//                return value == null ? 0 : value.hashCode();
//
//            }
//
//            @Override
//            public String toString() {
//                return value == null ? "null" : value.toString();
//            }
//        }
//
//        private static class Edge<V, E> {//边
//            E weight;
//            Vertex<V, E> from;
//            Vertex<V, E> to;
//
//            public Edge(Vertex<V, E> from, Vertex<V, E> to) {//边需要起点和终点
//                this.from = from;
//                this.to = to;
//                weight = null;//默认值null，自己赋值
//            }
//
//            @Override
//            public boolean equals(Object o) {
//                Edge<V, E> edge = (Edge<V, E>) o;
//                return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
//            }
//
//            @Override
//            public int hashCode() {
//                return from.hashCode() * 31 + to.hashCode();
//            }
//
//            @Override
//            public String toString() {
//                return "Edge{" +
//                        "weight=" + weight +
//                        ", from=" + from +
//                        ", to=" + to +
//                        '}';
//            }
//
//
//            public EdgeInfo<V, E> info() {
//                return new EdgeInfo(from.value, to.value, weight);
//            }
//        }
//
//    }
//}
