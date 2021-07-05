package ca.bytetube._10_graph;

public interface Graph<V,E> {


    public int verticesSize();

    public int edgesSize();

    public void addVertex(V v);

    public void removeVertex(V v);

    public void addEdge(V fromV, V toV);

    public void addEdge(V fromV, V toV, E weight);

    public void removeEdge(V fromV, V toV);








}
