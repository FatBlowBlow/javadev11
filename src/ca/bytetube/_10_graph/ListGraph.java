package ca.bytetube._10_graph;

import java.util.*;

public class ListGraph<V,E> extends Graph<V,E> {

    //因为父类Graph<V,E>中,提供了无参和单参的构造方法
    public ListGraph() { }

    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }

    private static class Vertex<V, E> {//点
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {//有些图没有边，所以只构造value
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {//把点比较清楚就行
            return Objects.equals(value, ((Vertex<V, E>) o).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }

    private static class Edge<V, E> {//边
        E weight;
        Vertex<V, E> from;
        Vertex<V, E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {//边需要起点和终点
            this.from = from;
            this.to = to;
            weight = null;//默认值null，自己赋值
        }

        @Override
        public boolean equals(Object o) {
            Edge<V, E> edge = (Edge<V, E>) o;
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

        public EdgeInfo<V, E> info() {
            return new EdgeInfo(from.value, to.value, weight);
        }

    }

    private Map<V, Vertex<V, E>> vertices = new HashMap<>();//点集
    private Set<Edge<V, E>> edges = new HashSet<>();//边集，对于外界而言只有一条边---> Set

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
        //1. 先判断from,to这两个顶点是否存在 ----> 存在了，才能把边加进去
        //1.1 检验点集中是否存在起点,不存在的话新建起点
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        //1.2 检验点集中是否存在终点,不存在的话新建终点
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        //2. 能来到这, 说明一定可以保证有起点和终点
        //2.1. 接下来需要确定这2个点之间之前是否存在边
        //2.2. 如果不存在，新建一个边. 如果存在，更新weight
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;//weight初始化

//        if (fromVertex.outEdges.contains(edge)){//如果包含这条边的话 ---> 删除
//            fromVertex.outEdges.remove(edge);
//            toVertex.inEdges.remove(edge);
//            edges.remove(edge);
//        }
        //remove返回值是boolean ---> true ----> 删除成功 ----> 之前包含这条边, 省一次contains判断
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    /**
     * 物理删除: edges中删除
     * 逻辑删除: fromVertex.outEdges中删除, toVertex.inEdges中删除
     */
    @Override
    public void removeEdge(V from, V to) {
        //判空操作
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        //能来到这，说明起点和终点都存在，尽管2个顶点都存在，但是不代表两个顶点之间存在连线
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    /**
     * 物理删除: vertices中删除, edges中删除
     * 逻辑删除: 维护其他相关点的outEdges,inEdges中信息
     */
    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);//点集vertices中先删除点
        if (vertex == null) return;

        //如果需要对容器一边遍历一边修改，一定会失败，这种操作会破坏容器的原子性。绝对不能这么写！
//        vertex.outEdges.forEach((Edge<V, E> edge) -> {//lambda表达式
//            removeEdge(edge.from.value, edge.to.value);
//            edges.remove(edge);
//        });
//
//        vertex.inEdges.forEach((Edge<V, E> edge) -> {
//            removeEdge(edge.from.value, edge.to.value);
//            edges.remove(edge);
//        });

        //如果需要对容器一边遍历一边修改，用迭代器(线程安全，带锁)
        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            //通过这根线作为线索，找到这根线的终点，把终点的edge.to的inEdges删除掉这根线
            edge.to.inEdges.remove(edge);
            iterator.remove();//起点的outEdge中删除
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
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
        Set<Vertex<V, E>> visitedVertex = new HashSet<>();//去重操作
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertex.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
            System.out.println(poll.value);//出队即访问时刻

            for (Edge<V, E> outEdge : poll.outEdges) {
                if (visitedVertex.contains(outEdge.to)) continue;
                queue.offer(outEdge.to);
                visitedVertex.add(outEdge.to);
            }
        }

    }

    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V, E>> visited = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visited.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
//            System.out.println(poll.value);
            if (visitor.visit(poll.value)) return;
            for (Edge<V, E> outEdge : poll.outEdges) {
                if (visited.contains(outEdge.to)) continue;
                queue.offer(outEdge.to);
                visited.add(outEdge.to);
            }
        }
    }

    //dfs: recursive
    public void dfsByRecursion(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        //set放在调用函数里边,动态传参.如果放在dfs()中,每次递归都会创建一个新的set
        Set<Vertex<V, E>> set = new HashSet<>();
        dfs(beginVertex, set);
    }

    public void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> set) {
        System.out.println(beginVertex.value);
        set.add(beginVertex);
        for (Edge<V, E> edge : beginVertex.outEdges) {
            if (set.contains(edge.to)) continue;
            dfs(edge.to, set);
        }

    }

    /**
     * dfs: non-recursive
     * 1.先将起点入栈,并访问(打印),然后加入到已经访问的记录里（set）
     * 2.弹出栈顶元素
     * 3.从它outEdges中选取一条边,将这条边的from，to顶点按顺序再次入栈
     * 4.访问终点to
     * 5.将终点to加入到已经访问的记录里（set）
     * 6.break（不去访问outEdges中的其他边，而是访问被选取边的剩余顶点）
     * 7.弹出栈顶元素
     */
    @Override
    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Stack<Vertex<V, E>> stack = new Stack<>();
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        //1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
        stack.push(beginVertex);
        System.out.println(beginVertex.value);
        visitedVertices.add(beginVertex);
        while (!stack.isEmpty()) {
            //2&7.弹出栈顶元素
            Vertex<V, E> vertex = stack.pop();
            //3.从弹出的vertex的outEdges中选取一条边, 将这条边的from，to顶点按顺序再次入栈
            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                stack.push(edge.from);
                stack.push(edge.to);
                //4.访问终点to
                System.out.println(edge.to.value);
                //5.将终点to加入到已经访问的记录里（set）
                visitedVertices.add(edge.to);
                break;
            }
        }
    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Stack<Vertex<V, E>> stack = new Stack<>();
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        //1.先将起点入栈，并访问（打印），然后加入到已经访问的记录里（set）
        stack.push(beginVertex);
        if (visitor.visit(beginVertex.value)) return;
        visitedVertices.add(beginVertex);
        while (!stack.isEmpty()) {
            //6.弹出栈顶元素
            Vertex<V, E> vertex = stack.pop();
            //2.从它outEdges中选取一条边, 将这条边的from，to顶点按顺序再次入栈
            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                stack.push(edge.from);
                stack.push(edge.to);
                //3.访问终点to
                if (visitor.visit(edge.to.value)) return;
                //4.将终点to加入到已经访问的记录里（set）
                visitedVertices.add(edge.to);
                break;
            }
        }
    }


    /**
     * 1.准备一个queue（缓存区）， 一个list（装排序后结果），一个map（结构映射表）
     * 2.将图中 inEdge=0 的点先入队queue，inEdge不为0的点放入map中记录Vertex和inEdge的信息
     * 3.queue顶点出队，装入list中， 更新该顶点outEdges所对应点的inEdge的信息
     * 4.观察map中更新后的顶点中是否有 inEdge=0 的点，如果有装入queue
     * 5.不断重复3，4直至queue为空
     *
     * 外界不知道List中装的是Vertex，只知道是Value，所以返回V
     */
    public List<V> topologicalSort() {
        List<V> list = new LinkedList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Map<Vertex<V, E>, Integer> map = new HashMap<>();
        //2.将图中inEdge=0的顶点都先装入queue，不为0的点放入map
        for (Map.Entry<V, Vertex<V, E>> entry : vertices.entrySet()) {
            int in = entry.getValue().inEdges.size();
            if (in == 0) {
                queue.offer(entry.getValue());
            }else {
                map.put(entry.getValue(), in);
            }
        }
        //lambda = for loop
//        vertices.forEach((V v, Vertex<V,E> vertex)-> {
//            int in = vertex.inEdges.size();
//            if (in == 0) {
//                queue.offer(vertex);
//            }else {
//                map.put(vertex, in);
//            }
//        });

        //5.不断重复3,4直至queue为空
        while (!queue.isEmpty()) {
            //3.queue顶点出队，装入list中， 更新该顶点outEdges所对应点的inEdge的信息
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);
            for (Edge<V, E> edge : vertex.outEdges) {
                int toIn = map.get(edge.to) - 1;
                //4.观察map中更新后的顶点中是否有 inEdge=0 的点，如果有装入queue
                if (toIn == 0) {
                    queue.offer(edge.to);
                }else {
                    map.put(edge.to, toIn);
                }
            }
        }
        return list;
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
//        return prim();
        return kruskal();
    }

    private Set<EdgeInfo<V, E>> prim() {
        //1.mst的边集，set A
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        //2.mst的点集, set S
        Set<Vertex<V, E>> addedVertices = new HashSet<>();

        //3.拿到A点
        //代码有问题,iterator()出来的集合有可能是空的，必须进行判断
//        Vertex<V, E> vertex = vertices.values().iterator().next();
//        System.out.println(vertex);
        Iterator<Vertex<V, E>> iterator = vertices.values().iterator();
        if (!iterator.hasNext()) return null;
        Vertex<V, E> vertex = iterator.next();//A点
        addedVertices.add(vertex);//A点加入到S点集

        //4.边中选最小的 --> miniHeap --> Java内部提供了堆结构: PriorityQueue ---> nlogn
//        //1. 遍历outEdge并加入heap,最后弹堆顶,找出最小值
//        PriorityQueue<Edge<V,E>> heap = new PriorityQueue<>(edgeComparator);
//        for (Edge<V,E> edge : vertex.outEdges) {
//            heap.offer(edge);
//        }
        //2. 优化 --> heapify() --> O(n)
        MinHeap<Edge<V,E>> heap = new MinHeap<>(vertex.outEdges, edgeComparator);
        while(!heap.isEmpty() && addedVertices.size() < vertices.size()){
            //4.1 heap中找到weight最小的边
            Edge<V,E> minEdge = heap.remove();
            //4.5 heap.addAll(minEdge.to.outEdges)时会有重复边,对最小边做判断,是否重复？
            if (addedVertices.contains(minEdge.to)) continue;
            //4.2 AB边加入Set A边集
            edgeInfos.add(minEdge.info());
            //4.3 B点加入S点集
            addedVertices.add(minEdge.to);
            //4.4 将AB组成的集体的所有outEdges放入到heap中, 因为A的outEdges已经加入了,这次只加B,继续寻找最小的横切边
            heap.addAll(minEdge.to.outEdges);//因为是无向图,会有重复边,AB BA,所以下一次取到minEdge,要判断去重
        }
        return edgeInfos;
    }

    //定义为内部属性, 可以直接用, 不用重复创建对象, 节省空间
    private Comparator<Edge<V, E>> edgeComparator = new Comparator<Edge<V, E>>() {
        @Override
        public int compare(Edge<V, E> e1, Edge<V, E> e2) {
            return weightManager.compare(e1.weight, e2.weight);
        }
    };

    private Set<EdgeInfo<V, E>> kruskal(){
        int edgeSize = vertices.size();
        //mst,最小生成树的边集信息
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        //边集全部拿过来,排序
        MinHeap<Edge<V,E>> heap = new MinHeap<>(edges, edgeComparator);
        //每一个Vertex是一个部落，通过点查看是否在一个部落 --> 连通
        UnionFind<Vertex<V,E>> unionFind = new UnionFind<>();
        //lambda 遍历点集 --> 每一个遍历出来的vertex，做成一个部落 makeSet()
        vertices.forEach((V v, Vertex<V,E> vertex)->{
            unionFind.makeSet(vertex);
        });
        while(!heap.isEmpty() && edgeInfos.size() < edgeSize - 1){
            Edge<V, E> remove = heap.remove();//弹出 权值最小的边
            if(unionFind.isSame(remove.to, remove.from)) continue;
            edgeInfos.add(remove.info());//添加边
            unionFind.union(remove.from, remove.to);//边的起点和终点进行部落融合union()
        }
        return edgeInfos;
    }


    //初始版本
    @Override
    public Map<V, E> shortestPath(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);//A点
        if (beginVertex == null) return null;
        /*
        Map<V,E> paths = new HashMap<>();
        paths.put("B",10);
        paths.put("C",40);
        paths.put("D",30);
        paths.put("E",80);
        选出当A起飞后的最小路径("B",10)
        B点还在map中，下次再选的时候，最小值可能还是a到b
        所以一个map不够，需要再做一个容器，用来保存已经走过的路
        selectedPaths.put("B",10)
        从paths.remove（"B"), 说明B点已经起飞
        对B点所有的outEdges进行一次relaxation(更新其他点到源点的最短路径信息）
         */
        Map<Vertex<V, E>, E> paths = new HashMap();
        Map<V, E> selectedPaths = new HashMap();

        //初始化paths ---> B,D,E先放进paths中
        for (Edge<V, E> edge : beginVertex.outEdges) {
            paths.put(edge.to, edge.weight);
        }

        //从起点出发，找到最小路径 -> 确定下次起飞的点
        while (!paths.isEmpty()){
            Map.Entry<Vertex<V, E>, E> minEntry = getMinPath(paths);//("B",10)
            Vertex<V, E> minVertex = minEntry.getKey();
            selectedPaths.put(minVertex.value, minEntry.getValue());//B点一定起飞
            paths.remove(minVertex);

            //对B点所有的outEdges进行一次relaxation
            for (Edge<V, E> outEdge : minVertex.outEdges) {
                if (selectedPaths.containsKey(outEdge.to.value)) continue;//针对undirected graph
                //relaxation
                //分别需要得到新的weight和老的weight，然后比较大小
                //如果newWeight < oldWeight 更新paths
                //如果newWeight >= oldWeight 不更新paths
                //1. 算出newWeight
                E newWeight = weightManager.add(minEntry.getValue(), outEdge.weight);
                //2. 算出oldWeight
                E oldWeight = paths.get(outEdge.to);//A --> C
                if (oldWeight == null || weightManager.compare(newWeight, oldWeight) < 0){
                    paths.put(outEdge.to, newWeight);
                }
            }
        }
        selectedPaths.remove(beginVertex.value);//针对undirected graph, 把起点"A"删除
        return selectedPaths;
    }

    /**
     * 从给定的一个顶点的outEdge中选取最小的路径信息
     */
    private Map.Entry<Vertex<V, E>, E> getMinPath(Map<Vertex<V, E>, E> paths) {
//        Vertex<V, E> minVertex = null;
//        E minWeight = null;
//        for (Map.Entry<Vertex<V, E>, E> entry : paths.entrySet()) {
//            E weight = entry.getValue();
//            if (weightManager.compare(weight, minWeight) < 0) {
//                minVertex = entry.getKey();
//                minWeight = weight;
//            }
//        }

        Iterator<Map.Entry<Vertex<V, E>, E>> iterator = paths.entrySet().iterator();
        Map.Entry<Vertex<V, E>, E> minEntry = iterator.next();
        while (iterator.hasNext()){
            Map.Entry<Vertex<V, E>, E> entry = iterator.next();
            if (weightManager.compare(entry.getValue(), minEntry.getValue()) < 0){
//                minVertex = entry.getKey();
//                minWeight = entry.getValue();
                minEntry = entry;
            }
        }
        return minEntry;
    }



    /**
     * 优化 --> 加入pathInfo信息(weight + edge)
     * dijkstra()
     * bellmanFord()
     */
    @Override
    public Map<V, PathInfo<V, E>> shortestPath02(V begin) {
//        return dijkstra(begin);//不支持负权边和负权环
        return bellmanFord(begin);//支持负权边和负权环
    }


    private Map<V, PathInfo<V, E>> dijkstra(V begin){
        Vertex<V, E> beginVertex = vertices.get(begin);//A点
        if (beginVertex == null) return null;

        Map<Vertex<V, E>, PathInfo<V,E>> paths = new HashMap();
        Map<V, PathInfo<V,E>> selectedPaths = new HashMap();

        //初始化paths ---> B,D,E先放进paths中
        for (Edge<V, E> edge : beginVertex.outEdges) {
            PathInfo<V,E> pathInfo = new PathInfo<>();
            pathInfo.weight = edge.weight;
            pathInfo.edgeInfos.add(edge.info());
            paths.put(edge.to, pathInfo);
        }
        //从起点出发，找到最小路径 -> 确定下次起飞的点
        while (!paths.isEmpty()){
            Map.Entry<Vertex<V, E>, PathInfo<V,E>> minEntry = getMinPath02(paths);//("B",(A-B,10))
            Vertex<V, E> minVertex = minEntry.getKey();
            PathInfo<V,E> minPath = minEntry.getValue();
            selectedPaths.put(minVertex.value, minEntry.getValue());//B点一定起飞
            paths.remove(minVertex);

            //对B点所有的outEdges进行一次relaxation
            for (Edge<V, E> outEdge : minVertex.outEdges) {
                if (selectedPaths.containsKey(outEdge.to.value)) continue;//针对undirected graph
                relaxationForDijkstra(outEdge, minPath, paths);
            }
        }
        selectedPaths.remove(beginVertex.value);//针对undirected graph, 把起点"A"删除
        return selectedPaths;
    }


    private Map.Entry<Vertex<V, E>, PathInfo<V,E>> getMinPath02(Map<Vertex<V, E>, PathInfo<V,E>> paths) {
        Iterator<Map.Entry<Vertex<V, E>, PathInfo<V,E>>> iterator = paths.entrySet().iterator();
        Map.Entry<Vertex<V, E>, PathInfo<V,E>> minEntry = iterator.next();
        while (iterator.hasNext()){
            Map.Entry<Vertex<V, E>, PathInfo<V,E>> entry = iterator.next();
            if (weightManager.compare(entry.getValue().weight, minEntry.getValue().weight) < 0){
                minEntry = entry;
            }
        }
        return minEntry;
    }

    private void relaxationForDijkstra(Edge<V,E> edge, PathInfo<V,E> fromPath,
                                       Map<Vertex<V, E>, PathInfo<V,E>> paths){
        //relaxation
//        //1. 算出newWeight
//        E newWeight = weightManager.add(fromPath.weight, edge.weight);
//        //2. 算出oldWeight
//        PathInfo<V, E> oldPath = paths.get(edge.to);//may be null,583代码会出现NullPointerException
//        //E oldWeight = paths.get(outEdge.to).weight;//A --> C
//        if (oldPath == null || weightManager.compare(newWeight, oldPath.weight) < 0) {
//            //update 起飞的点(B)的outEdge to的点(C),到源点(A)的最小的weight以及edgeInfo
//            //oldPath == null
//            PathInfo<V, E> path = new PathInfo<>();
//            path.weight = newWeight;//update最小的weight
//            //update A-->C edgeInfo
//            //eg. A---E =  A---D + D---E
//            path.edgeInfos.addAll(fromPath.edgeInfos);//A---D
//            path.edgeInfos.add(edge.info());//D---E
//            paths.put(edge.to, path);
//        }

        E newWeight = weightManager.add(fromPath.weight, edge.weight);
        PathInfo<V, E> oldPath = paths.get(edge.to);
        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return;
        if (oldPath == null){
            oldPath = new PathInfo<>();
            paths.put(edge.to, oldPath);
        }else{
            oldPath.edgeInfos.clear();
        }
        oldPath.weight = newWeight;
        oldPath.edgeInfos.addAll(fromPath.edgeInfos);//A---D
        oldPath.edgeInfos.add(edge.info());//D---E
    }


    private Map<V, PathInfo<V, E>> bellmanFord(V begin){
        Vertex<V, E> beginVertex = vertices.get(begin);//A
        if (beginVertex == null) return null;
        Map<V, PathInfo<V,E>> selectedPaths = new HashMap();//empty
        selectedPaths.put(begin, new PathInfo<>(weightManager.initial()));//起点A:初始化 ("A",(A->A,0)

        int count = vertices.size() - 1;
        for (int i = 0; i < count; i++) {//v-1 relaxation
            for (Edge<V,E> edge : edges) {
                PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
                if (fromPath == null) continue;
                relaxationForBellmanFord(edge, fromPath, selectedPaths);
            }
        }

        /*
        detect negative cycle:
        relaxationForBellmanFord() --> 返回值 void --> boolean
        654 return -> return false
        最后return true
         */
        //再增加一次relax，如果找到了更小的路径，那么说明graph中包含negative cycle
        for (Edge<V,E> edge : edges) {
            PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
            if (fromPath == null) continue;
            if (relaxationForBellmanFord(edge, fromPath, selectedPaths)){
                System.out.println("there is a negative cycle !");
                return null;
            }
        }

        selectedPaths.remove(beginVertex.value);
        return selectedPaths;
    }

    private boolean relaxationForBellmanFord(Edge<V,E> edge, PathInfo<V,E> fromPath,
                                          Map<V, PathInfo<V,E>> paths) {

        E newWeight = weightManager.add(edge.weight, fromPath.weight);
        PathInfo<V, E> oldPath = paths.get(edge.to.value);
        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return false;
        if (oldPath == null){
            oldPath = new PathInfo<>();
            paths.put(edge.to.value, oldPath);
        }else{
            oldPath.edgeInfos.clear();
        }
        oldPath.weight = newWeight;
        oldPath.edgeInfos.addAll(fromPath.edgeInfos);//A---D
        oldPath.edgeInfos.add(edge.info());//D---E

        return true;
    }


    /**
     * Floyd
     * multi-source
     */
    @Override
    public Map<V, Map<V, PathInfo<V, E>>> shortestPath(){
        //Map<起点, Map<终点, 起点到终点的路径信息>>
        Map<V, Map<V, PathInfo<V, E>>> paths = new HashMap<>();
        //initial paths 把图中所有的路径信息存放到paths中,默认图中点与点之间直接的连线既是最短路径
        for (Edge<V,E> edge : edges) {
            //Map<终点, 起点到终点的路径信息>             起点
            Map<V, PathInfo<V, E>> map = paths.get(edge.from.value);//A, map = null
            if (map == null) {
                map = new HashMap<>();
                paths.put(edge.from.value, map);//(A,map(null))
            }
            PathInfo<V, E> pathInfo = new PathInfo<>(edge.weight);
            pathInfo.edgeInfos.add(edge.info());
            map.put(edge.to.value, pathInfo);
        }

        vertices.forEach((V v2, Vertex<V,E> vertex2)->{
            vertices.forEach((V v1, Vertex<V,E> vertex1)->{
                vertices.forEach((V v3, Vertex<V,E> vertex3)->{
                    //update
                    //v1 --> v2 --> v3 ? v1 --> v3
                    //v1 --> v2
//                    PathInfo<V, E> path12 = paths.get(v1).get(v2);//paths.get(v1) maybe null
                    PathInfo<V, E> path12 = getPathInfo(v1, v2, paths);
                    if (path12 == null) return;
                    //v2 --> v3
//                    PathInfo<V, E> path23 = paths.get(v2).get(v3);
                    PathInfo<V, E> path23 = getPathInfo(v2, v3, paths);
                    if (path23 == null) return;
                    //v1 --> v3
//                    PathInfo<V, E> path13 = paths.get(v1).get(v3);
                    PathInfo<V, E> path13 = getPathInfo(v1, v3, paths);
                    E newWeight = weightManager.add(path12.weight, path23.weight);
                    if (path13 != null && weightManager.compare(newWeight, path13.weight) >= 0) return;
                    if (path13 == null){
                        path13 = new PathInfo<>();
                        paths.get(v1).put(v3,path13);
                    }else{
                        path13.edgeInfos.clear();
                    }
                    path13.weight = newWeight;
                    //1-->2-->3
                    path13.edgeInfos.addAll(path12.edgeInfos);
                    path13.edgeInfos.addAll(path23.edgeInfos);
                });
            });
        });
        return paths;
    }

    private PathInfo<V, E> getPathInfo(V from, V to, Map<V, Map<V, PathInfo<V, E>>> paths){
        Map<V, PathInfo<V, E>> map = paths.get(from);
        return map == null ? null : map.get(to);
    }


    public void print() {
        System.out.println("[vertex]:");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println();
            System.out.println(v);
            System.out.println("out-----------");
            System.out.println(vertex.outEdges);
            System.out.println("in-----------");
            System.out.println(vertex.inEdges);
        });
        System.out.println();
        System.out.println("[edge]:");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }

}

