import java.io.*;
import java.util.*;

public abstract class GraphUtils {

    static <V> Graph<V> emptyGraph() {
        return new AdjSetGraph<V>();
    }

    static <V> String dumpGraph(Graph<V> g) {
        String s = "Vertex count = " + g.vertexCount() + "\n";
        for (V v : g.vertices()) {
            s += v + ":";
            for (V w : g.neighbors(v)) 
                s += " " + w;
            s += "\n";
        }
        return s;
    }

}


