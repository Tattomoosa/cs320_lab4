import java.util.*;

class  AdjSetGraph<V> implements Graph<V> {
    private Map<V,Set<V>> vertices;

    public AdjSetGraph() {
        vertices = new HashMap<V,Set<V>>();
    }

    // complete the implementation by adding all the methods
    // defined in the Graph interface

    public void addVertex(V v) {
        vertices.putIfAbsent(v, new HashSet<V>());
    }
    public Iterable<V> vertices() { return vertices.keySet(); }
    public int vertexCount() { return vertices.size(); }
    public boolean hasVertex(V v) { return vertices.containsKey(v); }
    public void addEdge(V v1, V v2) {
        if (!hasVertex(v1) || !hasVertex(v2) || hasEdge(v1, v2)) return;
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }
    public Iterable<V> neighbors(V v) { return vertices.get(v); }
    public int degree(V v) { return vertices.get(v).size(); }

    // (you may also wish to add private helper methods to perform
    //  tasks that are common to several public methods)
    boolean hasEdge(V v1, V v2) {
        if (!hasVertex(v1) || !hasVertex(v2)) return false;
        return vertices.get(v1).contains(v2) && vertices.get(v2).contains(v1);
    }

    // useful for debugging, once methods are implemented
    public String toString() {
        return GraphUtils.dumpGraph(this);
    }
}



