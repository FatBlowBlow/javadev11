package ca.bytetube._10_graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//          test();
//        testBFS();
//        testDFS();
//        testBFS1();
//        testTopologicalSort();
//        testMST();
//        testShortestPath();
        testMultiSP();
    }


    public static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {//长度为1,只有一个点
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {//长度为2，有起点和终点
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {//长度为3，加入了权重
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }


    public static Graph<Object, Double> undirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                //互为起点 终点
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }

    public static void test() {
        ListGraph<String, Integer> graph = new ListGraph<>();
//		graph.addEdge("V0", "V1");
//		graph.addEdge("V1", "V0");
//
//		graph.addEdge("V0", "V2");
//		graph.addEdge("V2", "V0");
//
//		graph.addEdge("V0", "V3");
//		graph.addEdge("V3", "V0");
//
//		graph.addEdge("V1", "V2");
//		graph.addEdge("V2", "V1");
//
//		graph.addEdge("V2", "V3");
//		graph.addEdge("V3", "V2");
//
//		graph.print();

        graph.addEdge("V1", "V0", 9);
        graph.addEdge("V1", "V2", 3);
        graph.addEdge("V2", "V0", 2);
        graph.addEdge("V2", "V3", 5);
        graph.addEdge("V3", "V4", 1);
        graph.addEdge("V0", "V4", 6);

        //graph.removeEdge("V0", "V4");
        graph.removeVertex("V0");

        graph.print();
    }

    public static void testBFS() {
//        Graph<Object, Double> graph = directedGraph(Data.BFS_02);
//        graph.bfs(0);
        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);
        graph.bfs("A");
    }


    public static void testDFS(){
//        ListGraph<Object, Double> graph = (ListGraph<Object, Double>) undirectedGraph(Data.DFS_01);
//        graph.dfsByRecursion(1);
//        ListGraph<Object, Double> graph = (ListGraph<Object, Double>) directedGraph(Data.DFS_02);
//        graph.dfsByRecursion("a");
        ListGraph<Object, Double> graph = (ListGraph<Object, Double>) undirectedGraph(Data.DFS_01);
        graph.dfs(1);
    }


    //加入visitor
    public static void testBFS1(){
        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);
        graph.bfs("A", new Graph.VertexVisitor<Object>() {
            @Override
            public boolean visit(Object o) {
                System.out.println(o);
//                return false;//不限制的跑， 和不加visitor结果一样
                return o.equals("E");
            }
        });
    }


    public static void testTopologicalSort(){
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> list = ((ListGraph<Object, Double>) graph).topologicalSort();
        System.out.println(list);
    }

    public static void testMST(){
        Graph<Object, Double> graph = undirectedGraph(Data.MST_01);
        Set<Graph.EdgeInfo<Object, Double>> mstInfos = graph.mst();
        for (Graph.EdgeInfo<Object, Double> info : mstInfos) {
            System.out.println(info);
        }
    }

    public static void testShortestPath(){
//        Graph<Object, Double> graph = directedGraph(Data.SP);
        Graph<Object, Double> graph = directedGraph(Data.SP);
//        Map<Object, Double> sp = graph.shortestPath("A");
        Map<Object, Graph.PathInfo<Object,Double>> sp = graph.shortestPath02("A");
        if (sp == null) return;//negative cycle
        sp.forEach((Object v, Graph.PathInfo<Object,Double> path)->{
            System.out.println(v + " -- " + path);
        });

    }

    public static void testMultiSP(){
        Graph<Object, Double> graph = directedGraph(Data.SP);
        Map<Object, Map<Object, Graph.PathInfo<Object, Double>>> sp = graph.shortestPath();
        sp.forEach((Object from, Map<Object, Graph.PathInfo<Object,Double>> paths)->{
            System.out.println("from "+from+":");
            paths.forEach((Object to, Graph.PathInfo<Object,Double> path)->{
                System.out.println("to "+to+": "+path);
            });
            System.out.println();
        });

    }


    static Graph.WeightManager<Double> weightManager = new Graph.WeightManager<Double>() {
        @Override
        public int compare(Double w1, Double w2) {
            return w1.compareTo(w2);
        }

        @Override
        public Double add(Double w1, Double w2) {
            return w1 + w2;
        }

        @Override
        public Double initial() {
            return 0.0;
        }
    };


}




