package ca.bytetube._10_graph;

import java.util.List;

public class Main {

//    public static void main(String[] args) {
//          test();
//        testBFS();
//        testDFS();
//
//    }
//
//    public static void testTopologicalSort(){
//        Graph<Object, Double> graph = directedGraph(Data.TOPO);
//        List<Object> list = ((ListGraph<Object, Double>) graph).topologicalSort();
//        System.out.println(list);
//    }
//
//
//    public static void testDFS(){
//        ListGraph<Object, Double> graph = (ListGraph<Object, Double>) undirectedGraph(Data.DFS_01);
//        graph.dfsByRecursion(1);
//    }
//
//
//    public static void testBFS(){
//        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);
//        graph.bfs("A");
//    }
//
//
//    public static void testBFS1(){
//        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);
//        graph.bfs("A", new Graph.VertexVisitor<Object>() {
//            @Override
//            public boolean visit(Object o) {
//                System.out.println(o);
////                return false;//不限制的跑， 和不加visitor结果一样
//                return o.equals("E");
//            }
//        });
//    }
//
//    static void test() {
//        ListGraph<String, Integer> graph = new ListGraph<>();
////		graph.addEdge("V0", "V1");
////		graph.addEdge("V1", "V0");
////
////		graph.addEdge("V0", "V2");
////		graph.addEdge("V2", "V0");
////
////		graph.addEdge("V0", "V3");
////		graph.addEdge("V3", "V0");
////
////		graph.addEdge("V1", "V2");
////		graph.addEdge("V2", "V1");
////
////		graph.addEdge("V2", "V3");
////		graph.addEdge("V3", "V2");
////
////		graph.print();
//
//        graph.addEdge("V1", "V0", 9);
//        graph.addEdge("V1", "V2", 3);
//        graph.addEdge("V2", "V0", 2);
//        graph.addEdge("V2", "V3", 5);
//        graph.addEdge("V3", "V4", 1);
//        graph.addEdge("V0", "V4", 6);
//
//        //graph.removeEdge("V0", "V4");
//        graph.removeVertex("V0");
//
//        graph.print();
//    }
//
//
//    static Graph.WeightManager<Double> weightManager = new Graph.WeightManager<Double>() {
//        @Override
//        public int compare(Double w1, Double w2) {
//            return w1.compareTo(w2);
//        }
//
//        @Override
//        public Double add(Double w1, Double w2) {
//            return null;
//        }
//
//        @Override
//        public Double zero() {
//            return null;
//        }
//    };
//
//
//
//    public static Graph<Object, Double> directedGraph(Object[][] data){
//        Graph<Object, Double> graph = new ListGraph<>();
//        for (Object[] edge : data){
//            if(edge.length == 1){//长度为1
//                graph.addVertex(edge[0]);
//            }else if(edge.length == 2){//长度为2，有起点和终点
//                graph.addEdge(edge[0],edge[1]);
//            }else if(edge.length == 3){//长度为3，加入了权重
//                double weight = Double.parseDouble(edge[2].toString());
//                graph.addEdge(edge[0],edge[1],weight);
//            }
//        }
//        return graph;
//    }
//
//
//    public static Graph<Object, Double> undirectedGraph(Object[][] data){
//        Graph<Object, Double> graph = new ListGraph<>();
//        for (Object[] edge : data){
//            if(edge.length == 1){
//                graph.addVertex(edge[0]);
//            }else if(edge.length == 2){
//                //互为起点 终点
//                graph.addEdge(edge[0],edge[1]);
//                graph.addEdge(edge[1],edge[0]);
//            }else if(edge.length == 3){
//                double weight = Double.parseDouble(edge[2].toString());
//                graph.addEdge(edge[0],edge[1],weight);
//                graph.addEdge(edge[1],edge[0],weight);
//            }
//        }
//        return graph;
    }
//}



